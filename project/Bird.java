import processing.core.PApplet;

public class Bird 
{
    float x, y, velocity; 
    int color; 
    PApplet parent;

    Bird(PApplet p, int birdColor) 
    {
        this.parent = p; 
        this.x = 64;
        this.y = p.height/2;
        this.velocity = 0;
        this.color = birdColor;
    }

    void update() 
    {
        velocity += 0.6;  // Gravity
        y += velocity;
        velocity *= 0.9;  // Air resistance
    }

    void display() 
    {
        parent.fill(color);  
        parent.noStroke();
        parent.ellipse(x, y, 32, 32);  // Draw bird
        }

    void up() 
    {
        velocity = -15;  // Lift the bird when space is pressed
    }
}
