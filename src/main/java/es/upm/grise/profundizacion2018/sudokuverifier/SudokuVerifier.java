package es.upm.grise.profundizacion2018.sudokuverifier;


import es.upm.grise.profundizacion2018.sudokuverifier.Board.Board;
import es.upm.grise.profundizacion2018.sudokuverifier.Exceptions.ErrorCodes;
import es.upm.grise.profundizacion2018.sudokuverifier.Exceptions.SudokuFormatVerifierException;

public class SudokuVerifier {

    public static final int MIN_VALUE_OF_NUMERICAL_RANGE = 1;
    public static final int MAX_VALUE_OF_NUMERICAL_RANGE = 9;
    private static final int NUMBER_OF_CHARACTERS_OF_SOLUTION = 81;
    private static final int DIMENSION = 3; // 3x3
    private Board sudokuBoard;

	public int verify (String candidateSolution) {

        try {
            if (canWeFormABoard(candidateSolution)) {

            }
        } catch (SudokuFormatVerifierException error) {
            System.err.println(error);
            System.exit(-1);
        }
        return 0;
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
