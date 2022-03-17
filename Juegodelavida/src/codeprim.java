import java.util.Scanner;
public class codeprim {
	static Scanner e = new Scanner(System.in);
	
	public char [][] vertablero(){
		char [][] t = new char [10][10];
		
			for( int i = 0; i < t.length; i++) {
				for( int j = 0; j < t[0].length; j++) {
					t[i][j] = '-';
					
				}
			}
		
			for( int a = 0; a < t.length; a++) {
				System.out.println(" ");
				for( int h = 0; h < t[0].length; h++) {
				 System.out.print(t[a][h]);	
				 System.out.print(" ");
				}
			}
			
		return t;
	}
	
	public void  CelManual(int [][] t) {
		
		
		for( int j= 0; j< t.length; j++) {
			for( int x = 0; x < t[0].length; x++) {
				System.out.print("");
			}
		}
		int cel = 1;
		
		;
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		codeprim p = new codeprim();
		// TODO Auto-generated method stub"
		char answr = ' ';
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
				System.out.println("5:VISUALIZAR VIDA: ");
				System.out.println("6:EXiT? ");
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
					
					//p.CelManual(p.vertablero());
				case 3:
					//Pa luego
				case 4:	
					//Config
				case 5:
					//Visual
					p.vertablero();
						enmenu = true;
						break;
				case 6:	
					System.out.println("SALIENDO...");
					Thread.sleep(4000);
					enmenu = false;
					break;
					
			}
		}
	}

}
