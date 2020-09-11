import java.util.*;
import java.util.logging.*;

public class BuscaMinas{

    private static final char Mina = '*';
    private static final char Casilla = '-';    
	private static  int Bufferx = 5;
    private static  int Buffery = 5;
    


    static final Logger logger = Logger.getLogger(BuscaMinas.class.getName());

    public static boolean check_if_win (char [][] board) {
    	boolean win = true;
		for (int iterador_ancho = 0; iterador_ancho < Bufferx; iterador_ancho++) {
			for (int iterador_alto = 0; iterador_alto < Buffery; iterador_alto++) {
				if (board[iterador_ancho][iterador_alto] == Casilla)
					win = false;
			}
		}
		return win;
    }

    public static char[][] generate_board(int ancho, int largo){

		Random rand = new Random();
		
		char [][]board = new char[ancho][largo];

        Bufferx = ancho-1;
        Buffery = largo-1;

        for(int i = 0 ; i < ancho ; i++){
            for (int j = 0 ; j < largo ; j++){
                
                int randint = rand.nextInt(2);

                if(randint == 0) board[i][j] = Casilla;

                else board[i][j] = Mina;                

            }
		}
		
		return board;
    }

    public static int entorno(int posx, int posy,char[][] board){

        int contador = 0;

        for(int i = 0 ; i <= Bufferx ; i++){
            for(int j = 0 ; j <= Buffery ; j++){
                if(i - 1 == posx || i +1 == posx || i == posx){
                    if(j-1 == posy || j+1 == posy || j == posy){
                        if(board[i][j] == Mina) contador++;
                        continue;

                    }
                }
            }
        }
        return contador;

    }

    public static boolean select_space(int posx, int posy,char[][] board){

        if(board[posx][posy] == Casilla){
            board[posx][posy] = (char)entorno(posx, posy,board);
            return false;          

        }
        else if(board[posx][posy] != Mina || board[posx][posy] != Casilla){
            logger.info("Esta casilla ya la tomaste!");
            return false;
        }
        else return true;

    }

    public static void main(String args[]){

        Scanner input = new Scanner (System.in);
		int ancho, alto;

		while(true){
			logger.info ("Ingresa alto: ");
			alto = input.nextInt();
			if (alto!=0){
				break;
			}
			else {
				logger.warning ("¡El alto no puede ser 0!");
			}
		}

		while(true){
			logger.info ("Ingresa ancho: ");
			ancho = input.nextInt();
			if (ancho!=0){
				break;
			}
			else {
				logger.warning ("¡El ancho no puede ser 0!");
			}
		}

		char[][] board = generate_board (ancho, alto);

		boolean over = false;

		int input_ancho, input_alto;
		
		while (true) {
			logger.info ("Ingresa fila: ");
			input_ancho = input.nextInt();
			if(input_ancho>=ancho){
				logger.warning ("¡Ancho fuera de rango! Maximo ancho de: "+(ancho-1));
				continue;
			}
			logger.info ("Ingresa columna: ");
			input_alto = input.nextInt();
			if(input_alto>=alto){
				logger.warning ("¡Ancho fuera de rango! Maximo alto de: "+(alto-1));
				continue;
			}
			if (select_space (input_ancho, input_alto,board)) {
				logger.info ("Encontraste una mina! Perdiste :(");
				return;
			}
			if (check_if_win(board)) {
				logger.info ("Ganaste :)");
				return;
			}
		}

    }   
}