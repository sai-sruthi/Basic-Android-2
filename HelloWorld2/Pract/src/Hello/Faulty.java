package Hello;

import java.util.Scanner;

public class Faulty {
	public static void main(String[] args) {
	int n;
	Scanner sc=new Scanner(System.in);
	n=sc.nextInt();
	int a;
	a=(int)(Math.ceil((Math.log(n)/Math.log(2))));
	System.out.println(a);
	}
}
