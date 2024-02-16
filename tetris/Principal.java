package tetris;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		TableroReal tablero = new TableroReal();

		Scanner scanner = new Scanner(System.in);

		char action = 'q';

		TableroDinamic arrayTablerosDinamics[] = new TableroDinamic[100];
		int cont = 0;

		do {

			if (action == 'q') {
				arrayTablerosDinamics[cont] = new TableroDinamic(0);
			}

			arrayTablerosDinamics[cont].mostrar();
			tablero.mostrar();
			
			if(tablero.lose()==true) {
				System.out.println("Has perdido");
				action = 'e';
			}

			action = scanner.next().charAt(0);

			if (action == 'a') {
				arrayTablerosDinamics[cont].moverIzquierdaAzul();
			} else if (action == 'd') {
				arrayTablerosDinamics[cont].moverDerechaAzul();
			} else if (action == 'q') {
				if(arrayTablerosDinamics[cont].getPosAzul()== 1) {
					tablero.setAzulVertical1(arrayTablerosDinamics[cont].darPosAzul());
				}else {
					tablero.setAzulVertical2(arrayTablerosDinamics[cont].darPosAzul());
				}
				
				cont++;
			} else if (action == 'w' || action == 's') {
				arrayTablerosDinamics[cont].cambiarPosicionAzul();

			}

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tablero.check();

		} while (action != 'e');

	}

}
