public class person
{
    // constructor function

    public person(String nameIn)
    {
        name = nameIn;
    }

    public void greeting()
    {
        System.out.println("Hello, my name is " + name);
        System.out.println("and I have this many pets: " + numberOfPets);
    }

    // (public) accessor functions
    // getter (accessor) / setter (mutator)

    public void setName(String newName)
    {
        name = newName;  
    }

    public String getName()
    {
        return name;
    }

    // for us:  all member variables will be private
    private String name;

    // static == shared by all objects of the class
    // final == variable cannot be changed (after initialization)
    // e.g Math.PI and Math.E (public static final)
    private static final int numberOfPets = 1;
}