package Hello;

import java.util.Scanner;

public class Tiling {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		long m,n,ans;
		m=sc.nextInt();
		n=sc.nextInt();
		if(m%2==0 ){
			ans=m/2*n;
		}
		else if(n%2==0 ){
			ans=n/2*m;
		}
		else{
		long x=Math.min(m,n);
		long y=Math.max(m, n);
		x=x-1;
		ans=(y*(x/2))+((y+1)/2);	
				
		}
System.out.println(ans);
	}

}
