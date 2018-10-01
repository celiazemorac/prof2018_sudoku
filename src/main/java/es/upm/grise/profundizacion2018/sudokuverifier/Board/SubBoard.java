package es.upm.grise.profundizacion2018.sudokuverifier.Board;

import es.upm.grise.profundizacion2018.sudokuverifier.Exceptions.ErrorCodes;
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

    public boolean isTheCellUntouchable(int row, int column) {
        return this.cells[row][column].isUntouchable();
    }

    public Cell getCell(int row, int column) {
        return this.cells[row][column];
    }

    public void assignValueToCell(int candidateValue, int row, int column)
            throws SudokuRuleVerifierException {

        if (valueDoesNotExist(candidateValue, row, column)) {
            Cell cell = this.cells[row][column];
            cell.setNumericalValue(candidateValue);
        }
    }

    public void assignValueToForceToCell(int candidateValue, int row, int column) {
        this.cells[row][column].assignValueToForce(candidateValue);
    }

    private void create(){
        for (int x = 0; x < DIMENSION; x++) {
            for (int y = 0; y < DIMENSION; y++) {
                this.cells[x][y] = new Cell();
            }
        }
    }

    private boolean valueDoesNotExist(int candidateValue, int candidateRow, int candidateColumn)
            throws SudokuRuleVerifierException{
        int count = 0;
        for (int x = 0; x < DIMENSION; x++) {
            for (int y = 0; y < DIMENSION; y++) {
                Cell cell = this.cells[x][y];
                int cellValue = cell.getNumericalValue();
                if (cellValue == candidateValue) {
                    count++;
                    if (candidateRow == x && candidateColumn == y) count--;
                }
            }
        }
        if ((count + 1) > 1)
            throw new SudokuRuleVerifierException(ErrorCodes.ERROR_CODE_R2);
        return true;
    }
}
