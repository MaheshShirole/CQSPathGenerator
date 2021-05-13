package ScenarioGenerator;

import java.util.LinkedList;

public class Activity {
	int id;
	String name;
	String umlId;
	int type;
	String preCondition;
	String postCondition;
	String documentation;
	boolean visited=false;  // for search operation status
	int visitCount=0; // visit count used in modified DFS algorithm
	int levelNumber=0; // Level number used for level permutation search algorithm
	LinkedList<Integer> predecessor;
	
	public Activity(String UMLID, String Name, int Type){
		name=Name;
		umlId=UMLID;
		type=Type;
		predecessor = new LinkedList<Integer>();;
	}
	public void setId(int ID){
		id=ID;
	}
	public int getId(){
		return id; 
	}
	public void setVisited(boolean flag){
		visited=flag;
	}
	public boolean getVisited(){
		return visited;
	}
	public void clearVisitCount(){
		visitCount=0;
	}
	public int getVisitCount(){
		return visitCount;
	}
	public void setVisitCount(){
		visitCount++;
	}
	public void setPreCondition(String Precondition){
		preCondition =Precondition;
	}
	public void setPostCondition(String Postcondition){
		postCondition=Postcondition;
	}
	public void setDocumentation(String Documentation){
		documentation=Documentation;
	}
	public String getName(){
		return name;
	}
	public String getUmlId(){
		return umlId;
	}
	public String getPreCondition(){
		return preCondition;
	}
	public String getPostCondition(){
		return postCondition;
	}
	public String getDocumentation(){
		return documentation;
	}
	public void setlevelNumber(int level){
		levelNumber=level;
	}
	public int getlevelNumber(){
		return levelNumber;
	}
	public String getType(){
		String result="";
		switch(type){
		case 0: {result="Start"; break;}
		case 1: {result="Action"; break;}
		case 2: {result="End"; break;}
		case 3: {result="Flow End"; break;}
		case 4: {result="Decision"; break;}
		case 5: {result="Merge"; break;}
		case 6: {result="Fork"; break;}
		case 7: {result="Join"; break;}
		case 8: {result="Send Signal"; break;}
		case 9: {result="Receive Signal"; break;}
		case 10: {result="Lock"; break;}
		case 11: {result="Unlock"; break;}
		}
		return result;
	}
	public int getTypeNumber(){
		return type;
	}
	public void addPredecessor(int node){
		predecessor.addLast(node);
	}
	public LinkedList<Integer> getPredecessor(){
		return predecessor;
	}
	public String toString(){
		String result="";
		result=this.getId()+":"+this.getType()+"-"+this.getName()+":"+this.getVisited();
		return result;
	}
}
