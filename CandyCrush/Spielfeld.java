package CandyCrush;

public class Spielfeld {
	private Player player;
	private String[][] array;
	private String[] buchstaben = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
			"R", "S", "T", "U", "V", "W", "X", "Y", "Z" };

	public Spielfeld(Player player1, Player player2, String[][] array) {
		this.player = player2;
		this.player = player1;
		this.array = array;
	}

	public void druckeSpielfeld() {
		
		
		System.out.print("  ");
		for (int i = 0; i < array[0].length; i++) {
			System.out.print(i + " ");
		}
		System.out.println();

		for (int i = 0; i < array.length; i++) {
			System.out.print(i + " ");
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}

	}

	public boolean testeZug(int z, int s, String a) {
		if (z >= 0 && z < array.length && s >= 0 && s < array[0].length) {
			if (s + 1 < array[0].length && a.equals("r")) {
				if (!array[z][s].equals("  ") && !array[z][s + 1].equals("  ")) {

					return true;

				}
			}
			if (z - 1 >= 0 && a.equals("o")) {
				if (!array[z][s].equals("  ") && !array[z - 1][s].equals("  ")) {

					return true;

				}

			}
		}
		return false;
	}

	public void führeZugAus(int z, int s, String a, Player p) {
		if (testeZug(z, s, a) && a.equals("r")) {
			String b = array[z][s];
			array[z][s] = array[z][s + 1];
			array[z][s + 1] = b;
			if (array[z][s].equals(array[z][s + 1])) {
				for (int i = 0; i < buchstaben.length; i++) {
					if (buchstaben[i].equals(array[z][s + 1])) {
						p.addPunkte((i + 1) * 2);
						break;
					}
				}
				array[z][s] = " ";
				array[z][s + 1] = " ";
				for (int i = z; i >= 0; i--) {
					if (i - 1 >= 0) {
						array[i][s] = array[i - 1][s];
						array[i - 1][s] = " ";
					}
				}
				for (int i = z; i >= 0; i--) {
					if (i - 1 >= 0) {
						array[i][s + 1] = array[i - 1][s + 1];
						array[i - 1][s + 1] = " ";
					}
				}
			} else if (s + 2 < array[0].length && array[z][s + 1].equals(array[z][s + 2])) {
				for (int i = 0; i < buchstaben.length; i++) {
					if (buchstaben[i].equals(array[z][s + 2])) {
						p.addPunkte(i + 1);
						break;
					}
				}
				array[z][s + 2] = " ";
				for (int i = z; i >= 0; i--) {
					if (i - 1 >= 0) {
						array[i][s + 2] = array[i - 1][s + 2];
						array[i - 1][s + 2] = " ";
					}
				}

			}

		}
		if (testeZug(z, s, a) && a.equals("o")) {
			String b = array[z][s];
			array[z][s] = array[z - 1][s];
			array[z - 1][s] = b;
			if (array[z][s].equals(array[z - 1][s])) {
				for (int i = 0; i < buchstaben.length; i++) {
					if (buchstaben[i].equals(array[z - 1][s])) {
						p.addPunkte((i + 1) * 2);
						break;
					}
				}
				array[z][s] = " ";
				array[z - 1][s] = " ";
				if (z - 2 >= 0) {
					int pos =z;
					for (int i = z -2; i >= 0; i--) {
					
							array[pos][s] = array[i][s];
							array[i][s]= " ";
							pos--;
					}
				}
			}
		
		
			else if (z - 2 >= 0 && array[z - 1][s].equals(array[z - 2][s])) {
			for (int i = 0; i < buchstaben.length; i++) {
				if (buchstaben[i].equals(array[z - 2][s])) {
					p.addPunkte(i + 1);
					break;
				}
			}
			array[z - 2][s] = " ";
			for (int i = z - 2; i >= 0; i--) {
				if (i - 1 >= 0) {
					array[i][s] = array[i - 1][s];
					array[i - 1][s] = " ";
				}

			}
		}

	}
}
	

	public boolean testeEnde(Player p) {
		int count = 0;
		int countCheck = 0;
		for (int f = 0; f < buchstaben.length; f++) {
			for (int j = 0; j < array[0].length; j++) {
				for (int i = 0; i < array.length; i++) {

					if (array[i][j].equals(buchstaben[f])) {
						count++;
						
					}
					if(array[i][j].equals(" ")) {
						countCheck++;
					}
					
					
					if (count >= 2)
						return false;
				}
				if (countCheck == 0) {
					count = 0;
				}
				countCheck = 0;
			}
		}

		return true;
	}
}
