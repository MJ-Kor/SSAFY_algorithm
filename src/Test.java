import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		boolean [] A = {true, false};
		boolean [] B = {true, true};
		int hit = 2;
		int base = 8;
		int score = 0;
		base = base << hit;
		base = base | (1 << hit - 1);
		System.out.println(base);
		if((base & 32) == 1) score++; 
		System.out.println(base & 32);
	}

}
