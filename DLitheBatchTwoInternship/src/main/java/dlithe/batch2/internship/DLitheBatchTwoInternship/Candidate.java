package dlithe.batch2.internship.DLitheBatchTwoInternship;

import java.util.Arrays;
import java.util.Scanner;

public class Candidate 
{
	private Scanner scan=new Scanner(System.in);
	private Double yet[],sum;
	public Double[] getYet() {
		return yet;
	}
	public void setYet(Double[] yet) {
		this.yet = yet;
	}
	public Double getSum() {
		return sum;
	}
	public void setSum(Double sum) {
		this.sum = sum;
	}
	public Candidate() 
	{
		System.out.println("Default constructor");
		System.out.println("Please set the size of array");
		int size=scan.nextInt();
		this.yet=new Double[size];
		this.sum=0.0;
		System.out.println("Initialization done");
	}
	public Candidate(Double[] temp)
	{
		System.out.println("Parameter constructor with double array received");
		this.yet=temp;this.sum=0.0;
		System.out.println("Copied double array");
	}
	public Candidate(Integer[] temp)
	{
		System.out.println("Parameter constructor with integer array received");
		this.yet=new Double[temp.length];this.sum=0.0;
		for(int index=0;index<yet.length;index++)
		{
			yet[index]=(double)(temp[index]);
			// destVat=(destType)srcVar
		}
	}
	public void findingSum()
	{
		for(Double temp:this.yet)
		{
			this.sum+=temp;
		}
	}
	@Override
	public String toString() {
		return "Candidate [yet=" + Arrays.toString(yet) + ", sum=" + sum + "]";
	}
	public static void main(String[] args) 
	{
		Candidate can1=new Candidate();
		Double[] local= {12.7,56.76,3.6,12.5,8.9};
		can1.setYet(local);can1.findingSum();
		System.out.println(can1);
		
		Candidate can2=new Candidate(new Double[] {1.2,6.7,8.9,2.3,4.5,6.7});
		can2.findingSum();System.out.println(can2);
		
		Candidate can3=new Candidate(new Integer[] {45,78,97,12,46,67});
		can3.findingSum();System.out.println(can3);
	}
}