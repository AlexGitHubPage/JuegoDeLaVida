import java.util.Arrays;
import java.util.Scanner;
public class codeprim {
	static Scanner e = new Scanner(System.in);
	
	public char [][] creatablero(){
		char [][] t = new char [10][10];
		
			for( int i = 0; i < t.length; i++) {
				for( int j = 0; j < t[0].length; j++) {
					t[i][j] = '-';
					
				}
			}
			
		return t;
	}
	public void vertablero( char[][] t){
		for( int a = 0; a < t.length; a++) {
			System.out.println(" ");
			for( int h = 0; h < t[0].length; h++) {
			 System.out.print(t[a][h]);	
			 System.out.print(" ");
			}
		}
	}
	
	public char[][]  CelManual(char [][] t) {
		System.out.println("En que fila vas a introducir esa celula? ");
		int fil = e.nextInt();
		System.out.println("En que columna vas a introducir la celula?");
		int col = e.nextInt();
		
		t[fil][col] = 'X';
		
		return t;
	}
	public int[][]vecinas(int colu, int fila, char[][]t){ //1, 1
		
		int[][] crdVecinas = new int[8][2];

		int x = fila-1; //0
		int y = colu; //1
	
		crdVecinas[0][0] = x; //0
		crdVecinas[0][1] = y; //1
		
		y++;
		
		crdVecinas[1][0] = x; //0
		crdVecinas[1][1] = y; //2
		
		y--;
		y--;
		
		crdVecinas[2][0] = x; //0
		crdVecinas[2][1] = y; //0
		
		x = fila+1; //2
		y = colu; //1
		
		crdVecinas[3][0] = x; //2
		crdVecinas[3][1] = y; //1
		
		y++;
		
		
		crdVecinas[4][0] = x; //2
		crdVecinas[4][1] = y; //2
		
		y--;
		y--;
		
		crdVecinas[5][0] = x; //2
		crdVecinas[5][1] = y; //0
		
		x--;
		
		
		crdVecinas[6][0] = x; //1
		crdVecinas[6][1] = y; //0
		
		y++;
		y++;
		
		crdVecinas[7][0] = x; //1
		crdVecinas[7][1] = y; //2
		
		int[][] crdVecinasClone = new int[8][2];
		
		int count = 0;
		
		for(int j = 0; j<crdVecinas.length; j++) {
				//Condicion que controla 
			if(crdVecinas[j][0]>=0 && crdVecinas[j][1]>=0) {
				
				if(crdVecinas[j][0]<t[0].length && crdVecinas[j][1]<t.length) {
					
					crdVecinasClone[count] = crdVecinas[j];
					
					count++;
					
				}
				
			}
			
			
		}
		
		
		return Arrays.copyOfRange(crdVecinasClone, 0, count);
	}
	public int vivas( char[][]t , int[][]crdVecinas){
		int vivas = 0;	
		
			for( int k = 0; k < crdVecinas.length; k++) {
				int x = crdVecinas[k][0];
				int y = crdVecinas[k][1];
				
				if( t[y][x] == 'X') {
					vivas++;
				}
				
			}
		
		
		return vivas;
	}
	public char [][] play(char[][] t){
		
		for( int i = 0; i<t.length; i++) {
			for(int x = 0; x<t[0].length; x++) {
				int[][] crdVecinas = vecinas(i, x, t);
				int numVivas = vivas(t, crdVecinas);
				System.out.println(" ");
				System.out.println("Celda: X: " + x + " Y: " + i + " Vecinas vivas: " + numVivas);
			}
		}
		
		
		return t;
	}
	
	public static void main(String[] args) throws InterruptedException {
		codeprim p = new codeprim();
		// TODO Auto-generated method stub"
		
		/*testvecinas
		
		Scanner s = new Scanner(System.in);

		boolean b = true;
		
		while(b) {
			
			System.out.println("x");
			int x = s.nextInt();
			
			System.out.println("y");
			int y = s.nextInt();
			
			int[][] v = p.vecinas(y, x, p.creatablero());
			
			for(int i=0; i<v.length; i++) {
				
				System.out.println("Vecina " + i + ": X: " + v[i][0] + " Y: " + v[i][1]);
				
			}
		}
		
		*/
		
		char answr = ' ';
		char [][] life = p.creatablero();
		boolean enmenu = false;
		System.out.println("Hola, se va a empezar el juego de la vida quieres continuar al menú?");
		System.out.println("Tu respuesta (s o n) : "); answr = e.next().toLowerCase().charAt(0); 
		if( answr == 's') {
			enmenu = true;
		}else {
			
		}
		while(enmenu == true) {
			System.out.println(" ");
			System.out.println("Que opción vas a escoger?");
				System.out.println("1:VISUALIZAR REGLAS: ");
				System.out.println("2:CREAR CÉLULAS MANUALMENTE: ");
				System.out.println("3:CREAR CÉLULAS AUTOMATICAMENTE: ");
				System.out.println("4:SETTINGS: ");
				System.out.println("5:CREAR VIDA: ");
				System.out.println("6:VISUALIZAR VIDA: ");
				System.out.println("7:EXiT? ");
			int option = e.nextInt();	
			switch(option) {	
				case 1: 
					System.out.println("HOLA! ESTAS SON LAS REGLAS DEL JUEGO DE LA VIDA: ");
					Thread.sleep(2000);
					System.out.println("-- EN EL JUEGO EXISTEN CÉLULAS VIVAS O MUERTAS EN EL TABLERO ");
					Thread.sleep(2000);
					System.out.println("-- CADA CÉLULA TIENE 8 POSIBLES CÉLULAS VECINAS QUE LA RODEAN ");
					Thread.sleep(2000);
					System.out.println("-- EN CADA GENERACIÓN O LAS CÉLULAS CAMBIAN, ES DECIR VIVEN O...MUEREN :) ");
					Thread.sleep(2000);
					System.out.println("-- SI HAY UNA CÉLULA QUE TIENE 2 O 3 CÉLULAS VECINAS ESTA VIVE\\");
					Thread.sleep(2000);
					System.out.println("-- SI HAY UNA CÉLULA QUE TIENE 4 O MÁS CÉLULAS VECINAS ESTA MUERE\\");
					Thread.sleep(2000);
					System.out.println("-- SI HAY UNA CÉLULA QUE TIENE 1 O 0 CÉLULAS VECINAS ESTA TAMBIÉN MUERE (POR SOLEDAD) \\");
					Thread.sleep(2000);
					System.out.println("-- SI HAY UNA CÉLULA MUERTA  QUE TIENE 3 CÉLULAS VECINAS VIVAS ESTA REVIVE\\");
					Thread.sleep(3000);
					System.out.println("Y...ESTAS SON TODAS LAS REGLAS DIVIERTETE!");
					enmenu = true;
					break;
				case 2: 
					p.CelManual(life);
					break;
				case 3:
					//Pa luego
				case 4:	
					//Config
					boolean insettings = true;
					while(insettings) {
						System.out.println("1:- Cambia la medida del tablero: ");
						System.out.println("2:- NNN");
						System.out.println("3:- XXX");
					}
					
				case 5:
					//Crear
					p.creatablero();
						enmenu = true;
						break;
				case 6:
					//Visualizar
					p.vertablero(life);
					p.play(life);
					break;
				case 7:	
					System.out.println("SALIENDO...");
					Thread.sleep(4000);
					enmenu = false;
					break;
					
			}
		}
	}

}
