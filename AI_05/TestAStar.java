package AI_05;



public class TestAStar {

	public static void main(String[] args) {
		Puzzle p = new Puzzle(true);
		p.readInput("src/Lab05/PuzzleMap.txt", "src/Lab05/PuzzleGoalState.txt");
		AStar aStar = new AStar();

		System.out.println("Processing with h1...");
		Node re = aStar.execute(p);
		PuzzleUtils.printPath(re);
		StringBuilder stb = new StringBuilder("\nUsed h1: G = " + re.getG() +
				", WHILE_LOOP = " + AStar.WHILE_LOOP);

		p.setUseH1(false);
		AStar.WHILE_LOOP = 0;
		System.out.println("\nProcessing with h2...");
		re = aStar.execute(p);
		PuzzleUtils.printPath(re);

		System.out.println(stb.append("\nUsed h2: G = " + re.getG() +
				", WHILE_LOOP = " + AStar.WHILE_LOOP).toString());
	}

}