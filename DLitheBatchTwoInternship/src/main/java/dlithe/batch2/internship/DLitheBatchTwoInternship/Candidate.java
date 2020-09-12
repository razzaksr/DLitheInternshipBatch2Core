package dlithe.batch2.internship.DLitheBatchTwoInternship;

import java.util.Scanner;

public class Candidate 
{
	private Scanner scan=new Scanner(System.in);
	private Double[] yet;Integer sum;
	public Double[] getYet() {
		return yet;
	}
	public void setYet(Double[] yet) {
		this.yet = yet;
	}
	public Integer getSum() {
		return sum;
	}
	public void setSum(Integer sum) {
		this.sum = sum;
	}
	public Candidate() 
	{
		System.out.println("Default constructor");
		System.out.println("Please set the size of array");
		int size=scan.nextInt();
		this.yet=new Double[size];
		this.sum=0;
		System.out.println("Initialization done");
	}
}