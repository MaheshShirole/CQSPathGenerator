package utils;

import java.util.ArrayList;

public class PermutationGenerator {
	static String sourceString;
	static ArrayList<String> permutations = new ArrayList<String>();
	public PermutationGenerator(String data){
		sourceString=data;
	}
    public void permute() { 
    	String s=sourceString;
    	permutations.clear();
    	permute1("",s); 
    	}
    private static void permute1(String prefix, String s) {
        int N = s.length();
        if (N == 0) permutations.add(prefix);
        else {
            for (int i = 0; i < N; i++)
               permute1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, N));
        }
    }
    private void print(){
    	for(int i=0; i<permutations.size();i++){
    		System.out.println(permutations.get(i));
    	}
    }
	public ArrayList<String> getPermutations() {
		return permutations;
	}
    
    public static void main(String[] args){
    	PermutationGenerator pg = new PermutationGenerator("456");
    	pg.permute();
    	pg.print();
    	System.out.println(pg.getPermutations());
    }

}