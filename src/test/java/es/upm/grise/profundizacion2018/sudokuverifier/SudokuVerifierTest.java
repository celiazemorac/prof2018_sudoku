package es.upm.grise.profundizacion2018.sudokuverifier;

import static org.junit.Assert.fail;

import es.upm.grise.profundizacion2018.sudokuverifier.Board.Board;
import es.upm.grise.profundizacion2018.sudokuverifier.Board.Cell;
import es.upm.grise.profundizacion2018.sudokuverifier.Board.SubBoard;
import es.upm.grise.profundizacion2018.sudokuverifier.Exceptions.SudokuRuleVerifierException;
import org.junit.Test;

public class SudokuVerifierTest {
    
	@Test
	public void r1Test() {
	    Cell cell = new Cell();
        try {
            cell.setNumericalValue(-1);
        } catch (SudokuRuleVerifierException error) {
            System.err.println(error.getMessage());
        }
    }

	@Test
	public void r2Test() {

        SubBoard subBoard = new SubBoard();
        // Filling the sub-board
        subBoard.assignValueToForceToCell(5,0,0);
        subBoard.assignValueToForceToCell(4,0,1);
        subBoard.assignValueToForceToCell(3,0,2);

        subBoard.assignValueToForceToCell(2,1,0);
        subBoard.assignValueToForceToCell(0,1,1);
        subBoard.assignValueToForceToCell(9,1,2);

        subBoard.assignValueToForceToCell(8,2,0);
        subBoard.assignValueToForceToCell(7,2,1);
        subBoard.assignValueToForceToCell(6,2,2);

        subBoard.assignValueToCell(5,1,1);
	}

	@Test
	public void r3Test() {
        Board sudokuBoard = new Board();
        sudokuBoard.assignValueToForceToCell(0,0,5);
        sudokuBoard.assignValueToForceToCell(0,1,4);
        sudokuBoard.assignValueToForceToCell(0,2,0);
        sudokuBoard.assignValueToForceToCell(0,3,9);
        sudokuBoard.assignValueToForceToCell(0,4,2);
        sudokuBoard.assignValueToForceToCell(0,5,1);
        sudokuBoard.assignValueToForceToCell(0,6,8);
        sudokuBoard.assignValueToForceToCell(0,7,7);
        sudokuBoard.assignValueToForceToCell(0,8,6);

        sudokuBoard.assignValueToCell(0, 2 , 6);

	}

	@Test
	public void r4Test() {
        Board sudokuBoard = new Board();
        sudokuBoard.assignValueToForceToCell(0,0,5);
        sudokuBoard.assignValueToForceToCell(1,0,2);
        sudokuBoard.assignValueToForceToCell(2,0,8);
        sudokuBoard.assignValueToForceToCell(3,0,9);
        sudokuBoard.assignValueToForceToCell(4,0,3);
        sudokuBoard.assignValueToForceToCell(5,0,6);
        sudokuBoard.assignValueToForceToCell(6,0,7);
        sudokuBoard.assignValueToForceToCell(7,0,4);
        sudokuBoard.assignValueToForceToCell(8,0,0);

        sudokuBoard.assignValueToCell(8, 0 , 3);
	}
}
