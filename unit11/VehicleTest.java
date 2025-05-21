import java.util.*;

interface Vehicle
{
    String name(); 
    int wheelCount(); 
    boolean isHumanPowered(); 
}

class Car implements Vehicle
{
    public String name() {return "Car";}
    public int wheelCount() {return 4;}
    public boolean isHumanPowered() {return false;}
}

class Motorcycle implements Vehicle
{
    public String name() {return "Motorcycle";}
    public int wheelCount() {return 2;}
    public boolean isHumanPowered() {return false;}
}

class Bicycle implements Vehicle
{
   public String name() {return "Bicycle";}
   public int wheelCount() {return 2;}
   public boolean isHumanPowered() {return true;}
}

class Unicycle implements Vehicle
{
   public String name() {return "Unicycle";}
   public int wheelCount() {return 1;}
   public boolean isHumanPowered() {return true;}
}

class VehicleStats
{
    static int totalWheels(ArrayList<Vehicle> vehicles)
    {
        int total = 0; 
        for(Vehicle v: vehicles)
        {
            total += v.wheelCount();
        }
        return total;
    }
    static ArrayList<Vehicle>humanPoweredVehicles(ArrayList<Vehicle> vehicles)
    {
        ArrayList<Vehicle>humanPowered = new ArrayList<>();
        for(Vehicle v:vehicles)
        {
            if(v.isHumanPowered())
            {
                humanPowered.add(v);
            }
        }
        return humanPowered;
    }
}

//Vehicle Test Class
public class VehicleTest
{
    public static void main(String[] args)
    {
        ArrayList<Vehicle>vehicles = new ArrayList<>(Arrays.asList(new Car(), new Motorcycle(), new Bicycle(), new Unicycle()));
        
        for(Vehicle v: vehicles)
        {
            System.out.println(v.name() + " Wheels: " + v.wheelCount() + " HumanPowered: " + v.isHumanPowered());
        }
        
        int total = VehicleStats.totalWheels(vehicles);
        if(total == 9)
        {
            System.out.println("Total Wheels Test: Pass");
        }
        else
        {
            System.out.println("Total Wheels Test: Fail ( Got" + total + ")");
        }
        
        ArrayList<Vehicle> humanPowered = VehicleStats.humanPoweredVehicles(vehicles);
        if(humanPowered.size() == 2 && humanPowered.get(0).name().equals("Bicycle") && humanPowered.get(1).name().equals("Unicycle"))
        {
            System.out.println("Human Powered Vehicles Test: Pass");
        }
        else
        {
            System.out.println("Human Powered Vehicles Test: Fail");
        }
        
        System.out.print("Human Powered Vehicles: ");
        for (Vehicle v: humanPowered)
        {
            System.out.print(v.name()+ " ");
        }
        System.out.println();
    }
}