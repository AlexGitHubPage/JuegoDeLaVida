import java.util.Arrays;
import java.util.Scanner;
public class codeprim {
	static Scanner e = new Scanner(System.in);
	
	public char [][] creatablero(int[] tm){ //Metodo que crea la vida o tablero
		char [][] t = new char [tm[0]][tm[1]];
		
			for( int i = 0; i < t.length; i++) {
				for( int j = 0; j < t[0].length; j++) {
					t[i][j] = '-';
					
				}
			}
			
		return t;
	}
	public void delay(long ms) { //PAUSEN 
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void vertablero( char[][] t){ //Visualización del tablero 
		for( int a = 0; a < t.length; a++) {
			System.out.println(" ");
			for( int h = 0; h < t[0].length; h++) {
			 System.out.print(t[a][h]);	
			 System.out.print(" ");
			}
		}
	}
	/*ACONSULTAR*/
	public int[] medidasnuevas( ) { //HACER LAS MEDIDAS NUEVAS METHOD
		int fil = 10;
		int col = 10;
		int []tm = new int[2];
		char answr = ' ';
		System.out.println("Puedes poner medidas nuevas al tablero: (10x10 por defecto) ");
		delay(100);
		System.out.println("Quieres ponerle una medida nueva al tablero? (s o n) ");
		answr = e.next().toLowerCase().charAt(0);
		if( answr == 's') {
			System.out.println("Introduce las filas: ");
			fil = e.nextInt();
			delay(200);
			System.out.println("Y las columnas: ");
			col = e.nextInt();
			delay(400);
			System.out.println("Cambiando modificaciones");
			tm[0] = fil;
			tm[1] = col;
			for( int i = 0; i<3; i++) {
			delay(700);
			System.out.print(".");	
			}
		}
		else {
			tm[0] = 10;
			tm[1] = 10;
		}
		
		return tm;
	}
	public int[] newreglas() { //Nuevas reglas 
		int [] nume = new int[3];
		int numero = 0;
		System.out.println("Hola, aqui podras cambiar el numero por  el cual se decide si una célula vive o muere ");
		delay(200);
		System.out.println("La condicion de por defecto según Conway es 3/2 es decir si el numero de vecinas es diferente de 3 o de 2 una célula muere");
		delay(100);
		System.out.println("Si el numero de vecinas es equal a 3 esta célula revive");
		delay(300);
		System.out.println("Introduciras 3 números para las tres condiciones respectivamente: ");
		delay(50);
		System.out.println("[]/[] - []");
		numero = e.nextInt();
		nume[0] = numero;
		delay(50);
		System.out.println("["+nume[0]+"]"+"/[] - []");
		delay(50);
		numero = e.nextInt();
		nume[1] = numero;
		delay(50);
		System.out.println("["+nume[0]+"]"+"/" + "["+nume[1]+"]" +  "[]");
		delay(50);
		numero = e.nextInt();
		nume[2] = numero;
		System.out.println("["+nume[0]+"]"+"/" + "["+nume[1]+"]" + "["+nume[2]+"]");
		return nume;
	}
	
	public char[][]  CelManual(char [][] t) { //Introducir la celula manualmente 
		System.out.println("En que fila vas a introducir esa celula? ");
		int fil = e.nextInt();
		System.out.println("En que columna vas a introducir la celula?");
		int col = e.nextInt();
		
		t[fil][col] = 'X';
		
		return t;
	}
	public char[][] CelAutomaticas( char[][]t ){ //Method automaticas
		System.out.println("Cuantas colonias quieres? ");
		int colonias = e.nextInt();
		
		for( int n = 0; n < colonias; n++) {
			int cx =  (int)(Math.random()*t[0].length);
			int cy = (int)(Math.random()*t.length);
			if( t[cy][cx] == 'X' || ( (cx == 0 || cx == t[0].length-1)&&( cy == 0 || cy == t.length))) {
				n--;
			}
			else {
				t[cy][cx] = 'X';
				
				int[][] be = vecinas(cy,cx,t);
				 while(vivas(t, be) < 4) {
					
					int coodx; 
					int	coody;  
						do {
							 be = vecinas(cy,cx,t);
							int r4 = (int)(Math.random()*be.length);
							int[] r5 = be[r4];
							coodx = r5[0];
							coody = r5[1];
							
							
							
						}while(t[coody][coodx] == 'X');
						t[coody][coodx] = 'X';
						
				}
				//Bucle con las coordenadas previas que pone la colonia restante en las vecinas
				
			}
			
		}
		
		
		
		
		return t;
	}
	
	
	
	public int[][]vecinas(int colu, int fila, char[][]t){ //1, 1 //Detección de las celulas vecinas
		
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
				//Condicion que controla que la vecina no sea negativa o más alta que la longitud del tablero con vida 
			if(crdVecinas[j][0]>=0 && crdVecinas[j][1]>=0) {
				
				if(crdVecinas[j][0]<t[0].length && crdVecinas[j][1]<t.length) {
					
					crdVecinasClone[count] = crdVecinas[j];
					
					count++;
					
				}
				
			}
			
			
		}
		
		
		return Arrays.copyOfRange(crdVecinasClone, 0, count); //Del rango desde 0 hasta el contador de las vecinas contadas
	}
	
	public int vivas( char[][]t , int[][]crdVecinas){ //Total de vecinas para controlar el status de una celula concreta 
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
	
	public char[][] play(char[][] t, int[] nume){ //Cambiar por tres numeros distintos - metodo newreglas
			int cont = 0;
		for( int b = 0; b < t.length; b++) {
			for( int n = 0; n<t[0].length; n++) {
				if( t[b][n] == 'X') {
					cont++;
				}
			}
		}
		if(cont<5){
			System.out.println(" ");
			System.out.println("Debes introducir 5 células vivas mínimo");
			delay(200);
			System.out.println("Accede desde el menu a la opción de células automàticas o manuales");
			return null;
		}
	 
		
		char [][] ident = new char [t.length][t[0].length];
		for( int i = 0; i<ident.length; i++) for( int j = 0; j<ident[0].length; j++) ident[i][j] = t[i][j];
		
		for( int i = 0; i<t.length; i++) {
			
			for(int x = 0; x<t[0].length; x++) {
				
				int[][] crdVecinas = vecinas(i, x, ident);
				
				int numVivas = vivas(ident, crdVecinas);
				
				if( ident[i][x] == 'X' && !( numVivas == nume[0] || numVivas == nume[1]) ){ //Aqui va la variable a modificar
						
					t[i][x] = '-';
				}
				else if( ident[i][x] == '-' && numVivas == nume[2] ) {
					t[i][x] = 'X';
				}
				
			}
		}
		
		return t;
	
	}
	
	public static void main(String[] args)  {
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
		 // A consultar
		
		boolean enmenu = false;
		System.out.println("Hola, se va a empezar el juego de la vida quieres continuar al menú?");
		System.out.println("Tu respuesta (s o n) : "); 
		answr = e.next().toLowerCase().charAt(0); 
		if( answr == 's') {
			enmenu = true;
		}else {
			
		}
		int[] n = {3,2,3};		// Inicializar en nulo o por defecto					
		char [][] life = null; //
		while(enmenu == true) {
			System.out.println(" ");
			System.out.println("Que opción vas a escoger?");
				System.out.println("1:VISUALIZAR REGLAS: ");
				System.out.println("2:CREAR CÉLULAS MANUALMENTE: ");
				System.out.println("3:CREAR CÉLULAS AUTOMATICAMENTE: ");
				System.out.println("4:SETTINGS: ");
				System.out.println("5:CREAR VIDA (CUIDADO!! ESTO DESHARÁ LOS CAMBIOS DE VIDA PREVIA) : ");
				System.out.println("6:JUGAR: ");
				System.out.println("7: VISUALIZAR SOLO EL MAPA: ");
				System.out.println("8:EXiT? ");
			int option = e.nextInt();	
			switch(option) {	
				case 1:
					//Delay rules
					System.out.println("HOLA! ESTAS SON LAS REGLAS DEL JUEGO DE LA VIDA: ");
					p.delay(2000);
					System.out.println("-- EN EL JUEGO EXISTEN CÉLULAS VIVAS O MUERTAS EN EL TABLERO ");
					p.delay(2000);
					System.out.println("-- CADA CÉLULA TIENE 8 POSIBLES CÉLULAS VECINAS QUE LA RODEAN ");
					p.delay(2000);
					System.out.println("-- EN CADA GENERACIÓN O LAS CÉLULAS CAMBIAN, ES DECIR VIVEN O...MUEREN :) ");
					p.delay(2000);
					System.out.println("-- SI HAY UNA CÉLULA QUE TIENE 2 O 3 CÉLULAS VECINAS ESTA VIVE\\");
					p.delay(2000);
					System.out.println("-- SI HAY UNA CÉLULA QUE TIENE 4 O MÁS CÉLULAS VECINAS ESTA MUERE\\");
					p.delay(2000);
					System.out.println("-- SI HAY UNA CÉLULA QUE TIENE 1 O 0 CÉLULAS VECINAS ESTA TAMBIÉN MUERE (POR SOLEDAD) \\");
					p.delay(2000);
					System.out.println("-- SI HAY UNA CÉLULA MUERTA  QUE TIENE 3 CÉLULAS VECINAS VIVAS ESTA REVIVE\\");
					p.delay(3000);
					System.out.println("Y...ESTAS SON TODAS LAS REGLAS DIVIERTETE!");
					enmenu = true;
					break;
				case 2:
					//Celulas manuales
					p.CelManual(life);
					break;
				case 3:
					//Pa luego //Automaticas
					p.CelAutomaticas(life);
					break;
				case 4:	
					//Config
					boolean insettings = true;
			while(insettings) {
						System.out.println("Estas son las opciones:" );
						p.delay(300);
						System.out.println("1.- Cambiar la medida del tablero: ");
						p.delay(300);
						System.out.println("2.- Cambiar las condiciones de las reglas: ");
						p.delay(200);
						System.out.println("Introduce tu opción: ");
						int opt = e.nextInt();
						switch(opt) {
							
							case 1:
								p.medidasnuevas(); //Settings
								
							case 2: 
								p.newreglas();//Settings
						
						}	
					}
					
				case 5:
					//Crear
					life = p.creatablero(p.medidasnuevas()); //Crear vida o tablero
						enmenu = true;
						break;
				case 6:
					//Play
					boolean ingame = true;
					int gen = 0;
					
					p.vertablero(life);
					
					while(ingame) { 
					char[][]table = p.play(life, n);
					if(table == null) {
						ingame = false;
					}
					else {
					p.vertablero(table); /*p.medidasnuevas() A CONSULTAR*/
					p.delay(100);
					gen++;
					System.out.println(" ");
					System.out.println("Generación: " + gen);
					
					}
					}
					break;
				case 7: 
					//Visual
					p.vertablero(life);
					
					break;
				case 8:	
					System.out.println("SALIENDO...");
					p.delay(4000);
					enmenu = false;
					break;
					
			}
		}
	}

}
