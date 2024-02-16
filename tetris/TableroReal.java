package tetris;

import java.util.Arrays;

public class TableroReal {

	// Attributes

	private int filas = 16;
	private int columnas = 12;
	private String blancoString = "\uD83D\uDD32";
	private String azulString = "\uD83D\uDD3C";
	private String[][] tablero = new String[this.filas][this.columnas];
	private boolean filasCompletas[] = new boolean[16];

	// Constructors

	public TableroReal() {

		for (int i = 0; i < this.filas; i++) {

			filasCompletas[i] = false;

			for (int j = 0; j < this.columnas; j++) {

				if (i == 15 && j == 0) {
					tablero[i][j] = " --";
				} else if (i == 15) {
					tablero[i][j] = "--";
				} else if (j == 0) {
					tablero[i][j] = "| ";
				} else if (j == 11) {
					tablero[i][j] = " |";
				} else {
					tablero[i][j] = blancoString;
				}

			}
		}
	}

	// Others Methods

	public void mostrar() {

		for (int i = 0; i < this.filas; i++) {

			for (int j = 0; j < this.columnas; j++) {

				if (j < 11) {
					System.out.print(tablero[i][j]);
				} else {
					System.out.println(tablero[i][j]);
				}

			}
		}

	}

	public int checkColumn(int pos) {
		int firstPos = 15;

		for (int i = 0; i < this.filas; i++) {
			if (!tablero[i][pos].equals(blancoString)) { // necesito la primera posicion de esa columna que sea distinta
															// de blanco
				if (!tablero[i][pos].equals("--")) {
					if (!tablero[i][pos].equals(" --")) {
						firstPos = i;
						i = 100;
					}
				}
			}
		}

		return firstPos;
	}

	public void setAzulVertical1(int pos) {

		int lastPos = checkColumn(pos);

		for (int i = 0; i < this.filas; i++) {

			for (int j = 0; j < this.columnas; j++) {
				if (j == pos) {

					if (i < lastPos && i >= (lastPos - 4)) {
						tablero[i][j] = azulString;
					}

				}
			}
		}
	}

	public void setAzulVertical2(int pos) {

		int positions[] = new int[4];

		for (int i = 0; i < positions.length; i++) { // partiendo de derecha a izquierda guardo en un array la ultima
														// posicion ocupada de la columna de cada fragmento de la figura
			positions[i] = checkColumn(pos - i);

		}

		Arrays.sort(positions); // los ordeno de mayor a menor pues el numero mas bajo será el más alto
								// gráficamente

		int lastPos = positions[0]; // establezco que al bajar la figura la altura sea la más baja (alta) de las 4

		for (int j = 0; j < this.columnas; j++) {

			if (j >= (pos - 3) && j <= pos) {
				tablero[lastPos - 1][j] = azulString;
			}

		}

	}

	public void check() { // metodo para eliminar las filas completas

		int suma = 0;

		for (int i = 0; i < this.filas; i++) {

			for (int j = 0; j < this.columnas; j++) {

				if (tablero[i][j].equals(azulString)) {
					suma++;
				}

				if (suma == 10) {
					for (int k = 1; k < 11; k++) {
						tablero[i][k] = blancoString;
					}

				}
			}
			suma = 0;
		}
	}

	public boolean lose() {
		boolean lose = false;

		for (int i = 0; i < this.columnas; i++) {
			if (!tablero[0][i].equals(blancoString)) {
				if (!tablero[0][i].equals("| ")) {
					if (!tablero[0][i].equals(" |")) {
						lose = true;
					}
				}
			}
		}

		return lose;
	}

}
