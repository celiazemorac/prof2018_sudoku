package es.upm.grise.profundizacion2018.sudokuverifier;

import es.upm.grise.profundizacion2018.sudokuverifier.Board.Board;

public class Printer {

    public static char[] solution;
    public static Board sudokuScheme;

    public void printSudokuScheme(){
        System.out.println();
        System.out.println("Hi player, the sudoku scheme is:");
        for (int x = 0; x < SudokuVerifier.MAX_VALUE_OF_NUMERICAL_RANGE; x++) {
            for (int y = 0; y < SudokuVerifier.MAX_VALUE_OF_NUMERICAL_RANGE; y++) {
                int value = sudokuScheme.getCell(x, y).getNumericalValue();
                if (y % SudokuVerifier.MAX_VALUE_OF_NUMERICAL_RANGE  == 0) System.out.println();
                System.out.print(value + " ");
            }
        }
        System.out.println();
        System.out.println();
    }

    public void printSolution(){
        System.out.println("Complete sudoku is: ");
        for (int i = 0; i < this.solution.length; i++) {
            if (i % SudokuVerifier.MAX_VALUE_OF_NUMERICAL_RANGE  == 0) System.out.println();
            System.out.print(Character.getNumericValue(this.solution[i]) + " ");
        }
        System.out.println();
        System.out.println();
    }
}
