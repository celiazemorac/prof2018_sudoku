package es.upm.grise.profundizacion2018.sudokuverifier.Board;

import es.upm.grise.profundizacion2018.sudokuverifier.Exceptions.ErrorCodes;
import es.upm.grise.profundizacion2018.sudokuverifier.Exceptions.SudokuFormatVerifierException;
import es.upm.grise.profundizacion2018.sudokuverifier.Exceptions.SudokuRuleVerifierException;

public class SubBoard {

    private Cell[][] cells;
    public static final int DIMENSION = 3; // 3x3

    public SubBoard(){
        this.cells = new Cell[DIMENSION][DIMENSION];
        create();
    }

    public int getCellValue(int row, int column){
        return this.cells[row][column].getNumericalValue();
    }

    public void assignValueToCeld(int candidateValue, int row, int column) throws SudokuRuleVerifierException,
            SudokuFormatVerifierException{
        if (valueDoesNotExist(candidateValue)) {
            this.cells[row][column].setNumericalValue(candidateValue);
        }
    }

    private void create(){
        for (int x = 0; x < DIMENSION; x++) {
            for (int y = 0; y < DIMENSION; y++) {
                this.cells[x][y] = new Cell();
            }
        }
    }

    private boolean valueDoesNotExist(int candidateValue) throws SudokuRuleVerifierException {

        for (int x = 0; this.cells.length < DIMENSION; x++) {
            for (int y = 0; this.cells.length < DIMENSION; y++) {
                if (this.cells[x][y].getNumericalValue() == candidateValue)
                    throw new SudokuRuleVerifierException(ErrorCodes.ERROR_CODE_R2);
            }
        }
        return true;
    }
}
