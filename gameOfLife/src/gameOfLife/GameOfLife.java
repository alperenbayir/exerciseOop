package gameOfLife;

public class GameOfLife {

	private boolean[][] cells;

	public GameOfLife(int n) {
		cells = new boolean[n][n];
	}

	public GameOfLife(boolean[][] cells) {
		for (int i = 0; i < cells.length; i++) { // cells muss Rechteckig sein.
			for (int k = 0; k < cells[i].length; k++) {
				if (cells[i].length != cells.length) {
					throw new RuntimeException();
				}
			}
		}
		this.cells = cells;
	}

	private boolean nextState(int i, int j) {
		int aliveNeighbours = countAliveNeighbors(i, j);
		if (cells[i][j]) { // bleibt lebendig, bei 2 oder 3 Nachbarn
			return aliveNeighbours >= 2 && aliveNeighbours <= 3;
		}
		return aliveNeighbours == 3; // wird lebeindig bei 3 Nachbarn
	}

	/**
	 * Zählt die lebendigen Nachbarn einer Zelle (line,column).
	 */
	private int countAliveNeighbors(int line, int column) {
		int result = -getCountAt(line, column); // mittige Zelle darf nicht
												// mitgezählt werden
		for (int lineOffset = -1; lineOffset <= 1; lineOffset++) {
			for (int colOffset = -1; colOffset <= 1; colOffset++) {
				result = result + getCountAt(line + lineOffset, column + colOffset);
			}
		}
		return result;
	}

	/**
	 * Zählt eine einzige Zelle. Zellen außerhalb des Arrays werden als Tot gezählt.
	 */
	private int getCountAt(int line, int column) {
		boolean cellAlive = isValidPosition(line, column) && cells[line][column];
		if (cellAlive) {
			return 1;
		}
		return 0;
	}

	/**
	 * Prüft ob cells[line][column] eine gültige Feldadresse ist.
	 */
	private boolean isValidPosition(int line, int column) {
		if (line >= 0 && line < cells.length) {
			if (column >= 0 && column < cells[line].length) {
				return true;
			}
		}
		return false;
	}

	public void nextGeneration() {
		boolean[][] temp_cells = new boolean[cells.length][cells.length];
		for (int line = 0; line < temp_cells.length; line++) {
			for (int col = 0; col < temp_cells.length; col++) {
				temp_cells[line][col] = nextState(line, col);
			}
		}
		cells = temp_cells;
	}

	public void futureGeneration(int nthGeneration) {
		for (int generation = 1; generation <= nthGeneration; generation++) {
			nextGeneration();
		}
	}

	public void show() {
		System.out.print("+-");
		for (int i = 0; i < cells.length; i++) {
			System.out.print("--");
		}
		System.out.println("+");
		for (boolean[] line : cells) {
			System.out.print("| ");
			for (boolean cell : line) {
				printCell(cell);
			}
			System.out.println("|");
		}
		System.out.print("+-");
		for (int i = 0; i < cells.length; i++) {
			System.out.print("--");
		}
		System.out.println("+");
	}

	private void printCell(boolean alive) {
		if (alive) {
			System.out.print("X ");
		} else {
			System.out.print("  ");
		}
	}

	public void randomState() {
		for (boolean[] arr : cells) {
			for (int i = 0; i < arr.length; i++) {
				if (java.lang.Math.random() < 0.3) {
					arr[i] = true;
				}
			}
		}
	}

	public void wait(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
