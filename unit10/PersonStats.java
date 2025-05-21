import java.util.ArrayList;

public class PersonStats
{
    public static float averagePets(ArrayList<Person> people)
    {
        if(people.size() == 0)
        {
            return 0;
        }
        
        int sum = 0;
        for(int i = 0; i < people.size(); i++)
        {
            Person p = people.get(i);
            sum = sum + p.getNumPets();
        }
        
        return (float) sum / people.size();
    }
    
    public static String mostPets(ArrayList<Person>people)
    {
        if(people.size() == 0)
        {
            return null;
        }
        
        Person max = people.get(0);
        for(int i =1; i < people.size(); i++)
        {
            Person current = people.get(i);
            if(current.getNumPets() > max.getNumPets())
            {
                max = current;
            }
        }
        
        return max.getName();
    }
    
    public static ArrayList<Person> peopleWithAtLeast2Pets(ArrayList<Person> people)
    {
        ArrayList<Person> result = new ArrayList<Person>();
        for(int i = 0; i<people.size(); i++)
        {
            Person p = people.get(i);
            if (p.getNumPets() >= 2)
            {
                result.add(p);
            }
        }
        
        return result;
    }
    
    public static void runTests()
    {
        ArrayList<Person> people = new ArrayList<Person>();
        people.add(new Person("Alice", 1));
        people.add(new Person("Bob", 3));
        people.add(new Person("Charlie", 2));
        
        float avg = averagePets(people);
        if(Math.abs(avg - 2.0f) < 0.01f)
        {
            System.out.println("average Pets Test: Pass");
        }
        else
        {
            System.out.println("Average Pets Test: Fail");
        }
        
        ArrayList<Person> result = peopleWithAtLeast2Pets(people);
        if(result.size() == 2 && result.get(0).getName().equals("Bob") && result.get(1).getName().equals("Charlie"))
        {
            System.out.println("People With At Least 2 Pets Test: Pass");
        }
        else
        {
            System.out.println("People With At Least 2 Pets Test: Fail");
        }
    }
    
    public static void main(String[] args)
    {
        runTests();
    }
}