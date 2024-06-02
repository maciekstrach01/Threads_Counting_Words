package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

final class ParallelCounter {
    public Map<String, Integer> count(int threadCount, String fileName) {

        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(threadCount);

        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            reader.lines().parallel().forEach(line -> threadPoolExecutor.execute(new LineAsTask(line)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        threadPoolExecutor.shutdown();

        await(threadPoolExecutor);

        return new TreeMap<>(Cache.getMapOfWords());
    }

    private static void await(ThreadPoolExecutor threadPoolExecutor) {
        try {
            threadPoolExecutor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static class Cache {
        private static final Map<String, Integer> wordsAsMap = new ConcurrentHashMap<>();

        synchronized public static void addWords(List<String> words) {
            for (String word : words) {
                addWord(word);
            }
        }

        synchronized public static void addWord(String word) {

            String wordInLowerCase = word.toLowerCase();

            if (wordsAsMap.containsKey(wordInLowerCase)) {
                wordsAsMap.replace(wordInLowerCase, (wordsAsMap.get(wordInLowerCase) + 1));
            } else {
                wordsAsMap.put(wordInLowerCase, 1);
            }
        }

        synchronized public static Map<String, Integer> getMapOfWords(){
            return wordsAsMap;
        }
    }

    private static class LineAsTask implements Runnable {

        private final String line;

        public LineAsTask(String line) {
            this.line = line;
        }

        @Override
        public void run() {
            Cache.addWords(getWordsAsList());
            ThreadsInvokeCounter.count(Thread.currentThread());
        }

        private List<String> getWordsAsList() {
            final String regex = "[[ ]*|[//.]]";

            return Arrays
                    .stream(line.split(regex))
                    .filter(word -> word.length() >= 2)
                    .collect(Collectors.toList());
        }

    }
}
