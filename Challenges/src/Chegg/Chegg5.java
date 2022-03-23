package Chegg;

public class Chegg5 {

	public static void main(String[] args) {
		Date d = new Date(1, 1, 2000);
		System.out.println(d.daysSinceJan1());		// Output 61
	}
}

class Date {
	
	private int day;
	private int month;
	private int year;
	
	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public int daysSinceJan1() {
		
		int jan = 31;
		int feb = year % 4 == 0 ? 29 : 28;	// Calculating days of febuary.
		int march = 31;
		int april = 30;
		int may = 31;
		int june = 30;
		int july = 31;
		int aug = 31;
		int sept = 30;
		int oct = 31;
		int nov = 30;
		
		int totalDays = 0;
		
		switch(month) {
		
			case 1:
				totalDays = day;
			break;
			case 2:
				totalDays = day + jan;
			break;
			case 3:
				totalDays = day + jan + feb;
			break;
			case 4:
				totalDays = day + jan + feb + march;
			break;
			case 5:
				totalDays = day + jan + feb + march + april;
			break;
			case 6:
				totalDays = day + jan + feb + march + april + may;
			break;
			case 7: 
				totalDays = day + jan + feb + march + april + may + june;
			break;
			case 8:
				totalDays = day + jan + feb + march + april + may + june + july;
			break;
			case 9:
				totalDays = day + jan + feb + march + april + may + june + july + aug;
			break;
			case 10:
				totalDays = day + jan + feb + march + april + may + june + july + aug + sept;
			break;
			case 11:
				totalDays = day + jan + feb + march + april + may + june + july + aug + sept + oct;
			break;
			case 12:
				totalDays = day + jan + feb + march + april + may + june + july + aug + sept + oct + nov;
			break;
		
		}
		
		return totalDays;
	}
	
}

