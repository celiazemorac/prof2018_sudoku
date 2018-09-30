package es.upm.grise.profundizacion2018.sudokuverifier.Board;

import es.upm.grise.profundizacion2018.sudokuverifier.Exceptions.ErrorCodes;
import es.upm.grise.profundizacion2018.sudokuverifier.Exceptions.SudokuRuleVerifierException;
import es.upm.grise.profundizacion2018.sudokuverifier.SudokuVerifier;

public class Celd {

    private int numericalValue;

    public Celd(){}

    public Celd(int numericalValue){
        this.numericalValue = numericalValue;
    }

    public int getNumericalValue() {
        return numericalValue;
    }

    public void setNumericalValue(int candidateValue) throws SudokuRuleVerifierException {
        if (belongsToTheNumericalRange(candidateValue)) {
            this.numericalValue = candidateValue;
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

    private boolean belongsToTheNumericalRange(int candidateValue){
        return candidateValue >= SudokuVerifier.MIN_VALUE_OF_NUMERICAL_RANGE
                && candidateValue <= SudokuVerifier.MAX_VALUE_OF_NUMERICAL_RANGE;
    }

}
