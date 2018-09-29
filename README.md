# prof2018_sudoku

## Sudoku Verifier
####Subject: Profundización en Ingeniería del Software

Sudoku is a game with few simple rules, where the goal is to place nine sets
of positive digits (1…9) into the cells of a fixed grid structure (i.e. board). The
Sudoku board (or global grid) consists of a 3x3 arrangement of sub-grids, and
each sub-grid is a 3x3 arrangement of cells. This yields a 9x9 arrangement of
cells on the Sudoku board. A valid Sudoku solution should conform to the
following rules:
* R1: A cell in a Sudoku game can only store positive digits, i.e. 1…9.
* R2: All digits appear only once in a sub-grid, i.e. they cannot repeat.
* R3: A digit can appear only once in the rows of the global grid.
* R4: A digit can appear only once in the columns of the global grid.

Your task is to check the validity of a given solution for a Sudoku game:
1. You should read the candidate solution from a string variable, which
should be exactly 81 characters long, i.e. first 9 are the first row, second 9
are the second row etc.
2. You shall check whether the provided string follows the correct format
(i.e. 9 rows with 9 entries in each row).
3. You shall check the validity of the candidate solution against the rules
listed above.
4. You program shall provide the functionality to return an integer code on
the validity of the solution:
    * Return 0: means it is a valid Sudoku solution
    * Return -1: means it is violating Rule #1
    * Return -2: means it is violating Rule #2
    * Return -3: means it is violating Rule #3
    * Return -4: means it is violating Rule #4
5. You should implement the functionality with a single API method with the
following signature:
```
public int verify(String candidateSolution)
```

Educational purpose.

_By Celia Caro_
