package Practice;

import java.util.Scanner;

public class Hello {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t;
		Scanner sc =new Scanner(System.in);
		t=sc.nextInt();
		int a[]=new int[t];
		for(int i=0;i<t;i++){
			a[i]=sc.nextInt();
		}
		for(int i=0;i<t;i++){
			if(a[i]%2==0){
				System.out.println(a[i]+" is even");
			}
			else{
				System.out.println(a[i]+" is odd");
			}
		}
	}

}
