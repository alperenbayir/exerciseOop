package gameOfLife;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		GameOfLife gol = new GameOfLife(10);
		gol.randomState();
		gol.show();
		System.out.println();
		gol.nextGeneration();
		gol.show();
		System.out.println();
		gol.futureGeneration( 10);
		gol.show();
		System.out.println();
		gol.futureGeneration(15);
		gol.show();
		System.out.println();

		int size = 15;
		boolean[][] area = new boolean[size][size];
		for (int line = 0; line < area.length; line++) {
			for (int col = 0; col < area[line].length; col++) {
				area[line][col] = false;
			}
		}
		area[size - 3][size - 3] = true;
		area[size - 3][size - 2] = true;
		area[size - 2][size - 1] = true;
		area[size - 2][size - 3] = true;
		area[size - 1][size - 3] = true;

		gol = new GameOfLife(area);
		for (int n = 0; n < 50; n++) {
			gol.show();
			gol.nextGeneration();
			System.out.println();
			gol.wait(1000);
		}
		
		
	}

}
