import processing.core.PApplet;

public class Pipe 
{
    PApplet p; 
    float x, w, h;
    float gap = 150;
    float speed = 3; 

    public Pipe(PApplet p, float xPos) 
    {
        this.p = p;
        this.x = xPos;
        this.w = 60;
        this.h = p.random(100, p.height - 250); 
    }

    public void update() 
    {
        x -= speed;  // Move the pipe to the left
    }

    public void display() 
    {
        p.fill(0, 255, 0);  // Green pipes
        p.noStroke();
        p.rect(x, 0, w, h);  // Top pipe
        p.rect(x, h + gap, w, p.height - (h + gap));  
    }

    public boolean offscreen() 
    {
        return x < -w;  // Check if the pipe is offscreen
    }

    public boolean hits(Bird bird) 
    {
       float buffer = 5;// to prevent overlapping or collision
        if (bird.x + buffer > x && bird.x - buffer < x + w)
        {
            if(bird.y < h || bird.y > h + gap)
            {
                return true;
            }
        }
         return false; 
    }

}
