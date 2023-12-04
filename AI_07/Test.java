package AI_07;


public class Test {
	public static void main(String[] args) {
		GA_NQueenAlgo ga = new GA_NQueenAlgo();

		Node hehe = ga.execute();
		System.out.println("H = " + hehe.getH());
		hehe.displayBoard();

		
}
}