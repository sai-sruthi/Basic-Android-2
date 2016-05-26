package Hello;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,c=0;
		ArrayList<String> a=new ArrayList();
		
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		for(int i=0;i<2*n+1;i++){
			a.add(sc.nextLine());
		}
		
		for(int i=1;i<n+1;i++){
			for(int j=n+1;j<a.size();j++){
				if(a.get(i).equals(a.get(j))){
					a.remove(j);
					c++;
					break;
				}
			}
		}
		System.out.println(c);
	}

}
