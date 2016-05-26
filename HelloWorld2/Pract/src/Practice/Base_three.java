package Practice;

import java.util.ArrayList;
import java.util.Scanner;

public class Base_three {

	/**
	 * @param args
	 */
	public int logvalue(int x){
		double y=(Math.log(x)/Math.log(3));
		int ans=(int) Math.floor(y);
		return ans;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Base_three bt=new Base_three();
		int input;
		Scanner sc=new Scanner(System.in);
		input=sc.nextInt();
		ArrayList<Integer> a=new ArrayList<Integer>();
		//System.out.println((int)Math.pow(5, 3));
		while(input>0){
			int x=bt.logvalue(input);
			a.add(x);
			input=(input-((int)Math.pow(3, x)));
			
		}
		System.out.println(a);
		
	}

}
