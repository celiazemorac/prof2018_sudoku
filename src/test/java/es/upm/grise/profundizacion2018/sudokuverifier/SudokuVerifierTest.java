package es.upm.grise.profundizacion2018.sudokuverifier;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
public class SudokuVerifierTest {

    public void testSudoku() {
        SudokuVerifier valid = new SudokuVerifier();
        assertEquals(0, valid.verify("543921876219687543876354219987465321321798654654132987765243198432819765198576432"));
    }

    @ Test
    public void testSudokuLength() {
        SudokuVerifier error = new SudokuVerifier();
        assertEquals(-1, error.verify("543921876219687-543876354219987465321321798654654132987765243198432819765198576432"));
    }

    @ Test
    public void testSudokuContainsZero() {
        SudokuVerifier error = new SudokuVerifier();
        assertEquals(-1, error.verify("5439218762196875438763542199874065321321798654654132987765243198432819765198576432"));
    }

    @ Test (expected = NumberFormatException.class)
    public void testRangeOfNumbers() { // [1-9]
        SudokuVerifier error = new SudokuVerifier();
        assertEquals(-1, error.verify("543921876219687a43876354219987465321321798654654132987765243198432819765198576432"));
    }

    @Test
    public void testCheckSubboard() {
        SudokuVerifier error = new SudokuVerifier();
        assertEquals(-2, error.verify("543921876259687543876354219987465321321798654654132987765243198432819765198576432"));
    }

    @Test
    public void testSudokuGlobalRow() {
        SudokuVerifier error = new SudokuVerifier();
        assertEquals(-3, error.verify("532678912674195348198342567859761423426853791713924856961537284287419635345286179"));
    }

    @Test
    public void testSudokuGlobalColumn() {
        SudokuVerifier error = new SudokuVerifier();
        assertEquals(-4, error.verify("543921876219687543876354219987465321321798654654132987765243198432819765398576432"));
    }
}