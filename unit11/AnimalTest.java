import java.util.*; 

class Animal
{
    private String name; 
    private int legCount; 
    private boolean furry; 
    
    public Animal(String name, int legCount, boolean furry)
    {
        this.name = name;
        this.legCount = legCount; 
        this.furry = furry; 
    }
    
    public String getName()
    {
        return name;
    }
    public int getLegCount()
    {
        return legCount;
    }
    public boolean isFurry()
    {
        return furry;
    }
}

class Human extends Animal 
{
    public Human(){super("human,", 2, false);}
}

class Cat extends Animal
{
    public Cat()
    {
    super("Cat", 4, true);
    }
}

class Sponge extends Animal
{
    public Sponge()
    {
        super("Sponge", 0, false);
    }
}

class Centipede extends Animal
{
    public Centipede()
    {
        super("Centipede", 100, true);
    }
}

class AnimalCalculator
{
    public static void printAnimals(ArrayList<Animal> animals)
    {
        for(Animal a: animals)
        {
            String furStatus = a.isFurry() ? "furry" : "not furry";
            System.out.println(a.getName() + " - Legs: "+ a.getLegCount() + ", " + furStatus);
        }
    }
    
    public static double averageLegs(ArrayList<Animal> animals)
    {
        if(animals.isEmpty()) return 0;
        
        int totalLegs = 0;
        for(Animal a: animals)
        {
            totalLegs += a.getLegCount();
        }
        
        return (double) totalLegs / animals.size();
    }
    
    public static Animal fewestLegs(ArrayList<Animal> animals)
    {
        if(animals.isEmpty()) return null;
        
        Animal min = animals.get(0);
        for (Animal a: animals)
        {
            if(a.getLegCount() < min.getLegCount())
            {
                min = a;
            }
        }
        return min;
    }
    
    public static void runTests()
    {
        ArrayList<Animal> testAnimals = new ArrayList<>(Arrays.asList(new Human(), new Cat(), new Sponge(), new Centipede()));
        
        double expectedAvg = (2 + 4 + 0 + 100) / 4.0;
        double actualAvg = averageLegs(testAnimals);
        System.out.println("Average Legs Test: " + (actualAvg == expectedAvg ? "Pass" : "Fail"));
        
        Animal fewest = fewestLegs(testAnimals);
        System.out.println("Fewest Legs Test: " + (fewest.getName().equals("Sponge") ? "Pass" : "Fail"));
    }
}

public class AnimalTest
{
    public static void main(String[] args)
    {
        ArrayList<Animal> animals = new ArrayList<>(Arrays.asList(new Human(), new Cat(), new Sponge(), new Centipede()));
        
        System.out.println("Animal List:");
        AnimalCalculator.printAnimals(animals);
        
        System.out.println("\nRunning Tests:");
        AnimalCalculator.runTests();
    }
}