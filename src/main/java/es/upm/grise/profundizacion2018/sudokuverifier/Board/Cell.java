package es.upm.grise.profundizacion2018.sudokuverifier.Board;

import es.upm.grise.profundizacion2018.sudokuverifier.Exceptions.ErrorCodes;
import es.upm.grise.profundizacion2018.sudokuverifier.Exceptions.SudokuFormatVerifierException;
import es.upm.grise.profundizacion2018.sudokuverifier.Exceptions.SudokuRuleVerifierException;
import es.upm.grise.profundizacion2018.sudokuverifier.SudokuVerifier;

public class Cell{

    private int numericalValue;
    private boolean untouchable;

    public Cell(){
        this.numericalValue = 0;
        this.untouchable = false;
    }

    public Cell(int numericalValue){
        this.numericalValue = numericalValue;
    }

    public int getNumericalValue() {
        return numericalValue;
    }

    public void setNumericalValue(int candidateValue) throws SudokuRuleVerifierException,
            SudokuFormatVerifierException {
        if (belongsToTheNumericalRange(candidateValue)) {
            if (isUntouchable()) throw new SudokuFormatVerifierException(ErrorCodes.ERROR_CODE_UNTOUCHABLE_CELL,
                    "you have modified a untouchable cell.\n Please check out your candidate solution.");
            else this.numericalValue = candidateValue;
        } else {
            throw new SudokuRuleVerifierException(ErrorCodes.ERROR_CODE_R1);
        }
    }

    public void assignValueToForce(int numericalValue){
        this.numericalValue = numericalValue;
    }

    public void clear(){
        this.numericalValue = 0;
    }

    public boolean isEmpty(){
        return this.numericalValue == 0;
    }

    public boolean isUntouchable() {
        return this.untouchable;
    }

    public void doUntouchable(){
        this.untouchable = true;
    }

    private boolean belongsToTheNumericalRange(int candidateValue){
        return candidateValue >= SudokuVerifier.MIN_VALUE_OF_NUMERICAL_RANGE
                && candidateValue <= SudokuVerifier.MAX_VALUE_OF_NUMERICAL_RANGE;
    }

}
