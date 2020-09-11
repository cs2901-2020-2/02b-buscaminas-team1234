import java.util.Random;
import java.util.Scanner;
import java.util.logging.*;


public class BuscaMinas {
	private static final int MINA = -1;
	private static final int CASILLA = 0;
	private static final int CASILLA_ABIERTA = 2;

	static final Logger logger = Logger.getLogger(BuscaMinas.class.getName());

	private static boolean check_if_win(int[][] board) {
		return false;
    }

	public static int[][] generate_board(int ancho, int alto) {
	    int [][]board = new int[ancho][alto];
	    Random rand = new Random();

	    for (int iterador_ancho = 0; iterador_ancho < ancho; iterador_ancho++) {
	    	for (int iterador_alto = 0; iterador_alto < alto; iterador_alto++) {
				if (rand.nextInt(2) == 0)
					board[iterador_ancho][iterador_alto] = CASILLA;
				else
					board[iterador_ancho][iterador_alto] = MINA;
			}
	    }
	    return board;
    }

    public static boolean select_space(int ancho, int alto, int [][] board) {
    	if (board[ancho][alto] == CASILLA) {
			board[ancho][alto] = CASILLA_ABIERTA;
			return false;
		}
		else
			return true;
    }

    public boolean check_if_win (int [][]board, int ancho, int alto) {
    	boolean win = true;
		for (int iterador_ancho = 0; iterador_ancho < ancho; iterador_ancho++) {
			for (int iterador_alto = 0; iterador_alto < alto; iterador_alto++) {
				if (board[iterador_ancho][iterador_alto] == CASILLA)
					win = false;
			}
		}
		return win;
    }

	public static void main (String [] args) {
		int ancho, alto;
		ancho = alto = 10;
		int [][]board = generate_board (ancho, alto);

		boolean over = false;
		Scanner input = new Scanner (System.in);
		int input_ancho, input_alto;
		while (true) {
			logger.info ("Ingresa fila: ");
			input_ancho = input.nextInt();
			logger.info ("Ingresa columna: ");
			input_alto = input.nextInt();
			if (select_space (ancho, alto, board)) {
				logger.info ("Encontraste una mina! Perdiste :(");
				return;
			}
			if (check_if_win (board)) {
				logger.info ("Ganaste :)");
				return;
			}
		}
	}
}
