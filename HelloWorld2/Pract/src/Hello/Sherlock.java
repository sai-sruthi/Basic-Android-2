package Hello;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;


public class Sherlock {

	/**
	 * @param args
	 */
	
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Sherlock sher = new Sherlock();
		int t;
		
		int n;
		
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		String output[]=new String[t];
		int z=0;
		while(t>0){
			
		n=sc.nextInt();
		ArrayList<String> a=new ArrayList();
		
		for(int i=0;i<n;i++){
			a.add(sc.next());
			//System.out.println(a.get(i));
		}
		String s=sc.next();
		int m=s.length();
		ArrayList<Integer> ans=new ArrayList();
		
		for(int i=0;i<n;i++){
		if(a.get(i).length()==s.length()){
			int d=s.charAt(0)-a.get(i).charAt(0);
			//System.out.println(d);
			if(d<0){
				d+=26;
			}
			for(int j=1;j<m;){
				int x=s.charAt(j)-a.get(i).charAt(j);
				if(x<0){
					x+=26;
				}
				if(d==x){
					j++;
				}
				else{
					break;
				}
				if(j==m){
					//System.out.println(d);
					ans.add(d+97);}
			}
			
			
			}
		}
		Collections.sort(ans);
		output[z]=String.valueOf(Character.toChars(ans.get(0)));
		for(int i=1;i<ans.size();i++){
			//System.out.print(Character.toChars(ans.get(i)));
			output[z]=output[z].concat(String.valueOf(Character.toChars(ans.get(i))));
			//System.out.println(String.valueOf(Character.toChars(ans.get(i))));
		}
		t--;
		z++;
			}
		//System.out.println();
		
	
	for(int i=0;i<z;i++){
		System.out.println(output[i]);
	}
	
	}

}
