package org.example.exceptions;

import org.example.enums.ParserError;

public final class ArgumentParserException extends RuntimeException{

    public ArgumentParserException(ParserError e) {
        super(e.getMessage());
    }

}
