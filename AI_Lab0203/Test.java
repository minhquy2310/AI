package AI_Lab0203;

import java.util.List;

public class Test {
	public static void main(String[] args) {
		Node nodeS = new Node("S");
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");
		Node nodeG = new Node("G");
		Node nodeH = new Node("H");
		nodeS.addEdge(nodeA, 5);
		nodeS.addEdge(nodeB, 2);
		nodeS.addEdge(nodeC, 4);
		nodeA.addEdge(nodeD, 9);
		nodeA.addEdge(nodeE, 4); 
		nodeB.addEdge(nodeG, 6);
		nodeC.addEdge(nodeF, 2); 
		nodeD.addEdge(nodeH, 7);
		nodeE.addEdge(nodeG, 6);
		nodeF.addEdge(nodeG, 1);
		
		Node A = new Node("A");
		Node B = new Node("B");
		Node C = new Node("C");
		Node D = new Node("D");
		Node E = new Node("E");
		
		A.addEdge(B);
		A.addEdge(C);
		B.addEdge(D);
		C.addEdge(E);
 

////////////Task 1
		ISearchAlgo algo1 = new DepthFirstSearchAlgo();
		
		Node result1 = algo1.execute(nodeS, "G");
		
		System.out.println("DFS:"+NodeUtils.printPath(result1));
		System.out.println("--------------------------------------");
		UniformCostSearchAlgo UCS = new UniformCostSearchAlgo();
		Node NodeSG = UCS.execute(nodeS, "G");
	    ISearchAlgo algo2 = new UniformCostSearchAlgo();
	    Node result2 = algo2.execute(nodeS,"G");

	    NodeUtils.print(NodeSG);	
		
	
		
		
	}
	
	

}
