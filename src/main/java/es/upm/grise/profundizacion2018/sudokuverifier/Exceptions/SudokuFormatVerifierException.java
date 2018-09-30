package es.upm.grise.profundizacion2018.sudokuverifier;

public class SudokuVerifierException extends Exception {

    public SudokuVerifierException(int errorCode) {
        super(String.valueOf(errorCode));
    }

}
