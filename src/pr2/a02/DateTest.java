package pr2.a02;
import pr2.a02.Date;
import pr2.a02.IllegalDateException;
import java.io.PrintWriter;

public class DateTest {
	public static void main(String[] args) throws IllegalDateException {

		int[][] testdata = {
			{1, 5, 2013},	
			{82, 38, 2013},
			{31,2,2012},
		};
		PrintWriter out = new PrintWriter(System.out, true);
		for (int i = 0; i < testdata.length; i++) {
			try {
				Date date = new Date(testdata[i][0], testdata[i][1], testdata[i][2]);
				out.printf("Datum: %s %n", date.toString());
				
			}
			catch (IllegalDateException e) {
				out.println("Error: IllegalDateEception");
				continue;
			}
			
			
		}
	}

}
