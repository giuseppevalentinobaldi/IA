package it.uniroma3.lcs;

public class LCS{

	public static void stamp(int[][] c, char[][] b,String s1,String s2){
		int i,j;
		for (i=0;i<s1.length();i++) {
        	System.out.println("");
        	for (j=0;j<s2.length();j++) {
        		if(c[i][j]<10){
        			System.out.print("  "+c[i][j]+b[i][j]+" ");
        		}
        		else{
        			System.out.print(" "+c[i][j]+b[i][j]+" ");
        		}
        	}
        }
        System.out.println("");
	}

	public static void main(String[] args) {
		String x="prova";
		String y="prova";
		int i,j;
		int [][] c= new int[20][20];
		char [][] b= new char[20][20];
		for (i=0; i<x.length(); i++) {
			c[i][0]=i;
		}
		for (j=0; j<y.length(); j++) {
			c[0][j]=j;
		}
		for (i=1; i<x.length(); i++) {
			for (j=1; j<y.length(); j++) {
				if( x.charAt(i)==y.charAt(j) ){
					c[i][j]= c[i-1][j-1] + 1;
					b[i][j]= '-';
				}
				else 
					if( c[i-1][j] >= c[i][j-1] ){
					c[i][j]=c[i-1][j];
					b[i][j]='↑';
					}
				else{	
					c[i][j]=c[i][j-1];
					b[i][j]='←';
				}
			}
		}
		stamp(c,b,x,y);
	}
}