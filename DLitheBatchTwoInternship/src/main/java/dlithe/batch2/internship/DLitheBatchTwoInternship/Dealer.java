package dlithe.batch2.internship.DLitheBatchTwoInternship;

import java.util.Arrays;

public class Dealer implements DealerOperations
{
	Bike[] stock;
	public Dealer(){}
	public Dealer(Integer size) {stock=new Bike[size];}//5
	@Override
	public void addToStock(Bike object) {
		// TODO Auto-generated method stub
		for(int index=0;index<stock.length;index++)
		{
			if(stock[index]==null)
			{
				stock[index]=object;
				System.out.println(object.getModel()+" was added to stock");
				break;
			}
		}
	}
	@Override
	public void listAll() 
	{
		System.out.println("Listing all stocks");
		for(Bike temp:stock)
		{
			System.out.println(temp);
		}
	}
	@Override
	public void update(Integer cc, Integer newone) 
	{
		for(int index=0;index<stock.length;index++)
		{
			if(stock[index]!=null&&stock[index].getCc().equals(cc))
			{
				System.out.println(stock[index].getModel()
						+" going upgrade new CC of "+newone+" from "+cc);
				stock[index].setCc(newone);
			}
		}
	}
	@Override
	public Bike[] shortlist(Short cc) {
		// TODO Auto-generated method stub
		Bike[] back=new Bike[stock.length];
		int index=0;
		for(Bike temp:stock)
		{
			if(temp!=null&&(int)temp.getCc()<=cc) 
			{back[index]=temp;index++;}
		}
		return back;
	}
	@Override
	public Bike[] shortlist(Integer year) {
		// TODO Auto-generated method stub
		System.out.println("Year wise filter");
		Bike[] back=new Bike[stock.length];
		int index=0;
		for(Bike temp:stock)
		{
			if(temp!=null&&((int)temp.getYear()==year)) 
			{back[index]=temp;index++;}
		}
		return back;
	}
	@Override
	public Bike[] shortlist(Double price) {
		// TODO Auto-generated method stub
		Bike[] back=new Bike[stock.length];
		int index=0;
		for(Bike temp:stock)
		{
			if(temp!=null&&((double)temp.getCost()<=price)) 
			{back[index]=temp;index++;}
		}
		return back;
	}
	@Override
	public void sort()
	{
		System.out.println("Sorting stocks based on cost");
		Bike temp;
		for(int hold=0;hold<stock.length;hold++)
		{
			for(int rest=hold+1;rest<stock.length;rest++)
			{
				if(stock[hold]!=null&&stock[rest]!=null&&stock[hold].getCost()>=stock[rest].getCost())
				{
					temp=stock[hold];stock[hold]=stock[rest];stock[rest]=temp;
				}
			}
		}
	}
	@Override
	public Bike remove(Integer index) 
	{
		Bike temp;
		if(stock[index]!=null)
		{
			temp= stock[index];
			stock[index]=null;
			System.out.println(index+" in stock became empty");
			return temp;
		}
		return null;
	}
	public static void main(String[] args) 
	{
		Dealer deal=new Dealer(4);
		Bike b1=new Bike("HondaR15", 2020, 30, 150, 114000.9);
		Bike b2=new Bike("ApacheRTR", 2016, 40, 200, 102000.89);
		Bike b3=new Bike("AvengerCruise", 2016, 45, 220, 109000.7);
		deal.addToStock(b1);deal.addToStock(b2);deal.addToStock(b3);
		deal.listAll();
		/*Bike[] got=deal.shortlist((short)200);
		System.out.println("Filtered bike by CC \n"+Arrays.toString(got));
		deal.update(200, 350);deal.listAll();
		got=deal.shortlist(2016);
		System.out.println("Filtered bike by Year \n"+Arrays.toString(got));
		got=deal.shortlist(110000.8);
		System.out.println("Filtered bike by Cost \n"+Arrays.toString(got));*/
		deal.sort();
		deal.listAll();
		System.out.println(deal.remove(1));
		deal.listAll();
	}
}
