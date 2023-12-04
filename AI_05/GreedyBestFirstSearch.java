package AI_05;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class GreedyBestFirstSearch implements IPuzzleAlgo {

	@Override
	public Node execute(Puzzle model) {
		// TODO Auto-generated method stub
		PriorityQueue<Node > frontier = new PriorityQueue<Node>(PuzzleUtils.HeuristicComparatorByH);
		List<Node> explored = new ArrayList<Node>();
		frontier.add(model.getInitialState());
		while(!frontier.isEmpty()) {
			Node current = frontier.poll();
			if(current.equals(model.getGoalState())) return current;
			else {
				explored.add(current);
				List<Node> children = model.getSuccessors(current);
				for(Node child :children) {
					if(frontier.contains(child) && explored.contains(child)) {
						frontier.add(child);
						child.setG(current.getG()+1);
						frontier.add(child);
					}
					
				}
			}
		}
		
		
		return null;
	}

}