package dlithe.batch2.internship.DLitheBatchTwoInternship;

public class Copy extends Finale implements Apple// multiple
{
	public static void main(String[] args) 
	{
		Copy copy=new Copy();
		copy.list();
		Apple.teller();
		copy.update();
		copy.display();
	}

	@Override
	public void update() 
	{
		crew[0]="Tom Hiddleson";
		//skipper=crew[3];
	}
}

class Finale
{
	Double[] dub= {12.4,6.7,8.9,1.3,8.1,4.5};
	public void list() // non abstract methods
	{
		for(Double temp:dub)
		{
			System.out.println(temp);
		}
	}
}
interface Apple
{
	String[] crew= {"Chris Evans","Hemsworth","Downey","Holland","Scarlet"};
	String skipper=crew[1];
	public default void display()
	{
		for(String temp:crew)
		{
			System.out.println(temp);
		}
	}
	public static void teller()
	{
		for(String temp:crew)
		{
			if(temp.contains("H")||temp.contains("h")) {System.out.println(temp);}

		}
	}
	public void update();
}