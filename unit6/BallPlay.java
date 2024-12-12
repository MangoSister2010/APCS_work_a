import processing.core.*;

public class BallPlay extends PApplet 
{

    Ball ball;

    public void settings() {
        size(600, 400);  // Set the size of the window
    }

    public void setup() {
        ball = new Ball(this, width/2, height/2, 50);  // Create the ball
        background(255);  // Set background to white
    }

    public void draw() {
        ball.display();  // Display the ball
        ball.move();     // Move the ball
    }

    public static void main(String[] args) {
        PApplet.main("BallPlay");  // Start the sketch
    }
}