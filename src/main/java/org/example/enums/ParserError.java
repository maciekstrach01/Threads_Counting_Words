package org.example.enums;

public enum ParserError {

    WRONG_NUMBER_OF_ARGUMENTS("\nBledna liczba argumentow wejsciowych. \n" +
            "Instrukcja prawidlowej komendy: java -jar WordCount.jar <NUMBER_OF_THREADS> <FILE_NAME>\n"),

    NO_FILE_FOUND("\nINPUT ERROR: Podana nazwa pliku nie zostala odnaleziona w biezacym katalogu.\n"),

    WRONG_VALUE_FOR_THREADS_NUMBER("\nINPUT ERROR: Podana liczba watkow jest nieprawidlowa.\n");

    private final String message;

    ParserError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
