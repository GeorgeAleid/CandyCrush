package CandyCrush;

public class Player {
	private int number;
	private int punkte;
	
	public Player(int number,int punkte) {
		this.number=number;
		this.punkte=punkte;
		
	}

	public int getNumber() {
		return number;
	}


	public int getPunkte() {
		return punkte;
	}

	public void addPunkte(int punkte) {
		this.punkte += punkte;
	}
}
