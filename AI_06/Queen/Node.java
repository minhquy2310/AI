package AI_06.Queen;
import java.util.TreeSet;
import java.awt.Taskbar.State;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.SortedSet;
public class Node {
	public static final int N = 8;
	private Queen[] state;

	public Node() {
		// generateBoard();
		
		state = new Queen[N];
		generateBoard();
	}

	public Node(Queen[] state) {
		this.state = new Queen[N];
		for (int i = 0; i < state.length; i++) {
			this.state[i] = new Queen(state[i].getRow(), state[i].getColumn());
		}
	}

	public Node(Node n) {
		this.state = new Queen[N];
		for (int i = 0; i < N; i++) {
			Queen qi = n.state[i];
			this.state[i] = new Queen(qi.getRow(), qi.getColumn());
		}
	}

	public void generateBoard() {
		Random random = new Random();
		for (int i = 0; i < N; i++) {
			state[i] = new Queen(random.nextInt(N), i);
		}
	}

	public int getH() {
		int heuristic = 0;
		for (int i = 0; i < N - 1; i++)
			for (int j = i + 1; j < N; j++)
				if (state[i].isConflict(state[j]))
				return heuristic++;
		return heuristic;
	}

	public List<Node> generateAllCandidates() {
		List<Node> result = new ArrayList<Node>();
		for(int i=0 ; i < N;i++ ) {
			Node copy = new Node(this.state);
			copy.state[i].move();
		    result.add(copy);
		  
			
		}
		// Enter your code here
		return result;
	}

	public Node selectNextRandomCandidate() {
		Random r = new  Random();
		int i =r.nextInt(N);
		int row =r.nextInt(N);
		
		Node n = new Node(state);
		n.state[i].setRow(row);
		return null;
	}
	public int getRow(int i) {
		return state[i].getRow();
	}
	public void setRow(int i, int row) {
		state[i].setRow(row);
	}
	public Queen[] getState() {
		return state;
	}
	public Node execute(Node initialState) {
		Node current = initialState;
		Node neghbor =null;
		while(true) {
			neghbor = current.getBestCandidate();
			if(neghbor.getH()<current.getH())
				current = neghbor;
			return current;
		}
		
		}
	Node getBestCandidate() {
		SortedSet<Node> set = new TreeSet<>(generateAllCandidates());
		return set.first();
	}

	public Node executeHillClimbingWithRandomRestart(Node initialState) {
		
	
		return null ;
		}

	public void displayBoard() {
		int[][] board = new int[N][N];
		// set queen position on the board
		for (int i = 0; i < N; i++) {
			board[state[i].getRow()][state[i].getColumn()] = 1;
		}
		// print board
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 1) {
					System.out.print("Q" + " ");
				} else {
					System.out.print("-" + " ");
				}
			}
			System.out.println();
		}
	}
}