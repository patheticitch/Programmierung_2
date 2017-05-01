package pr2.a03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Rekursion {

	public static void main(String[] args) {
		Rekursion testclass = new Rekursion();
		File testfile = new File("./lib/test.txt");
		testclass.test(testfile);

	}

	public static int[] createArray(Scanner in) {
		int count = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (in.hasNext()) {
			try {
				list.add(in.nextInt());
			} catch (InputMismatchException e) {
				in.next();
			}
		}
		int[] array = new int[list.size()];
		for (Integer i : list) {
			array[count] = i.intValue();
			count++;
		}
		in.close();
		return array;
	}

	public static int[] createArray(String file) {
		try {
			FileReader fr = new FileReader(file);
			Scanner in = new Scanner(fr);
			return createArray(in);

		} catch (FileNotFoundException fnf) {
			System.out.println("file not found");
			return new int[0];

		}

	}

	public static int[] createArrayDirectFrom(String stringWithNumbers) {
		Scanner in = new Scanner(stringWithNumbers);
		return createArray(in);
	}

	public static void print(int[] array) {
		PrintWriter out = new PrintWriter(System.out, true);
		String numbers = "";
		for (int i : array) {
			numbers += String.format("%d ", i);
		}
		out.printf("the number in the array are: %s", numbers);

	}

	public static int indexOfStandard(int number, int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == number) {
				return i;
			}
		}
		return -1;
	}

	public static int indexOfRecursiv(int number, int[] array) {
		return indexOfRecursiv(number, array, 0, array.length-1);
	}

	public static int indexOfRecursiv(int number, int[] array, int startIndex, int endIndex) {
		int m= (startIndex+endIndex)/2;
		if(endIndex<startIndex) {
			return -1;
		}
		
		if(number==array[m]) {
	        return m;
		}
		else if(number<array[m]){
			return indexOfRecursiv(number,array,startIndex,m-1);
		}
		else {
			return indexOfRecursiv(number,array,m+1,endIndex); 
		}


		// devide array in two halves
		// if number is greater look in second half
		// if number is smaller look in first halt
		// terminate if m is < 0
	}

	public  void test() {
		PrintWriter out = new PrintWriter(System.out, true);
		int[] array = createArrayDirectFrom("1 2 3 4 5 6 7 8 9 10 11");
		for (int i: array) {
			out.printf("number %d at index: %d \n ", i,indexOfRecursiv(i,array));
		}
		out.close();
	}

	public void test(File dir) {
		PrintWriter out = new PrintWriter(System.out, true);
		int[] array = createArray(dir.getPath());
		for (int i: array) {
			out.printf("number %d at index: %d \n", i,indexOfRecursiv(i,array));
		}
		out.close();
	}
}
