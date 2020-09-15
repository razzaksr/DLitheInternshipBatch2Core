package dlithe.batch2.internship.DLitheBatchTwoInternship;

public interface DealerOperations 
{
	public void addToStock(Bike object);
	public void listAll();
	public void update(Integer cc,Integer newone);
	public Bike[] shortlist(Short cc);
	public Bike[] shortlist(Integer year);
	public Bike[] shortlist(Double price);
	public void sort();
	public Bike remove(Integer index);
}
