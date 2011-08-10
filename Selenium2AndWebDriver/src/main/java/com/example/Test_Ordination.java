package com.example;

public class Test_Ordination {

	public static void main(String args[]){
		int[] s = {23,5,12,59,78,21,100,79,66};
		for(int j=1;j<=s.length;j++){
			for(int i=0;i<s.length-1;i++){
				if(s[i]>s[i+1]){
					int temp;
					temp = s[i];
					s[i] = s[i+1];
					s[i+1] = temp;
				}
			}
		}
		for(int i=0;i<s.length;i++){
			System.out.println(s[i]);
		}
	}
}
