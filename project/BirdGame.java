import processing.core.PApplet;
import processing.sound.*;
import java.util.ArrayList;

public class BirdGame extends PApplet 
{
    ArrayList<Pipe> pipes;
    int spawnRate = 40;
    int frameCount = 0;
    Bird bird;
    boolean gameOver = false;
    int countdown = 3;  // Countdown starting at 3 seconds
    int countdownTime = 3;  // Countdown time in seconds (3 seconds)
    float pipeSpeed = 3; // Speed of pipes moving to the left
    int birdColor; 
    float lastPipeX = width; 
    int countdownStartTime;
    
    SoundFile background; 
    SoundFile hit;
    SoundFile flap;

    int score = 0;

    public void settings() 
    {
        size(500, 700);  // Set the size of the window
    }

    public void setup() 
    {
        countdownStartTime = millis();
        lastPipeX = width;
        birdColor = color(255,255,0);
        
        bird = new Bird(this, birdColor); 
        
        pipes = new ArrayList<>();
        for (int i = 0; i < 5; i++) 
        {
            pipes.add(new Pipe(this, lastPipeX));
            lastPipeX += width/3; 
        }
        
        flap = new SoundFile(this, "flap.wav");
        hit = new SoundFile(this, "hit.wav");
        background = new SoundFile(this, "background.wav");
        
        background(135, 206, 235);  // Sky blue background
    }

    public void draw() 
    {
        background(135, 206, 235);  // Clear background every frame

        if (gameOver) 
        {
            fill(255, 0, 0);
            textAlign(CENTER, CENTER);
            textSize(32);
            text("Game Over, PRESS 'R' TO RESTART", width / 2, height / 2);
            return;
        }

        int elapsedTime = (millis() - countdownStartTime)/1000;
        countdown = max(3 - elapsedTime, 0);
        
        if (countdown > 0) 
        {
            // Display the countdown before the game starts
            fill(0);
            textAlign(CENTER, CENTER);
            textSize(48);
            text(countdown, width / 2, height / 2);
            return;  // Do nothing else, just wait for countdown
        }

        // Update and display the bird
        bird.update();
        bird.display();
        
        if (bird.y > height)
        {
        gameOver = true;
        }

        // Update and display pipes
        for (int i = pipes.size() - 1; i >= 0; i--) 
        {
            Pipe pipe = pipes.get(i);
            pipe.update();
            pipe.display();
            
            if (pipe.offscreen()) 
            {
                pipes.remove(i); 
            }

            if (pipe.hits(bird)) 
            {
                gameOver = true;
                hit.play();
            } 
            
            else if (pipe.passed(bird))
            {
                score++;
            }
        }
        
        if(frameCount % spawnRate == 0)
        {
            float pipeX = lastPipeX + (width/2);
            pipes.add(new Pipe(this, pipeX));
            lastPipeX = pipeX; 
        }
        
        fill(0);
        textAlign(LEFT, TOP);
        textSize(32);
        text("Score: " + score, 20, 20);
        
        frameCount++;
    }

   

    // Listen for spacebar to make the bird go up
    public void keyPressed() 
    {
        if (key == ' ')  
        {
            bird.up();
        }
        else if (key == 'r' || key == 'R')
        {
            restartGame();
        }
    }
    
    void restartGame()
    {
        gameOver = false;
        score = 0;
        countdown = 3;
        pipes.clear();
        bird = new Bird(this, birdColor);
        float lastPipeX = width;
        for (int i = 0; i< 5; i++)
        {
            pipes.add(new Pipe(this, lastPipeX));
            lastPipeX += width/3;
        }
    }
    
    public static void main(String[] args)
    {
        PApplet.main("BirdGame");
    }
}
