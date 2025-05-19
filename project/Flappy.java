import processing.core.*;
import java.util.ArrayList;

public class Flappy extends PApplet 
{   
   // Game constants
    int bird_size;
    int pipe_width;
    int pipe_gap;
    
    // Game states
    final int state_start = 0;
    final int state_difficulty = 1;
    final int state_countdown = 2;
    final int state_playing = 3;
    final int state_game_over = 4;
    
    // Difficulty levels
    final int DIFFICULTY_EASY = 0;
    final int DIFFICULTY_MEDIUM = 1;
    final int DIFFICULTY_HARD = 2;
    int currentDifficulty = DIFFICULTY_MEDIUM;
    
    // spped --> only affects pipe movement
    float pipeSpeed = 3.0f;
    
    // Game variables
    Bird bird;
    ArrayList<Pipe> pipes;
    ArrayList<Cloud> clouds;  
    int score;
    boolean gameRunning;
    boolean gameOver;
    
    //pig theme
    final int ORANGE = 0xFFFFA500;
    final int YELLOW = 0xFFFFFF00;
    final int DARK_YELLOW = 0xFFFFC800;
    final int GREEN = 0xFF00B400;
    final int SKY_BLUE = 0xFFFFE6F2;  
    final int RED_ORANGE = 0xFFFF4500;
    final int LIGHT_BLUE = 0xFFFFCCE6;  
    final int DARK_GREEN = 0xFF006400;
    final int WHITE = 0xFFFFFFFF;
    final int BLACK = 0xFF000000;
    final int BEAK_ORANGE = 0xFFFF8C00; 
    
    // Pig colors
    final int PIG_PINK = 0xFFFFAEC9;
    final int PIG_DARK_PINK = 0xFFFF8AB8;
    final int PIG_NOSE = 0xFFE56EA9;
    
    final int PIPE_PINK = 0xFFFFD1DC;  // Baby pink for pipes
    final int PIPE_DARK_PINK = 0xFFFFB6C1;  // Darker accent for pipe caps
    
    // Start screen and countdown
    int gameState = state_start;
    int countdownValue = 3;
    int lastCountdownTime = 0;
    
    // Difficulty selection
    int selectedOption = 1; // Default to medium
    
    // Pixel data --> title
    int[][] pixelF = {
        {1,1,1,1,1}, {1,0,0,0,0}, {1,1,1,1,0}, {1,0,0,0,0}, {1,0,0,0,0}
    };
    int[][] pixelL = {
        {1,0,0,0,0}, {1,0,0,0,0}, {1,0,0,0,0}, {1,0,0,0,0}, {1,1,1,1,1}
    };
    int[][] pixelA = {
        {0,1,1,1,0}, {1,0,0,0,1}, {1,1,1,1,1}, {1,0,0,0,1}, {1,0,0,0,1}
    };
    int[][] pixelP = {
        {1,1,1,1,0}, {1,0,0,0,1}, {1,1,1,1,0}, {1,0,0,0,0}, {1,0,0,0,0}
    };
    int[][] pixelY = {
        {1,0,0,0,1}, {0,1,0,1,0}, {0,0,1,0,0}, {0,0,1,0,0}, {0,0,1,0,0}
    };
    int[][] pixelB = {
        {1,1,1,1,0}, {1,0,0,0,1}, {1,1,1,1,0}, {1,0,0,0,1}, {1,1,1,1,0}
    };
    int[][] pixelI = {
        {1,1,1,1,1}, {0,0,1,0,0}, {0,0,1,0,0}, {0,0,1,0,0}, {1,1,1,1,1}
    };
    int[][] pixelR = {
        {1,1,1,1,0}, {1,0,0,0,1}, {1,1,1,1,0}, {1,0,0,1,0}, {1,0,0,0,1}
    };
    int[][] pixelD = {
        {1,1,1,1,0}, {1,0,0,0,1}, {1,0,0,0,1}, {1,0,0,0,1}, {1,1,1,1,0}
    };
    
    // Add pixel G character for "Pig"
    int[][] pixelG = {
        {0,1,1,1,1}, {1,0,0,0,0}, {1,0,1,1,1}, {1,0,0,0,1}, {0,1,1,1,0}
    };
    
    public void settings() 
    {
        fullScreen();  // Set the game to run in full screen
    }
    
    public void setup() 
    {        
        // Scale game elements based on screen size
        bird_size = height / 20;
        pipe_width = width / 10;
        pipe_gap = height / 3;
        
        // Create font
        PFont font = createFont("Arial", 32);
        textFont(font);
        
        initializeGame();
        gameState = state_start;
        frameRate(60);
    }
    
    void initializeGame() 
    {
        bird = new Bird();
        pipes = new ArrayList<Pipe>();
        
        // Initialize clouds
        initializeClouds();
        
        int pipeSpacing = width / 3;
        for (int i = 0; i < 3; i++) 
        {
            pipes.add(new Pipe(width + i * pipeSpacing));
        }
        
        score = 0;
        gameRunning = false;
        gameOver = false;
        countdownValue = 3;
        lastCountdownTime = 0;
        
        // Set game speed based on difficulty
        setDifficultySpeed(currentDifficulty);
    }
    
    void initializeClouds() {
        clouds = new ArrayList<Cloud>();
        
        // Create multiple clouds with different sizes and speeds
        int numClouds = 8;  // More clouds for a fuller sky
        for (int i = 0; i < numClouds; i++) {
            float cloudX = random(0, width);
            float cloudY = random(0, height * 0.6f);  // Keep clouds in upper part of screen
            float cloudSize = random(width/15, width/8);  // Varied cloud sizes
            float cloudSpeed = random(0.2f, 1.0f);  // Different cloud speeds
            
            clouds.add(new Cloud(cloudX, cloudY, cloudSize, cloudSpeed));
        }
    }
    
    void setDifficultySpeed(int difficulty) {
        currentDifficulty = difficulty;
        switch(difficulty) {
            case DIFFICULTY_EASY:
                pipeSpeed = 2.0f;  // Slower pipes
                break;
            case DIFFICULTY_MEDIUM:
                pipeSpeed = 4.0f;  // Increased from 3.0f to make more distinction
                break;
            case DIFFICULTY_HARD:
                pipeSpeed = 6.5f;  // Increased from 5.0f for more challenge
                break;
        }
    }
    
    // Draw a pixel character
    void drawPixelChar(int[][] pixelData, int x, int y, int pixelSize, int pixelColor) 
    {
        fill(pixelColor);
        noStroke();
        for (int row = 0; row < pixelData.length; row++) 
        {
            for (int col = 0; col < pixelData[0].length; col++) 
            {
                if (pixelData[row][col] == 1) 
                {
                    rect(x + col * pixelSize, y + row * pixelSize, pixelSize, pixelSize);
                }
            }
        }
    }
    
    void drawTitle(int x, int y, int pixelSize, int pixelColor) 
    {
        // Title "Flappy Pig"
        drawPixelChar(pixelF, x, y, pixelSize, pixelColor);
        drawPixelChar(pixelL, x + pixelSize * 6, y, pixelSize, pixelColor);
        drawPixelChar(pixelA, x + pixelSize * 12, y, pixelSize, pixelColor);
        drawPixelChar(pixelP, x + pixelSize * 18, y, pixelSize, pixelColor);
        drawPixelChar(pixelP, x + pixelSize * 24, y, pixelSize, pixelColor);
        drawPixelChar(pixelY, x + pixelSize * 30, y, pixelSize, pixelColor);
        
        drawPixelChar(pixelP, x + pixelSize * 40, y, pixelSize, pixelColor);
        drawPixelChar(pixelI, x + pixelSize * 46, y, pixelSize, pixelColor);
        drawPixelChar(pixelG, x + pixelSize * 52, y, pixelSize, pixelColor);
    }
    
    public void draw() 
    {
        background(SKY_BLUE);  // Changed to light pink sky
        
        // Draw clouds in all game states
        updateAndDrawClouds();
        
        switch (gameState) 
        {
            case state_start:
                drawStartScreen();
                break;
                
            case state_difficulty:
                drawDifficultyScreen();
                break;
                
            case state_countdown:
                drawCountdown();
                break;
                
            case state_playing:
                if (gameRunning) 
                {
                    updateGame();
                }
                drawGameElements();
                break;
                
            case state_game_over:
                drawGameElements();
                drawGameOverScreen();
                break;
        }
    }
    
    void updateAndDrawClouds() {
        // Update and draw all clouds
        for (Cloud cloud : clouds) {
            cloud.update();
            cloud.display();
        }
    }
    
    void drawStartScreen() 
    {
        // Title
        int pixelSize = width / 80;
        drawTitle(width/2 - 32*pixelSize, height/4, pixelSize, PIG_DARK_PINK);  // Changed color to match pig theme
        
        // Pig character (replacing bird)
        fill(PIG_PINK);
        ellipse(width/2, height/2, bird_size, bird_size);
        
        // Draw Minecraft-style pig face on start screen
        drawPigFace(width/2, height/2, bird_size);
        
        // Instructions
        fill(0);
        textAlign(CENTER, CENTER);
        
        textSize(36);
        text("Press SPACE to Start", width/2, height * 3/4);
        
        textSize(24);
        text("Use SPACE to make the pig fly", width/2, height * 3/4 + 50);
        
        // ESC instruction
        textSize(18);
        text("Press ESC to exit", width/2, height * 3/4 + 85);
    }
    
    void drawDifficultyScreen() {
        // Title
        fill(PIG_DARK_PINK);  // Changed to pink theme
        textSize(48);
        textAlign(CENTER, CENTER);
        text("SELECT DIFFICULTY", width/2, height/5);
        
        // Pig character
        fill(PIG_PINK);
        ellipse(width/2, height/3, bird_size, bird_size);
        
        // Draw Minecraft-style pig face
        drawPigFace(width/2, height/3, bird_size);
        
        // Difficulty options
        int optionWidth = width/3;
        int optionHeight = height/10;
        int startY = height/2 - optionHeight;  // Move options up to avoid overlap
        int spacing = optionHeight + 20;
        
        // Easy option - SLOW pipe speed
        if (selectedOption == 0) fill(LIGHT_BLUE); else fill(200);  // LIGHT_BLUE is now pink
        rect(width/2 - optionWidth/2, startY, optionWidth, optionHeight, 10);
        fill(0);
        textSize(32);
        text("EASY", width/2, startY + optionHeight/2);
        textSize(18);
        text("Pipe Speed: Slow", width/2, startY + optionHeight/2 + 25);
        
        // Medium option - NORMAL pipe speed
        if (selectedOption == 1) fill(LIGHT_BLUE); else fill(200);
        rect(width/2 - optionWidth/2, startY + spacing, optionWidth, optionHeight, 10);
        fill(0);
        textSize(32);
        text("MEDIUM", width/2, startY + spacing + optionHeight/2);
        textSize(18);
        text("Pipe Speed: Medium", width/2, startY + spacing + optionHeight/2 + 25);
        
        // Hard option - FAST pipe speed
        if (selectedOption == 2) fill(LIGHT_BLUE); else fill(200);
        rect(width/2 - optionWidth/2, startY + spacing*2, optionWidth, optionHeight, 10);
        fill(0);
        textSize(32);
        text("HARD", width/2, startY + spacing*2 + optionHeight/2);
        textSize(18);
        text("Pipe Speed: Fast", width/2, startY + spacing*2 + optionHeight/2 + 25);
        
        // Instructions
        textSize(24);
        fill(0);
        text("Use UP/DOWN arrows to select, SPACE to confirm", width/2, height * 4/5);
    }
    
    // Countdown screen
    void drawCountdown() 
    {
        int currentTime = millis();
        if (currentTime - lastCountdownTime >= 1000) 
        {
            countdownValue--;
            lastCountdownTime = currentTime;
            
            // If countdown is over, start the game
            if (countdownValue < 0) 
            {
                gameState = state_playing;
                gameRunning = true;
                return;
            }
        }
        
        fill(PIG_PINK);
        ellipse(width/2, height/2, bird_size, bird_size);
        
        // Draw Minecraft-style pig face in countdown screen
        drawPigFace(width/2, height/2, bird_size);
        
        fill(PIG_DARK_PINK);  // Changed to pig theme color
        textSize(100);
        textAlign(CENTER, CENTER);
        
        // Pulsing effect
        float scale = 1.0f + sin(millis() * 0.01f) * 0.1f;
        pushMatrix();
        translate(width/2, height/2);
        scale(scale);
        text(countdownValue > 0 ? str(countdownValue) : "GO!", 0, 0);
        popMatrix();
        
        // Show difficulty
        String diffText = "";
        float speedText = 0;
        switch(currentDifficulty) {
            case DIFFICULTY_EASY: 
                diffText = "EASY"; 
                speedText = 2.0f;
                break;
            case DIFFICULTY_MEDIUM: 
                diffText = "MEDIUM"; 
                speedText = 4.0f;
                break;
            case DIFFICULTY_HARD: 
                diffText = "HARD"; 
                speedText = 6.5f;
                break;
        }
        
        fill(PIG_NOSE);  // Changed color to match theme
        textSize(32);
        text("Difficulty: " + diffText, width/2, height * 3/4);
        textSize(24);
        text("Pipe Speed: " + speedText, width/2, height * 3/4 + 40);
    }
    
    void drawGameElements() 
    {
        // Draw pipes with baby pink color
        for (Pipe pipe : pipes) 
        {
            // Main pipe body
            fill(PIPE_PINK);
            rect(pipe.x, 0, pipe_width, pipe.topHeight);
            rect(pipe.x, pipe.topHeight + pipe_gap, pipe_width, height - pipe.topHeight - pipe_gap);
            
            // Pipe caps (slightly darker pink)
            fill(PIPE_DARK_PINK);
            int capHeight = pipe_width / 3;
            
            // Top pipe cap
            rect(pipe.x - capHeight/4, pipe.topHeight - capHeight, pipe_width + capHeight/2, capHeight);
            
            // Bottom pipe cap
            rect(pipe.x - capHeight/4, pipe.topHeight + pipe_gap, pipe_width + capHeight/2, capHeight);
        }
        
        // Draw the pig body (replacing bird)
        fill(PIG_PINK);
        ellipse(bird.x + bird_size/2, bird.y + bird_size/2, bird_size, bird_size);
        
        // Draw Minecraft-style pig face
        drawPigFace(bird.x + bird_size/2, bird.y + bird_size/2, bird_size);
        
        // Wing animation (tiny pig ears flapping instead of wings)
        fill(PIG_DARK_PINK);
        float earOffset = sin(millis() * 0.02f) * bird_size/6;
        
        // Left ear
        triangle(
            bird.x, bird.y + bird_size/3,
            bird.x - bird_size/3, bird.y - bird_size/4 + earOffset,
            bird.x + bird_size/6, bird.y
        );
        
        // Right ear
        triangle(
            bird.x + bird_size/2, bird.y,
            bird.x + bird_size/2 + bird_size/6, bird.y - bird_size/4 + earOffset,
            bird.x + bird_size/2 + bird_size/3, bird.y
        );
        
        // Score
        fill(0);
        textSize(32);
        textAlign(LEFT, TOP);
        text("Score: " + score, 20, 20);
        
        // Show difficulty
        String diffText = "";
        switch(currentDifficulty) {
            case DIFFICULTY_EASY: diffText = "EASY"; break;
            case DIFFICULTY_MEDIUM: diffText = "MEDIUM"; break;
            case DIFFICULTY_HARD: diffText = "HARD"; break;
        }
        textAlign(RIGHT, TOP);
        text("Difficulty: " + diffText, width - 20, 20);
        textSize(20);
        text("Speed: " + pipeSpeed, width - 20, 55);
    }
    
    void drawGameOverScreen() 
    {
        fill(0, 0, 0, 150); 
        rect(0, 0, width, height);
        
        fill(PIG_DARK_PINK);  // Changed to pig theme color
        textSize(72);
        textAlign(CENTER, CENTER);
        text("GAME OVER", width/2, height/3);
        
        fill(255);
        textSize(48);
        text("Score: " + score, width/2, height/2);
        
        // Display difficulty
        String diffText = "";
        switch(currentDifficulty) {
            case DIFFICULTY_EASY: diffText = "EASY"; break;
            case DIFFICULTY_MEDIUM: diffText = "MEDIUM"; break;
            case DIFFICULTY_HARD: diffText = "HARD"; break;
        }
        textSize(32);
        text("Difficulty: " + diffText, width/2, height/2 + 60);
        textSize(24);
        text("Pipe Speed: " + pipeSpeed, width/2, height/2 + 95);
        
        textSize(36);
        text("Press SPACE to play again", width/2, height * 2/3);
        
        // Add exit instruction
        textSize(24);
        text("Press ESC to exit", width/2, height * 2/3 + 50);
    }
    
    void updateGame() 
    {
        bird.update();
        
        // Bird hit check ground/ceiling
        if (bird.y <= 0 || bird.y >= height - bird_size) 
        {
            gameOver = true;
            gameState = state_game_over;
            gameRunning = false;
        }
        
        for (int i = 0; i < pipes.size(); i++) 
        {
            Pipe pipe = pipes.get(i);
            pipe.update();
            
            // Bird collision check
            if (pipe.checkCollision(bird)) 
            {
                gameOver = true;
                gameState = state_game_over;
                gameRunning = false;
            }
            
            // Pass pipe check
            if (!pipe.isPassed && pipe.x + pipe_width < bird.x) 
            {
                pipe.isPassed = true;
                score++;
            }
            
            // If the pipe has moved off screen, recycle it
            if (pipe.x < -pipe_width) 
            {
                // Find the rightmost pipe
                int rightmostX = 0;
                for (Pipe p : pipes) 
                {
                    rightmostX = max(rightmostX, p.x);
                }
                pipe.reset(rightmostX + width/3);
            }
        }
    }
    
    public void keyPressed() 
    {
        if (key == ' ') 
        {
            switch (gameState) 
            {
                case state_start:
                    gameState = state_difficulty;
                    break;
                    
                case state_difficulty:
                    setDifficultySpeed(selectedOption);
                    gameState = state_countdown;
                    lastCountdownTime = millis();
                    break;
                    
                case state_playing:
                    bird.flap();
                    break;
                    
                case state_game_over:
                    initializeGame();
                    gameState = state_start;
                    break;
            }
        }
        
        // Difficulty selection
        if (gameState == state_difficulty) {
            if (keyCode == UP) {
                selectedOption = max(0, selectedOption - 1);
            } else if (keyCode == DOWN) {
                selectedOption = min(2, selectedOption + 1);
            }
        }
        
        // Add ESC key to exit full screen
        if (key == ESC) 
        {
            key = 0; // Prevent default Processing ESC behavior
            exit();
        }
    }
    
    // Draw Minecraft-style pig face
    void drawPigFace(float x, float y, float size) {
        // Eyes (pixel squares for Minecraft style)
        float eyeSize = size / 5;
        float eyeOffset = size / 4;
        
        // White of eyes
        fill(WHITE);
        rect(x - eyeOffset - eyeSize/2, y - eyeOffset/2, eyeSize, eyeSize);
        rect(x + eyeOffset - eyeSize/2, y - eyeOffset/2, eyeSize, eyeSize);
        
        // Pupils (change position based on velocity to show expression)
        fill(BLACK);
        float pupilSize = eyeSize / 2;
        float pupilOffset = 0;
        
        // Adjust pupil position based on bird's state
        if (gameState == state_playing && gameRunning) {
            pupilOffset = constrain(bird.velocity / 10, -1, 1) * (eyeSize/4);
        }
        
        rect(x - eyeOffset - eyeSize/2 + eyeSize/4, y - eyeOffset/2 + eyeSize/4 + pupilOffset, pupilSize, pupilSize);
        rect(x + eyeOffset - eyeSize/2 + eyeSize/4, y - eyeOffset/2 + eyeSize/4 + pupilOffset, pupilSize, pupilSize);
        
        // Pig snout (Minecraft style - square nose)
        fill(PIG_NOSE);
        float snoutSize = size / 2.5f;
        rect(x - snoutSize/2, y, snoutSize, snoutSize/2);
        
        // Pig nostrils (two small rectangles)
        fill(PIG_DARK_PINK);
        float nostrilSize = snoutSize / 5;
        float nostrilOffset = snoutSize / 4;
        
        rect(x - nostrilOffset, y + snoutSize/5, nostrilSize, nostrilSize);
        rect(x + nostrilOffset - nostrilSize, y + snoutSize/5, nostrilSize, nostrilSize);
        
        // Expression (mouth) - happy or worried
        boolean happy = true;
        if (gameState == state_playing && gameRunning) {
            happy = bird.isHappy;
        }
        
        stroke(BLACK);
        strokeWeight(size/30);
        if (happy) {
            // Happy smile below the snout
            noFill();
            arc(x, y + snoutSize/2 + size/10, size/4, size/6, 0, PI);
        } else {
            // Worried mouth below the snout
            line(x - size/6, y + snoutSize/2 + size/10, x + size/6, y + snoutSize/2 + size/10);
        }
        noStroke();
    }
    
    class Bird 
    {
        int x, y;
        float velocity;
        float gravity;
        boolean isHappy;  // Bird's expression state
        
        Bird()
        {
            x = width / 4;
            y = height / 2 - bird_size / 2;
            velocity = 0;
            gravity = 0.4f;  // Fixed gravity regardless of difficulty
            isHappy = true;  // Bird starts happy
        }
        
        void update() 
        {
            velocity += gravity;
            y += velocity;
            
            // Pig looks worried if falling too fast
            isHappy = (velocity < 6);
        }
        
        void flap() 
        {
            velocity = -8;
            isHappy = true;  // Pig is happy when flapping
        }
    }
    
    class Pipe 
    {
        int x;
        int topHeight;
        boolean isPassed;
        
        Pipe(int x) 
        {
            this.x = x;
            reset(x);
        }
        
        void update() 
        {
            x -= pipeSpeed;  // Use pipeSpeed instead of gameSpeed
        }
        
        void reset(int x) 
        {
            this.x = x;
            topHeight = (int)random(50, height - pipe_gap - 100);
            isPassed = false;
        }
        
        // Collision check
        boolean checkCollision(Bird bird) 
        {
            if (bird.x + bird_size > x && bird.x < x + pipe_width && 
                bird.y < topHeight) 
            {
                return true;
            }
            
            if (bird.x + bird_size > x && bird.x < x + pipe_width && 
                bird.y + bird_size > topHeight + pipe_gap) 
            {
                return true;
            }
            
            return false;
        }
    }
    
    // Cloud class
    class Cloud {
        float x, y;
        float size;
        float speed;
        float[] blobSizes;  // For the different parts of the cloud
        float[] blobXOffsets;
        float[] blobYOffsets;
        
        Cloud(float x, float y, float size, float speed) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.speed = speed;
            
            // Create random shapes for clouds
            int numBlobs = 5;  // Number of ellipses to make up a cloud
            blobSizes = new float[numBlobs];
            blobXOffsets = new float[numBlobs];
            blobYOffsets = new float[numBlobs];
            
            for (int i = 0; i < numBlobs; i++) {
                blobSizes[i] = random(0.5f, 1.0f) * size;
                blobXOffsets[i] = random(-0.5f, 0.5f) * size;
                blobYOffsets[i] = random(-0.3f, 0.3f) * size/2;
            }
        }
        
        void update() {
            // Move cloud horizontally
            x -= speed;
            
            // If cloud moves off screen, wrap around
            if (x + size < 0) {
                x = width + size/2;
                y = random(0, height * 0.6f);
            }
        }
        
        void display() {
            fill(WHITE, 200);  // Semi-transparent white
            noStroke();
            
            // Draw multiple blobs to form cloud
            for (int i = 0; i < blobSizes.length; i++) {
                ellipse(x + blobXOffsets[i], y + blobYOffsets[i], 
                       blobSizes[i], blobSizes[i] * 0.6f);
            }
        }
    }
    
    public static void main(String[] args) 
    {
        String[] processingArgs = {"Flappy"};
        Flappy flappyGame = new Flappy();
        PApplet.runSketch(processingArgs, flappyGame);
    }
}