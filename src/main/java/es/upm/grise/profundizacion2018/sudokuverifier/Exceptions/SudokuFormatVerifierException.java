package es.upm.grise.profundizacion2018.sudokuverifier.Exceptions;

public class SudokuFormatVerifierException extends Exception {


    public SudokuFormatVerifierException(int formatErrorCode, String message) {
        super("Sorry, your solution's format not is correct, your code error is (" +
                String.valueOf(formatErrorCode) + ") " + message);
    }

}
