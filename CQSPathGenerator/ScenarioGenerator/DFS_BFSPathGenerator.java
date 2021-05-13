package ScenarioGenerator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFS_BFSPathGenerator extends PathGenerator {

	public DFS_BFSPathGenerator(ActivityGraph graph) {
		super(graph);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getPath() {
		String path = "";	
		 // DFS uses Stack data structure
		 Stack s = new Stack();
		 //BFS uses queue data structure
		 Queue q=new LinkedList();
		 Activity temp =graph.getActivity(graph.getRootNode()); //get root node of the tree
		 s.push(temp); // push root node on Stack
		 temp.setVisited(true); // set visited flag true
		 //System.out.println(temp);
		 path+=temp.getName();
		 while(!s.isEmpty()){
			 Activity n=(Activity)s.peek(); // get top element on stack
			 //check if top element of stack is Fork node
			 if(n.getType().equals("Fork")){
				 //Start BFS search up to next Join node
				 q.add(n);// add root node in the queue
				 n.setVisited(true); // set visited flag true
				 //System.out.println(n);
				 while(!q.isEmpty()){
					 //System.out.println("Queue not empty");
					 n=(Activity)q.remove();
					 Activity child=null;
					 while((child=graph.getUnvisitedChildNode(n))!=null)
					 {
						 //System.out.println("Inside child");
						 child.setVisited(true); // set visited flag true
						 //System.out.println(child);
						 path+="-"+child.getName();
						 //check if child node is Join
						 if(!child.getType().equals("Join")){
							 q.add(child);
						 }else{
							 n=child;
						 }
					 }
				 }
				 
				 // start the DFS search				 
			 }

			 Activity child=graph.getUnvisitedChildNode(n);
			 if(child!=null)
			 {
				 child.visited=true;
				 //System.out.println(child);
				 path+="-"+child.getName();
				 s.push(child);
			 }
			 else
			 {
				 s.pop();
			 }
			 if(n.getType().equals("End"))
				 break;	
		 }
		 graph.clearNodes();

		return path;
	}

	@Override
	public String[] getPathSet(int noOfPaths) {
		setStartTime();
		String [] pathSet= new String[noOfPaths];
		for(int i=0;i<noOfPaths;i++){
			pathSet[i]=this.getPath();
		}
		setEndTime();
		return pathSet;
	}
	public static void main(String[] args){
		ActivityGraph graph= new ActivityGraph();
		DFS_BFSPathGenerator dfs_bfs = new DFS_BFSPathGenerator(graph);
		//dfs_bfs.loadActivityGraph("src\\bank.txt");
		//dfs_bfs.loadActivityGraph("src\\GraphicsUtility.txt");
		//dfs_bfs.loadActivityGraph("src\\AirPortCheckIn_new.txt");
		//dfs_bfs.loadActivityGraph("src\\ATM_New.txt");
		//dfs_bfs.loadActivityGraph("src\\BankTransaction_New.txt");
		dfs_bfs.loadActivityGraph("src\\DiningPhilosopher.txt");
		int maxPaths=graph.getpathcount();
		//int maxPaths=25;
		System.out.println("Total distinct paths: "+maxPaths);
		//System.out.println(graph);
		//String path=dfs_bfs.getPath();
		//System.out.println("\nDFS_BFS Path: "+path);
	
	String []Paths=dfs_bfs.getPathSet(maxPaths);
	System.out.println("\nDFS_BFS Path set: ");
	for(int i=0; i<maxPaths;i++){
		System.out.println(Paths[i]);
	}
	ArrayList<String> UniquePaths=dfs_bfs.getDistinctPathSet(Paths);
	System.out.println("\nDFS_BFS Unique Path set: ");
	for(int i=0; i<UniquePaths.size();i++){
		System.out.println(UniquePaths.get(i));
	}

	}
}