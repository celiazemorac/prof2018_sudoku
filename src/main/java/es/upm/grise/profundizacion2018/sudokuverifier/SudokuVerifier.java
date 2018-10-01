package es.upm.grise.profundizacion2018.sudokuverifier;


import es.upm.grise.profundizacion2018.sudokuverifier.Board.Board;
import es.upm.grise.profundizacion2018.sudokuverifier.Exceptions.ErrorCodes;
import es.upm.grise.profundizacion2018.sudokuverifier.Exceptions.SudokuFormatVerifierException;
import es.upm.grise.profundizacion2018.sudokuverifier.Exceptions.Untouchable;

public class SudokuVerifier {

    public static final int MIN_VALUE_OF_NUMERICAL_RANGE = 1;
    public static final int MAX_VALUE_OF_NUMERICAL_RANGE = 9;
    private static final int NUMBER_OF_CHARACTERS_OF_SOLUTION = 81;
    private static final Untouchable[] SUDOKU_SCHEME = {
            new Untouchable(0, 0, 5),
            new Untouchable(0, 1, 4),
            new Untouchable(0, 4, 2),
            new Untouchable(0, 6, 8),
            new Untouchable(0, 8, 6),
            new Untouchable(1, 1, 1),
            new Untouchable(1, 2, 9),
            new Untouchable(1, 5, 7),
            new Untouchable(1, 8, 3),
            new Untouchable(2, 3, 3),
            new Untouchable(2, 6, 2),
            new Untouchable(2, 7, 1),
            new Untouchable(3, 0, 9),
            new Untouchable(3, 3, 4),
            new Untouchable(3, 5, 5),
            new Untouchable(3, 7, 2),
            new Untouchable(4, 2, 1),
            new Untouchable(4, 6, 6),
            new Untouchable(4, 8, 4),
            new Untouchable(5, 0, 6),
            new Untouchable(5, 2, 4),
            new Untouchable(5, 4, 3),
            new Untouchable(5, 5, 2),
            new Untouchable(5, 7, 8),
            new Untouchable(6, 1, 6),
            new Untouchable(6, 6, 1),
            new Untouchable(6, 7, 9),
            new Untouchable(7, 0, 4),
            new Untouchable(7, 2, 2),
            new Untouchable(7, 5, 9),
            new Untouchable(7, 8, 5),
            new Untouchable(8, 1, 9),
            new Untouchable(8, 4, 7),
            new Untouchable(8, 6, 4),
            new Untouchable(8, 8, 2)
    };
    private Board sudokuBoard;

    public SudokuVerifier(){
        this.sudokuBoard = new Board();
    }

	public int verify (String candidateSolution) {
        try {
            if (canWeFormABoard(candidateSolution)) {
                char[] candidateValues = candidateSolution.toCharArray();
                for (int x = 0; x < MAX_VALUE_OF_NUMERICAL_RANGE; x++) {
                    for (int y = 0; y < MAX_VALUE_OF_NUMERICAL_RANGE; y++) {
                        int candidateValue = Character.getNumericValue(
                                candidateValues[(MAX_VALUE_OF_NUMERICAL_RANGE*x)+y]);
                        this.sudokuBoard.assignValueToCell(x, y , candidateValue);
                    }
                }
            }
        } catch (SudokuFormatVerifierException error) {
            System.err.println(error.getMessage());
        }
        return 0;
    }

    public void prepareSudokuBoard() {
        for (int i = 0; i < SUDOKU_SCHEME.length; i++) {
            int row = SUDOKU_SCHEME[i].getRow();
            int column = SUDOKU_SCHEME[i].getColumn();
            int value = SUDOKU_SCHEME[i].getValue();
            this.sudokuBoard.assignValueToForceToCell(row,column,value);
            this.sudokuBoard.getCell(row,column).doUntouchable();
        }
        Printer.sudokuScheme = this.sudokuBoard;

    }

    private boolean checkLength (String candidateSolution) {

	    return candidateSolution.length() == NUMBER_OF_CHARACTERS_OF_SOLUTION;
    }

    private boolean allCharactersAreNumbers(String candidateSolution) {
        boolean valid = true;
        char[] characters = candidateSolution.toCharArray();
        for (int i = 0; i < characters.length && valid; i++) {

            if (!Character.isDigit(characters[i])){
                valid = false;
            }
        }
        return valid;
    }

    private boolean canWeFormABoard(String candidateSolution) throws SudokuFormatVerifierException {

	    if (!checkLength(candidateSolution))
	        throw new SudokuFormatVerifierException(ErrorCodes.ERROR_CODE_NUMBER_OF_CHARACTERS,
                    "your number of character not is " + NUMBER_OF_CHARACTERS_OF_SOLUTION + ".");
        if (!allCharactersAreNumbers(candidateSolution))
            throw new SudokuFormatVerifierException(ErrorCodes.ERROR_CODE_NOT_NUMBERS,
                    "your candidate solution includes non numerical characters.");

        return true;
    }

}
