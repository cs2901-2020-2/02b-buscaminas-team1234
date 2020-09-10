import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.*;
public class BuscaMinas {
    public void main (String args[]) {

	final Logger logger = Logger.getLogger(BuscaMinas.class.getName());
	int n, m;
	n = m = 10;
    	int board[][] = generate_board (n, m);

	boolean over = false;
	Scanner input = new Scanner (System.in);
	int i, j;
	while (true) {
		logger.info ("Ingresa fila: ");
		i = input.nextInt();
		logger.info ("Ingresa columna: ");
		j = input.nextInt();
		if (select_space (n, m, board)) {
			logger.info ("Encontraste una mina! Perdiste :(");
			return;
		}
		if (check_if_win (board)) {
			logger.info ("Ganaste :)");
			return;
		}
	}
    }

	private boolean check_if_win(int[][] board) {
		return false;
    }

	public int[][] generate_board (int n, int m) {
	    int board[][] = new int[n][m];
	    Random rand = new Random();
	    for (int i = 0; i < n; i++) {
	    	for (int j = 0; j < m; j++) {
			if (rand.nextInt(2) == 0)
				board[i][j] = 0;
			else
				board[i][j] = -1;
		}
	    }
	    return board;
    }

    public boolean select_space (int n, int m, int board[][]) {
    	if (board[n][m] == 0) {
		board[n][m] = 2;
		return false;
	}
	else
		return true;
    }

    public boolean check_if_win (int board[][], int n, int m) {
    	boolean win = true;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (board[i][j] == 0)
				win = false;
		}
	}
	return win;
    }
}
