public class Person
{
    private String name; 
    private int numPets; 
    
    public Person(String name, int numPets)
    {
        this.name = name;
        this.numPets = numPets;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getNumPets()
    {
        return numPets;
    }
}