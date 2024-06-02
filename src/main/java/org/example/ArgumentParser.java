package org.example;

import org.example.enums.ParserError;
import org.example.exceptions.ArgumentParserException;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

final class ArgumentParser {

    private static final byte THREADS_ARG = 0;

    private static final byte FILE_ARG = 1;

    private static final byte TOTAL_ARGS = 2;

    private static final byte THREADS_MIN = 1;

    private static final List<String> verifiedArgs = new ArrayList<>();

    public static void setArgs(String[] args) {
        if(args.length != 0) {
            checkInputArgs(args);
            verifiedArgs.addAll(Arrays.stream(args).collect(Collectors.toList()));
        } else {
            throw new RuntimeException();
        }
    }

    public static Integer getThreadsArg() {
        return Integer.valueOf(verifiedArgs.get(THREADS_ARG));
    }

    public static String getFileArg() {
        return verifiedArgs.get(FILE_ARG);
    }

    public static void checkInputArgs(String[] args) {
        verifyNumberOfArgs(args);
        checkThreadCount(args);
        verifyFileArg(args);
    }

    private static void checkThreadCount(String[] args) {
        int threadCount;
        try {
            threadCount = Integer.parseInt(args[0]);
            if (threadCount < THREADS_MIN) {
                throw new ArgumentParserException(ParserError.WRONG_VALUE_FOR_THREADS_NUMBER);
            }
        } catch (NumberFormatException e){
            throw new ArgumentParserException(ParserError.WRONG_VALUE_FOR_THREADS_NUMBER);
        }
    }

    private static void verifyFileArg(String[] args) {
        File file = new File(args[1]);
        if(!file.exists())
            throw new ArgumentParserException(ParserError.NO_FILE_FOUND);
    }

    private static void verifyNumberOfArgs(String[] args) {
        if(args.length != TOTAL_ARGS)
            throw new ArgumentParserException(ParserError.WRONG_NUMBER_OF_ARGUMENTS);
    }

}
