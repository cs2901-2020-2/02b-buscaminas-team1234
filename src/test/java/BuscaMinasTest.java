import org.testng.annotations.Test;
import org.testng.Assert;

import java.io.IOException;
import java.io.InputStream;

@Test
public class BuscaMinasTest {
    public void testCase0() throws IOException {
        int ancho = 3, alto = 3;
        int [][]board = generate_test_board (ancho, alto);
        generic (board, ancho, alto, true);
    }

    public void testCase1() throws IOException {
        int ancho = 4, alto = 6;
        int [][]board = generate_test_board (ancho, alto);
        board[2][1] = -1;
        board[3][3] = -1;
        generic (board, ancho, alto, true);
    }

    public void testCase3() throws IOException {
        int ancho = 2, alto = 2;
        int [][]board = generate_test_board (ancho, alto);
        board[1][1] = -1;
        board[0][0] = 0;
        generic (board, ancho, alto, false);
    }

    private void generic (int [][]test_board, int ancho, int alto, boolean expected_result) throws IOException {
        boolean result = BuscaMinas.check_if_win (test_board, ancho, alto);
        Assert.assertEquals(expected_result, result);
    }

    private int[][] generate_test_board (int ancho, int alto) {
        int [][]board = new int[alto][ancho];
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                board[i][j] = 2;
            }
        }
        return board;
    }
}
