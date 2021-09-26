package com.biz.censusanalyser.exception;

public class CensusAnalyserException extends Exception {

    String message;
    public ExceptionType type;

    public CensusAnalyserException(String message, ExceptionType type) {
        this.message=message;
        this.type = type;
    }
    public enum ExceptionType {
         RUN_TIME_EXCEPTION,CSV_FILE_PROBLEM
    }
}
