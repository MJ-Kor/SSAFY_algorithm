package training.boj.day_01_30;

import java.math.BigInteger;
import java.util.Scanner;

public class Main_1914_김민주 {
	
	static StringBuffer bf = new StringBuffer();

	public static void hanoi( int m, int from, int by, int to ) {
		if( m == 1 ) {
			bf.append( from + " " + to + "\n" );
			return;
		}
		else {
			hanoi( m-1, from, to, by );
			bf.append( from + " " + to + "\n" );
			hanoi( m-1, by, from, to );
		}
	}

	public static void main(String[] args) { 
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
        sc.close();	
        
        BigInteger k = new BigInteger( "2" ).pow( n ).subtract( BigInteger.ONE );
        bf.append( k + "\n" );
        
		if( n <= 20 )
			hanoi( n, 1, 2, 3 );
		
		System.out.println( bf.toString() );
        
	}
}