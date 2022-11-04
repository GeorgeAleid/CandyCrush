package CandyCrush;
import java.util.Random;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Player p1 = new Player(1,0);
		Player p2 = new Player(2,0);
		String [][] array = new String [3][3];
		Spielfeld sp= new Spielfeld(p1,p2,array);
		Scanner sc =new Scanner(System.in);
		
//       Random wert
		Random rand = new Random();
		 
		 String[] buchstaben = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
					"R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
		 
		 for (int i=0; i<array.length; i++) {
			 for (int j=0; j<array[0].length; j++) {
			  int f = rand.nextInt(buchstaben.length);
			  array[i][j]=buchstaben[f];
		 }
			 }
		
		boolean player=true;
		do {
			if(player) {
				System.out.println(" Spieler: "+ p1.getNumber());
				sp.druckeSpielfeld();
				System.out.println("von zeile");
				int z= sc.nextInt();
				System.out.println("von spalte");
				int s= sc.nextInt();
				System.out.println("Oben o oder recht r?");
				String a = sc.next();
				if (sp.testeZug(z,s,a)) {
					sp.führeZugAus(z,s,a,p1);
					player=false;
				}
				System.out.println("Punkte: "+p1.getPunkte()); 
				
				System.out.println();
				System.out.println();
				
				
			}
			else {
				System.out.println(" Spieler: "+ p2.getNumber());
				sp.druckeSpielfeld();
				System.out.println("von zeile");
				int z= sc.nextInt();
				System.out.println("von spalte");
				int s= sc.nextInt();
				System.out.println("Oben o oder recht r?");
				String a = sc.next();
				if (sp.testeZug(z,s,a)) {
					sp.führeZugAus(z,s,a,p2);
					player=true;
				}
				System.out.println("Punkte: "+p2.getPunkte()); 
				
				System.out.println();
				System.out.println();
				
				
				
			}
		}
		while(!sp.testeEnde(p1)&&!sp.testeEnde(p2));
		if(p1.getPunkte()>p2.getPunkte()) {
			System.out.println("Spieler "+ p1.getNumber() + " hat gewonnen");
		}
		else if (p1.getPunkte()<p2.getPunkte()){
			System.out.println("Spieler "+ p2.getNumber() + " hat gewonnen");
		}
		else System.out.println("tie!!");
		
		
//		 for(int i =0;i<array.length;i++) {
//			 for(int j =0;j<array.length;j++) {
//				 System.out.print(array[i][j]+"  ");
//			 }
//			 System.out.println();
//		 }
	}

}
