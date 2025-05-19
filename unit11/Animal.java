import java.util.*; 

class Animal
{
    private String name; 
    private int legCount; 
    private boolean furry; 
    
    public Animal(String name, int legCount, boolean furry)
    {
        this.name = name
        this.legCount = legCount; 
        this.furry = furry; 
    }
    
    public String getName() {return name;}
    public int getLegCount() {return legCount;}
    public boolean isFurry() {return furry;}
}

class Human extends Animal 
{
    public Human(){super("human,", 2, false);}
}

class Cat extends Animal
{
public 
}
