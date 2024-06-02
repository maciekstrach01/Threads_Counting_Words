package org.example;

import org.example.exceptions.ArgumentParserException;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public final class WordCount {

    public static void main(String[] args) {
        try {
            ArgumentParser.setArgs(args);
        } catch (ArgumentParserException exception) {
            System.out.println(exception.getMessage());
            System.exit(-1);
        }

        ParallelCounter counter = new ParallelCounter();

        Map<String, Integer> result =
                counter.count(ArgumentParser.getThreadsArg(), ArgumentParser.getFileArg())
                        .entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByKey())
                        .collect(
                                Collectors.toMap(
                                        Map.Entry::getKey, Map.Entry::getValue,
                                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));


        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        ThreadsInvokeCounter
                .getThreadsInvokeMap()
                .forEach((k, v) ->
                        System.out.println("Thread " + k.getName().substring(k.getName().length() - 1) + ": " + v));
    }
}