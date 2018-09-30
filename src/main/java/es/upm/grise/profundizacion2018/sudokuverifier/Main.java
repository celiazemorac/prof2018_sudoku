package es.upm.grise.profundizacion2018.sudokuverifier;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String candidateSolution = "";
        Scanner sc = new Scanner(System.in);
        SudokuVerifier sudoku_verifier = new SudokuVerifier();
        int validity = 0;
        // TODO: PRINT SUDOKU'S SCHEME

        System.out.println("Hi player! Please enter your solution (81 characters) for above sudoku.");
        candidateSolution = sc.nextLine();
        System.out.println("Executing verifier...");

        validity = sudoku_verifier.verify(candidateSolution);

        if (validity == 0) System.out.println("Congratulations, valid Sudoku solution");
    }
}
