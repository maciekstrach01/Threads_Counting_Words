package org.example;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

final class ThreadsInvokeCounter {

    private static final Map<Thread, Integer> threadsInvokeMap =
            new ConcurrentHashMap<>();

    synchronized public static void count(Thread thread) {

        if (threadsInvokeMap.containsKey(thread)) {
            threadsInvokeMap.replace(thread, (threadsInvokeMap.get(thread) + 1));
        } else {
            threadsInvokeMap.put(thread, 1);
        }
    }

    synchronized public static Map<Thread, Integer> getThreadsInvokeMap() {
        return Map.copyOf(threadsInvokeMap);
    }

}
