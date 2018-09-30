package es.upm.grise.profundizacion2018.sudokuverifier.Exceptions;

public class SudokuRuleVerifierException extends Exception {

    public SudokuRuleVerifierException(int formatErrorCode) {
        super("Sorry, you're violating rule #" + String.valueOf(formatErrorCode));
    }
}
