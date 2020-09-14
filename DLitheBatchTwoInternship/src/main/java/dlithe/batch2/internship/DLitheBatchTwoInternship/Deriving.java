package dlithe.batch2.internship.DLitheBatchTwoInternship;

public class Deriving extends Factorial 
{
	public void findMax()// overriding
	{
		Integer fmin=price[0],smin=price[0];
		for(Integer temp1:price)
		{
			if(temp1<fmin)
			{smin=fmin;fmin=temp1;}
			else if(temp1<smin&&temp1!=fmin)
			{smin=temp1;}
		}
		System.out.println("Second min: "+smin);
	}
	public static void main(String[] args) 
	{
		Deriving f=new Deriving();
		f.price=new Integer[] {12,15,11,12,4,9,10,12,14};
		f.findMax();f.fact();
	}
}

class Sum
{
	Integer price[], sum=0;
	public void findMax()
	{
		Integer max=price[0];
		for(Integer temp:price)
		{
			sum+=temp;
			if(max<temp) 
			{
				max=temp;
			}
		}
		System.out.println("MAx value: "+max);
		System.out.println("Sum Value: "+sum);
	}
}

class Factorial extends Sum// single
{
	public void fact()
	{
		for(Integer temp:price)
		{
			// fact
			Integer factValue=1;
			for(int num=temp;num>0;num--)
			{
				factValue*=num;
				//System.out.println(factValue);
			}
			System.out.println(temp+" factorial is: "+factValue);
		}
		super.findMax();
	}
}