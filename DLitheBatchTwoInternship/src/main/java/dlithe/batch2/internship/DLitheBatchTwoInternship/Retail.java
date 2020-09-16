package dlithe.batch2.internship.DLitheBatchTwoInternship;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;

public class Retail implements DealerOperations
{
	ArrayList<Bike> stock=new ArrayList<Bike>();
	File file;
	public Retail(){file=new File("D:\\jpgms\\"+LocalDate.now()+".doc");}
	//public Retail(Integer size) {stock=new Bike[size];}//5
	@Override
	public void addToStock(Bike object) {
		// TODO Auto-generated method stub
		stock.add(object);
		System.out.println(object.getModel()+" was added to stock");
		try {
			FileUtils.writeStringToFile(file,"\nThe following bike added to stock today\n"+object,true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void listAll() 
	{
		System.out.println("Listing all stocks");
		/*for(Bike temp:stock)
		{
			System.out.println(temp);
		}*/
		Iterator<Bike> point=stock.iterator();
		while(point.hasNext())
		{
			System.out.println(point.next());
		}
		//System.out.println(stock);
	}
	@Override
	public void update(Integer cc, Integer newone) 
	{
		for(int index=0;index<stock.size();index++)
		{
			if(stock.get(index)!=null&&stock.get(index).getCc().equals(cc))
			{
				System.out.println(stock.get(index).getModel()
						+" going upgrade new CC of "+newone+" from "+cc);
				stock.get(index).setCc(newone);
				try {
					FileUtils.writeStringToFile(file,"\nThe following bike cc has updated in stock today\n"+stock.get(index)+" into "+newone,true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	@Override
	public Bike[] shortlist(Short cc) {
		// TODO Auto-generated method stub
		Bike[] back=new Bike[stock.size()];
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
		Bike[] back=new Bike[stock.size()];
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
		Bike[] back=new Bike[stock.size()];
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
		for(int hold=0;hold<stock.size();hold++)
		{
			for(int rest=hold+1;rest<stock.size();rest++)
			{
				if(stock.get(hold)!=null&&stock.get(rest)!=null&&stock.get(hold).getCost()>=stock.get(rest).getCost())
				{
					// swap
					temp=stock.get(hold);// copy hold pos bike to temp
					stock.set(hold,	stock.get(rest));// rest pos bike object added in hold pos
					stock.set(rest,temp);// temp bike obj added in rest pos
				}
			}
		}
	}
	@Override
	public Bike remove(Integer index) 
	{
		Bike temp;
		if(stock.get(index)!=null)
		{
			temp= stock.get(index);
			try {
				FileUtils.writeStringToFile(file,"\nThe following bike has removed from stock today\n"+stock.get(index),true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			stock.remove((int)index);
			System.out.println(index+" in stock removed");
			return temp;
		}
		return null;
	}
	public static void main(String[] args) 
	{
		Retail deal=new Retail();
		Bike b1=new Bike("HondaR15", 2020, 30, 150, 114000.9);
		Bike b2=new Bike("ApacheRTR", 2016, 40, 200, 102000.89);
		Bike b3=new Bike("AvengerCruise", 2016, 45, 220, 109000.7);
		deal.addToStock(b1);deal.addToStock(b2);deal.addToStock(b3);
		deal.listAll();
		Bike[] got=deal.shortlist((short)200);
		System.out.println("Filtered bike by CC \n"+Arrays.toString(got));
		deal.update(200, 350);deal.listAll();
		got=deal.shortlist(2016);
		System.out.println("Filtered bike by Year \n"+Arrays.toString(got));
		got=deal.shortlist(110000.8);
		System.out.println("Filtered bike by Cost \n"+Arrays.toString(got));
		deal.sort();
		deal.listAll();
		System.out.println(deal.remove(1));
		deal.listAll();
	}
}
