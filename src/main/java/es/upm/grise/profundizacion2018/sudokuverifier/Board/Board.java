package es.upm.grise.profundizacion2018.sudokuverifier.Board;

import es.upm.grise.profundizacion2018.sudokuverifier.Exceptions.ErrorCodes;
import es.upm.grise.profundizacion2018.sudokuverifier.Exceptions.SudokuRuleVerifierException;

public class Board {

    public static final int DIMENSION = 3; // 3x3
    private SubBoard[][] board;

    public Board(){
        this.board = new SubBoard[DIMENSION][DIMENSION];
        create();
    }

    public void assignValueToCell(int rowOfTheCell, int columnOfTheCell, int candidateValue)
            throws SudokuRuleVerifierException {

        if (notExistCandidateValueInGlobalRow(rowOfTheCell, candidateValue) &&
                notExistCandidateValueInGlobalColumn(columnOfTheCell, candidateValue)) {
            int subBoardRow = calculateSubBoardCoordenate(rowOfTheCell);
            int subBoardColumn = calculateSubBoardCoordenate(columnOfTheCell);
            int boardRow = getBoardRow(rowOfTheCell);
            int boardColumn = getBoardRow(columnOfTheCell);
            this.board[boardRow][boardColumn].assignValueToCell(candidateValue, subBoardRow, subBoardColumn);
        }
    }

    public void assignValueToForceToCell(int rowOfTheCell, int columnOfTheCell, int candidateValue){

        int subBoardRow = calculateSubBoardCoordenate(rowOfTheCell);
        int subBoardColumn = calculateSubBoardCoordenate(columnOfTheCell);
        int boardRow = getBoardRow(rowOfTheCell);
        int boardColumn = getBoardRow(columnOfTheCell);
        this.board[boardRow][boardColumn].assignValueToForceToCell(candidateValue, subBoardRow, subBoardColumn);
    }

    public Cell getCell(int rowOfTheCell, int columnOfTheCell){
        int subBoardRow = calculateSubBoardCoordenate(rowOfTheCell);
        int subBoardColumn = calculateSubBoardCoordenate(columnOfTheCell);
        int boardRow = getBoardRow(rowOfTheCell);
        int boardColumn = getBoardRow(columnOfTheCell);

        return this.board[boardRow][boardColumn].getCell(subBoardRow, subBoardColumn);
    }

    private int calculateSubBoardCoordenate(int columnOrRow) {
        return columnOrRow % DIMENSION;
    }

    private void create(){
        for (int x = 0; x < this.board.length; x++) {
            for (int y = 0; y < this.board.length; y++) {
                this.board[x][y] = new SubBoard();
            }
        }
    }

    public boolean notExistCandidateValueInGlobalRow(int rowOfTheCell, int candidateValue)
            throws SudokuRuleVerifierException {

        int subBoardRow = rowOfTheCell % DIMENSION;
        int boardRow = getBoardRow(rowOfTheCell);
        for (int y = 0; y < DIMENSION; y++) {
            for (int subBoardColumn = 0; subBoardColumn < SubBoard.DIMENSION; subBoardColumn++) {
                int cellValue = this.board[boardRow][y].getCellValue(subBoardRow, subBoardColumn);
                boolean untouchable = this.board[boardRow][y].isTheCellUntouchable(subBoardRow, subBoardColumn);
                if (candidateValue == cellValue && !untouchable)
                    throw new SudokuRuleVerifierException(ErrorCodes.ERROR_CODE_R3);
            }
        }
        return true;
    }

    private boolean notExistCandidateValueInGlobalColumn(int columnOfTheCell, int candidateValue)
            throws SudokuRuleVerifierException {

        int subBoardColumn = columnOfTheCell % DIMENSION;
        int boardColumn = getBoardRow(columnOfTheCell);

        for (int x = 0; x < DIMENSION; x++) {
            for (int subBoardRow = 0; subBoardRow < SubBoard.DIMENSION; subBoardRow++) {
                int cellValue = this.board[x][boardColumn].getCellValue(subBoardRow, subBoardColumn);
                boolean untouchable = this.board[x][boardColumn].isTheCellUntouchable(subBoardRow, subBoardColumn);
                if (candidateValue == cellValue && !untouchable)
                    throw new SudokuRuleVerifierException(ErrorCodes.ERROR_CODE_R4);
            }
        }

        return true;
    }

    private int getBoardRow (int rowOfTheCell) {
        double posibleDecimalValue = (double)rowOfTheCell / DIMENSION;

        if (posibleDecimalValue < 1 ) {
            return 0;
        } else if (posibleDecimalValue < 2) {
            return 1;
        } else {
            return 2;
        }
    }

}
