package utils;

public class Factorial {
	public static int getFactorial(int number){
		int result=1;
		for (int i= 1; i<=number; i++){
			  result=result*i;
			  }
		return result;
	}
	
}
