package es.upm.grise.profundizacion2018.sudokuverifier;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String candidateSolution = "";
        Scanner sc = new Scanner(System.in);
        SudokuVerifier sudoku_verifier = new SudokuVerifier();
        Printer printer = new Printer();
        int validity = 0;

        sudoku_verifier.prepareSudokuBoard();
        printer.printSudokuScheme();

        System.out.println("Please, enter your sudoku solution (81 characters) for above sudoku.");
        candidateSolution = sc.nextLine();
        System.out.println("Executing verifier...\n");

        validity = sudoku_verifier.verify(candidateSolution);

        if (validity == 0) {
            System.out.println("Congratulations, valid Sudoku solution\n");
            Printer.solution = candidateSolution.toCharArray();
            printer.printSolution();
        }
    }
}
