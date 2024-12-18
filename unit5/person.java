public class Person
{
    private String name;
    private int numberOfPets;
    
    public Person(String nameIn, int petIn)
    {
        name = nameIn;
        numberOfPets = petIn;
    }

     public String getName()
    {
        return name;
    }
    
    public int getNumberOfPets()
    {
        return numberOfPets;
    }
    
    public void greeting()
    {
        System.out.println("Hello, my name is " + name);
        System.out.println("and I have this many pets: " + numberOfPets);
    }
    
    
}




