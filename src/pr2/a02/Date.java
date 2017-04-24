package pr2.a02;
import pr2.a02.IllegalDateException;

public class Date extends Object {
	
	protected int day;
	protected int month;
	protected int year;
	

	public Date(int day, int month, int year) throws IllegalDateException {
		this.day = day;
		this.month = month;
		this.year = year;
		checkdate();
	}	

	public int getDay() {
		return day;
	}
	public int getMonth() {
		return month;
	}
	public int getYear() {
		return year;
	}

	public String toString() {
		return String.format("%02d %02d %04d",day,month,year);
	}
	
	
	public int check_days_in_month() {
		int days;
		switch(this.month) {
		case 2: days=28;
				break;
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			days=31;
			break;
		default: days=30;
		}
		return days;
	}
	
	public void checkdate() throws IllegalDateException{
		if(this.day<1 || this.day > check_days_in_month()) {
			throw new IllegalDateException(String.format("falsches Datum: %s: illegal day (> %d)", this.toString(),check_days_in_month() ));
		}
		else if (this.month<1 || this.month > 12) {
			throw new IllegalDateException(String.format("falsches Datum: %s: illegal month", this.toString()));
		}
	}
	
	
	
}
