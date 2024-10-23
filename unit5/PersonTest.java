public class PersonTest 
{
    public static void main(String[] args)
    {
        System.out.println("Hello, Person!");


        person claire = new person("Claire");

        // error: private access
        //drkessner.name = "Dr. Kessner";
       
        //drkessner.setName("Dr. Kessner");        
        claire.greeting();

        System.out.println("This person's name is " + claire.getName());


        person eva = new person("Eva");
        eva.greeting();
    }
}