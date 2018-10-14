package es.upm.grise.profundizacion2018.sudokuverifier;
import java.util.Arrays;

public class SudokuVerifier {

    public int verify (String candidateSolution) {
        String[] characters = candidateSolution.split("");
        int[] sudoku_numbers = new int[characters.length];
        int[][] board = new int[9][9];

        // Checking length
        if(characters.length != 81) {
            return -1;
        }

        // Checking R1
        for(int i = 0; i < characters.length; i++) {
            if(Integer.parseInt(characters[i]) == 0) {
                return -1;
            }
            try {
                sudoku_numbers[i] = Integer.parseInt(characters[i]);
            }
            catch (NumberFormatException nfe){
                System.exit(-1);
            }
        }

        // Filling the board
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board.length; y++) {
                board[x][y] = sudoku_numbers[(board.length*x)+y];
            }
        }

        // Checking errors in subboard, row and column
        for (int i = 0; i < board.length; i++) {
            int[] column = new int[board.length];
            int[] subboard = new int[board.length];
            int[] row = board[i].clone();
            int count = 0;
            for (int j = 0; j < board.length; j++) {
                // Extracting the column.
                column[j] = board[j][i];
                // Extracting the subboard.
                int row_subboard = (i / 3) * 3 + j / 3;
                int column_subboard = i * 3 % board.length + j % 3;
                subboard[j] = board[row_subboard][column_subboard];
            }
            // Checking R2
            Arrays.sort(subboard);
            for (int number : subboard) {
                if (number != ++count) return -2;
            }
            // Checking R3
            count = 0;
            Arrays.sort(row);
            for (int number : row) {
                if (number != ++count) return -3;
            }
            // Checking R4
            count = 0;
            Arrays.sort(column);
            for (int number : column) {
                if (number != ++count) return -4;
            }

        }
        return 0;
    }
}