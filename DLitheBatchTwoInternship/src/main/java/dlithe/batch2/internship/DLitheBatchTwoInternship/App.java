package dlithe.batch2.internship.DLitheBatchTwoInternship;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Bike bikeOne=new Bike("AvengerCruise", 2016, 45, 220, 102000.7);
        //bikeOne.model="Avenger220";
        //bikeOne.setModel("AvengerCruise");bikeOne.setCc(220);bikeOne.setYear(2016);
        //bikeOne.setCost(102000.0);bikeOne.setMilage(45);
        System.out.println(bikeOne.getYear()+" "+bikeOne.getCost()+" "+bikeOne.getMilage());
        Bike bikeTwo=new Bike();
        bikeTwo.setModel("ApacheRTR");bikeTwo.setCc(200);bikeTwo.setCost(110000.9);bikeTwo.setYear(2016);
        bikeTwo.setMilage(40);
        System.out.println(bikeTwo);// toString has called
    }
}
