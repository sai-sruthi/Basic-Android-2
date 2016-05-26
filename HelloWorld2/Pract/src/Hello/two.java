package Hello;

import java.util.Scanner;

public class two {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=0,d=0,x=0;
		int sum=0;
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		d=sc.nextInt();
		System.out.println(n+d);
		int a[]=new int[n];
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
			}
		if(d>=0){
			x=0;
			for(int i=0;i<n;i++){
				
				if(a[i]%10>4){
					sum+=a[i]-(a[i]%10)+10;
				}	
				else {
					x+=a[i];
					System.out.println(x);
					if(x%10>4){
					x-=a[i];
					System.out.println(x);
					sum+=(x-(x%10));
					d--;
					x=0;
					i--;
					}
				}
				
			}
		}
		
		System.out.println(sum);
		
	}

}
