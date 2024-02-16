package tetris;

public class TableroDinamic {
	// Attributes

	private int filas = 4;
	private int columnas = 12;
	private String blancoString = "\uD83D\uDD32";
	private String azulString = "\uD83D\uDD3C";
	private String[][] tablero = new String[this.filas][this.columnas];
	private int posAzul = 1;

	// Constructors

	// Aqui poner que se pase un parametro int, ese int sera un num aleat y
	// determinará la figura que crea

	public TableroDinamic(int num) {
		if (num == 0) { // inicializamos la ficha azul en pos 1
			for (int i = 0; i < this.filas; i++) {

				for (int j = 0; j < this.columnas; j++) {
					if (j == 0) {
						tablero[i][j] = "| ";
					} else if (j == 11) {
						tablero[i][j] = " |";
					} else if (j == 5) {
						tablero[i][j] = azulString;
					} else {
						tablero[i][j] = blancoString;
					}
				}
			}
		}
	}

	// Getter setters

	public void setTableroAZUL1(int fila, int columna) { // para la pos 1
		this.tablero[fila][columna] = azulString;
	}

	public void setTableroBLANCO1(int fila, int columna) { // para la pos 1
		this.tablero[fila][columna] = blancoString;
	}

	public int getPosAzul() {
		int pos = this.posAzul;
		return pos;
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

	public void moverIzquierdaAzul() { 

		// vemos en que columna está

		int posFigura = 0;

		for (int j = 0; j < this.columnas; j++) {

			if (tablero[3][j].equals(azulString)) {
				posFigura = j;
				j=20;
			}
		}

		// ahora cambiamos las fichas de color de cada fila, usando la columna posFigura

		
		if(getPosAzul()==1) {
			if (posFigura > 1) {
				for (int i = 0; i < this.filas; i++) {
					setTableroAZUL1(i, posFigura - 1);
					setTableroBLANCO1(i, posFigura);
				}
			}
		} else {
			if(posFigura>1) {
				tablero[3][posFigura+3] = blancoString;
				tablero[3][posFigura-1] = azulString;
			}
		}
	}

	public void moverDerechaAzul() { // pos 1

		// adivinamos en que columna está

		// al ser la azul y estar en vertical con comprobar solo una fila nos basta

		int posFigura = 0;

		for (int j = 0; j < this.columnas; j++) {

			if (tablero[3][j].equals(azulString)) {
				posFigura = j;
				j = 20;
			}
		}

		// ahora cambiamos las fichas de color de cada fila, usando la columna posFigura
		if(getPosAzul() == 1) {
			if (posFigura < 10) {
				for (int i = 0; i < this.filas; i++) {
					setTableroAZUL1(i, posFigura + 1);
					setTableroBLANCO1(i, posFigura);
				}
			}
		} else {
			if(posFigura<7) {
				tablero[3][posFigura] = blancoString;
				tablero[3][posFigura+4] = azulString;
			}
		}
	}

	public int darPosAzul() { // pos devuelva la pos de la columna en la pos 1 y la poscicion de la ultima
								// cuando está en pos 2
		int posFigura = 0;

		for (int j = 0; j < this.columnas; j++) {

			if (tablero[3][j].equals(azulString)) {
				posFigura = j;
			}
		}
		return posFigura;
	}

	private void cambiarValorPos() {
		if (this.posAzul == 1) {
			this.posAzul = 2;
		} else if(this.posAzul == 2) {
			this.posAzul = 1;
		}
	}

	
	public void cambiarPosicionAzul() {
		int posFigura = 0;

		for (int j = 0; j < this.columnas; j++) {

			if (tablero[3][j].equals(azulString)) {
				posFigura = j;
				j = 20;
			}
		}

		if (getPosAzul() == 1) {
			if (posFigura < 8) {
				for (int i = 0; i < this.filas; i++) { //borramos los azules de arriba
					tablero[i][posFigura] = blancoString;
				}
				for (int i = 0; i < 4; i++) { //escribimos los nuevos azules
					tablero[3][posFigura + i] = azulString;
				}
			} else {
				for (int i = 0; i < this.filas; i++) {
					tablero[i][posFigura] = blancoString;
				}
				
				if(posFigura == 8) {
					for(int i = -1; i < 3;i++) {
						tablero[3][posFigura +i]= azulString;
					}
				} else if(posFigura == 9) {
					for(int i = -2; i < 2;i++) {
						tablero[3][posFigura +i]= azulString;
					}
				} else if(posFigura == 10) {
					for(int i = -3; i < 1;i++) {
						tablero[3][posFigura +i]= azulString;
					}
				}
			}
			
			cambiarValorPos();
		
		} else if(getPosAzul() == 2){
			for (int i = 0; i < 4; i++) {
				tablero[3][posFigura+i] = blancoString;
			}
			
			for(int i = 0;i < this.filas;i++) {
				tablero[i][posFigura] = azulString;
			}
			
			cambiarValorPos();
		}

	}

}
