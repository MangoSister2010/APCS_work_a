import processing.core.*;

public class Ball 
{

    float x, y, radius;
    PApplet p;  // Reference to the PApplet object to interact with Processing

    public Ball(PApplet pIn, float xIn, float yIn, float radiusIn) {
        p = pIn;
        x = xIn;
        y = yIn;
        radius = radiusIn;
    }

    public void display() 
    {
        p.background(255);
        p.fill(255, 0, 0);  // Red color for the ball
        p.ellipse(x, y, radius * 2, radius * 2);  // Draw the ball
    }

    public void move() {
        x += 2;  // Move the ball horizontally
        if (x > p.width) {
            x = 0;  // Reset the ball position to the left if it goes off screen
        }
    }
}
