package learn;

public class Program {

	public static void main(String[] args) {
		int number = 1;
		for (int i = 1; i <= 3; i++) {// method 1 for pattern problems
			for (int j = 1; j <= 3; j++) {
				System.out.print(number + " ");
				number++;
			}
			System.out.println();
		}

		System.out.println("***\n");

		for (int i = 1; i <= 9; i++) {// method2 for pattern problems
			System.out.print(i + " ");
			if (i % 3 == 0) {
				System.out.println();
			}
		}
		System.out.println("***\n");

		
		int i =0;
		int j =1;
		int Number=0;
		
		for (int k=1;k<=10;k++) {
			Number = i+j;
			i=j;
			j=Number;
			System.out.print(Number+" ");// Fibonacci series
			
		}
		 
	}
}
