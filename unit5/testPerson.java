public class PersonTest 
{
    public static void main(String[] args)
    {
        System.out.println("Hello, Person!");


        Person claire = new Person("Claire");

        // error: private access
        //drkessner.name = "Dr. Kessner";
       
        //drkessner.setName("Dr. Kessner");        
        claire.greeting();

        System.out.println("Her name is " + claire.getName());


        Person eva = new Person("Eva");
        eva.greeting();
    }
}