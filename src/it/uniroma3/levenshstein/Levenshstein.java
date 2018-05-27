package it.uniroma3.levenshstein;
/*algoritmo di Levenshtein*/
public class Levenshstein {

	public static void stamp(int[][] m,String s1,String s2){
		int i,j;
		for (i=0;i<s1.length();i++) {
        	System.out.println("");
        	for (j=0;j<s2.length();j++) {
        		if(m[i][j]<10){
        			System.out.print("  "+m[i][j]+" ");
        		}
        		else{
        			System.out.print(" "+m[i][j]+" ");
        		}
        	}
        }
        System.out.println("");
	}

	public static int min(int delete,int insert, int replaCopy){
		return Math.min(Math.min(delete,insert),replaCopy);
	}

    public static void main(String[] args) {
        String s1=" aratro";
        String s2=" carro";
        int [][] m = new int[20][20]; 
        int i,j;
        for (i=0;i<s1.length()+1;i++) {
        	m[i][0]=i;
        }
        for (j=0;j<s2.length()+1;j++) {
        	m[0][j]=j+2;
        }
        for (i=1;i<s1.length();i++) {
        	for (j=1;j<s2.length();j++) {
        		if( s1.charAt(i)==s2.charAt(j) ){
        			m[i][j]=min(m[i-1][j]+2,m[i][j-1]+1,m[i-1][j-1]);
        		}
        		else{
        			m[i][j]=min(m[i-1][j]+2,m[i][j-1]+1,m[i-1][j-1]+1);
        		}
        	}
    	}
    	stamp(m,s1,s2);

	}
}