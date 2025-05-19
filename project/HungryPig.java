import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;
import java.util.ArrayList;

public class HungryPig extends PApplet 
{
    // Game states
    final int START = 0;
    final int PLAYING = 1;
    final int GAME_OVER = 2;
    int gameState = START;

    // Game objects
    Pig pig;
    ArrayList<Food> foods;
    int score = 0;
    int timeLeft = 60; 
    float lastSecondChange;

    // Images and title
    PImage pigImg;
    PImage appleImg;
    PImage carrotImg;
    PImage bgImage;
    PFont pixelFont;

    int titleColor;
    float titleAngle = 0;

    public static void main(String[] args) 
    {
        PApplet.main("HungryPig");
    }

    public void settings() 
    {
        fullScreen();
    }

    public void setup() 
    {
        frameRate(60);
        
        pigImg = createPigImage(50, 50);
        appleImg = createAppleImage(40, 40);
        carrotImg = createCarrotImage(40, 40);
        bgImage = createBackgroundImage(40, 40);
        
        pixelFont = createFont("SansSerif", 32); // font may not work find a new one
        textFont(pixelFont);
        
        pig = new Pig();
        foods = new ArrayList<Food>();
        
        resetGame();
        
        titleColor = color(255, 120, 180);
        
        lastSecondChange = millis() / 1000;
    }

    public void draw() 
    {
        image(bgImage, 0, 0, width, height);
        
        switch(gameState) 
        {
            case START:
                drawStartScreen();
                break;
                
            case PLAYING:
                updateGame();
                drawGame();
                break;
                
            case GAME_OVER:
                drawGame();
                drawGameOverScreen();
                break;
        }
    }

    void drawStartScreen() 
    {
        pushMatrix();
        translate(width/2, 150);
        rotate(sin(titleAngle) * 0.05f);
        titleAngle += 0.02f;
        
        textAlign(CENTER, CENTER);
        textSize(60);
        
        // Shadow effect
        fill(100, 60, 60);
        text("HUNGRY PIG", 5, 5);
        
        fill(titleColor);
        text("HUNGRY PIG", 0, 0);
        popMatrix();
        
        //pig face
        pushMatrix();
        translate(width/2, height/2);
        scale(5); // INCREASE!!! for better visibility or change it back
        image(pigImg, -pigImg.width/2, -pigImg.height/2);
        popMatrix();
        
        fill(255);
        textSize(24);
        textAlign(CENTER);
        text("Use arrow keys to move the pig", width/2, height/2 + 180);
        text("Eat as much food as you can before time runs out!", width/2, height/2 + 220);
        
        drawPixelButton("START GAME", width/2, height/2 + 280);
    }

    void drawPixelButton(String text, float x, float y) 
    {
        float w = 220;
        float h = 60;
        
        // Check if mouse is over button
        boolean hover = mouseX > x-w/2 && mouseX < x+w/2 && mouseY > y-h/2 && mouseY < y+h/2;
        
        fill(80, 80, 80);
        rect(x-w/2+4, y-h/2+4, w, h);
        
        if (hover) 
        {
            fill(120, 200, 120);
        } else 
        {
            fill(100, 180, 100);
        }
        
        rect(x-w/2, y-h/2, w, h);
        
        fill(255);
        textAlign(CENTER, CENTER);
        textSize(24);
        text(text, x, y);
    }

    void updateGame() 
    {
        float currentSecond = millis() / 1000;
        if (currentSecond - lastSecondChange >= 1) 
        {
            timeLeft--;
            lastSecondChange = currentSecond;
            
            if (timeLeft <= 0) 
            {
                gameState = GAME_OVER;
            }
        }
        
        pig.update();
        
        //new food
        
        if (random(1) < 0.02) {
            foods.add(new Food());
        }
        
        for (int i = foods.size() - 1; i >= 0; i--) 
        {
            Food food = foods.get(i);
            if (pig.eats(food)) 
            {
                foods.remove(i);
                score += food.value;
                pig.showEating();
            }
        }
    }

    void drawGame() 
    {
        // food
        for (Food food : foods) 
        {
            food.display();
        }
        
        pig.display();
        
        drawUI();
    }

    void drawUI() 
    {
        fill(255);
        textAlign(LEFT);
        textSize(32);
        text("Score: " + score, 20, 40);
        
        textAlign(RIGHT);
        text("Time: " + timeLeft, width - 20, 40);
    }

    void drawGameOverScreen() 
    {
        // Semi-transparent overlay
        fill(0, 0, 0, 180);
        rect(0, 0, width, height);
        
        textAlign(CENTER, CENTER);
        textSize(64);
        fill(255, 100, 100);
        text("GAME OVER", width/2, height/2 - 80);
        
        textSize(48);
        fill(255);
        text("Your score: " + score, width/2, height/2);
        
        drawPixelButton("PLAY AGAIN", width/2, height/2 + 100);
    }

    public void mousePressed() 
    {
        float buttonX = width/2;
        float buttonY = 0;
        float buttonW = 220;
        float buttonH = 60;
        
        if (gameState == START) 
        {
            buttonY = height/2 + 280;
            if (mouseX > buttonX-buttonW/2 && mouseX < buttonX+buttonW/2 && mouseY > buttonY-buttonH/2 && mouseY < buttonY+buttonH/2) 
            {
                startGame();
            }
        } else if (gameState == GAME_OVER) 
        {
            buttonY = height/2 + 100;
            if (mouseX > buttonX-buttonW/2 && mouseX < buttonX+buttonW/2 && mouseY > buttonY-buttonH/2 && mouseY < buttonY+buttonH/2) 
            {
                resetGame();
                gameState = START;
            }
        }
    }

    public void keyPressed() 
    {
        if (gameState == PLAYING) 
        {
            if (keyCode == UP) pig.dirY = -1;
            if (keyCode == DOWN) pig.dirY = 1;
            if (keyCode == LEFT) pig.dirX = -1;
            if (keyCode == RIGHT) pig.dirX = 1;
        }
    }

    public void keyReleased() 
    {
        if (keyCode == UP || keyCode == DOWN) pig.dirY = 0;
        if (keyCode == LEFT || keyCode == RIGHT) pig.dirX = 0;
    }

    void startGame() 
    {
        resetGame();
        gameState = PLAYING;
    }

    void resetGame() 
    {
        pig = new Pig();
        foods = new ArrayList<Food>();
        score = 0;
        timeLeft = 60;
        lastSecondChange = millis() / 1000;
        
        for (int i = 0; i < 5; i++) {
            foods.add(new Food());
        }
    }

    PImage createPigImage(int width, int height) 
    {
        PImage img = createImage(width, height, ARGB);
        img.loadPixels();
        
        int pigPink = color(255, 170, 180);
        int pigDarkPink = color(220, 140, 150);
        int pigNose = color(200, 100, 110);
        int pigEyes = color(30, 30, 30);
        
        float scaleX = width / 20.0f;
        float scaleY = height / 20.0f;
        float centerX = width / 2.0f;
        float centerY = height / 2.0f;
        
        for (int x = 0; x < width; x++) 
        {
            for (int y = 0; y < height; y++) 
            {
                float origX = x / scaleX;
                float origY = y / scaleY;
                
                img.pixels[y * width + x] = color(0, 0, 0, 0);
                
                float distFromCenter = dist(x, y, centerX, centerY);
                if (distFromCenter < (9 * scaleX)) {
                    img.pixels[y * width + x] = pigPink;
                }
                
                if ((x < (5 * scaleX) && y < (5 * scaleY)) || (x > (14 * scaleX) && y < (5 * scaleY))) 
                {
                    float earX = x < (5 * scaleX) ? (4 * scaleX) : (15 * scaleX);
                    float earY = 4 * scaleY;
                    if (dist(earX, earY, x, y) < (4 * scaleX)) 
                    {
                        img.pixels[y * width + x] = pigDarkPink;
                    }
                }
                
                // Pig eyes
                if ((dist(x, y, 6 * scaleX, 8 * scaleY) < (2 * scaleX)) || 
                    (dist(x, y, 14 * scaleX, 8 * scaleY) < (2 * scaleX))) 
                {
                    img.pixels[y * width + x] = pigEyes;
                }
                
                // Pig nose
                if (y > (10 * scaleY) && y < (15 * scaleY) && x > (7 * scaleX) && x < (13 * scaleX)) 
                {
                    if (dist(x, y, 10 * scaleX, 12 * scaleY) < (3 * scaleX)) {
                        img.pixels[y * width + x] = pigNose;
                    }
                }
                
                // Pig nostrils
                if ((dist(x, y, 8.5f * scaleX, 12 * scaleY) < (1 * scaleX)) || 
                    (dist(x, y, 11.5f * scaleX, 12 * scaleY) < (1 * scaleX))) 
                {
                    img.pixels[y * width + x] = color(150, 80, 90);
                }
            }
        }
        
        img.updatePixels();
        return img;
    }

    PImage createAppleImage(int width, int height) 
    {
        PImage img = createImage(width, height, ARGB);
        img.loadPixels();
        
        // Scale factors
        float scaleX = width / 16.0f;
        float scaleY = height / 16.0f;
        
        int apple = color(220, 30, 30);
        int stem = color(100, 70, 30);
        int leaf = color(30, 180, 30);
        
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                // Convert to original scale for calculations
                float origX = x / scaleX;
                float origY = y / scaleY;
                
                // Default transparent
                img.pixels[y * width + x] = color(0, 0, 0, 0);
                
                // Apple body
                float distFromCenter = dist(x, y, 8 * scaleX, 9 * scaleY);
                if (distFromCenter < (6 * scaleX) && y > (3 * scaleY)) {
                    img.pixels[y * width + x] = apple;
                }
                
                // Stem
                if (x >= (7 * scaleX) && x <= (9 * scaleX) && y >= (2 * scaleY) && y <= (4 * scaleY)) {
                    img.pixels[y * width + x] = stem;
                }
                
                // Leaf
                if (x >= (9 * scaleX) && x <= (12 * scaleX) && y >= (3 * scaleY) && y <= (5 * scaleY)) {
                    float leafX = (x / scaleX) - 9;
                    float leafY = (y / scaleY) - 3;
                    if (leafX + leafY <= 3) {
                        img.pixels[y * width + x] = leaf;
                    }
                }
            }
        }
        
        img.updatePixels();
        return img;
    }

    PImage createCarrotImage(int width, int height) {
        PImage img = createImage(width, height, ARGB);
        img.loadPixels();
        
        // Scale factors
        float scaleX = width / 16.0f;
        float scaleY = height / 16.0f;
        
        int carrot = color(255, 140, 0);
        int leaves = color(30, 180, 30);
        
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                // Convert to original scale for calculations
                float origX = x / scaleX;
                float origY = y / scaleY;
                
                // Default transparent
                img.pixels[y * width + x] = color(0, 0, 0, 0);
                
                // Carrot body (triangle shape)
                if (origY >= 5 && origX >= (7-((origY-5)/2)) && origX <= (9+((origY-5)/2))) {
                    img.pixels[y * width + x] = carrot;
                }
                
                // Carrot leaves
                if (origY < 5 && origX >= 6 && origX <= 10) {
                    // Random pixel pattern for leaves
                    if (((((int)origX) + ((int)origY)) % 3 == 0) || ((int)origX == 8 && origY < 4)) {
                        img.pixels[y * width + x] = leaves;
                    }
                }
            }
        }
        
        img.updatePixels();
        return img;
    }

    PImage createBackgroundImage(int width, int height) {
        PImage img = createImage(width, height, RGB);
        img.loadPixels();
        
        // Grass colors
        int lightGrass = color(150, 230, 120);
        int darkGrass = color(130, 210, 100);
        
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                // Checkerboard pattern for grass
                if ((x/10 + y/10) % 2 == 0) {
                    img.pixels[y * width + x] = lightGrass;
                } else {
                    img.pixels[y * width + x] = darkGrass;
                }
            }
        }
        
        img.updatePixels();
        return img;
    }

    // --- Game Classes ---

    class Pig {
        float x, y;
        float size;
        float speed;
        int dirX, dirY;
        float eatAnimation;
        
        Pig() {
            x = width / 2;
            y = height / 2;
            size = 1.0f;
            speed = 5;
            dirX = 0;
            dirY = 0;
            eatAnimation = 0;
        }
        
        void update() {
            // Move based on direction
            x += dirX * speed;
            y += dirY * speed;
            
            // Keep pig within bounds
            x = constrain(x, pigImg.width, width - pigImg.width);
            y = constrain(y, pigImg.height, height - pigImg.height);
            
            // Update eat animation
            if (eatAnimation > 0) {
                eatAnimation -= 0.1f;
            }
        }
        
        void display() {
            pushMatrix();
            translate(x, y);
            scale(3.5f + eatAnimation); // Increased scale for better visibility
            image(pigImg, -pigImg.width/2, -pigImg.height/2);
            popMatrix();
        }
        
        boolean eats(Food food) {
            float distance = dist(x, y, food.x, food.y);
            return distance < 70; // Increased detection radius to match larger graphics
        }
        
        void showEating() {
            eatAnimation = 0.5f; // Start eating animation
        }
    }

    class Food {
        float x, y;
        int type; // 0 = apple, 1 = carrot
        int value;
        
        Food() {
            x = random(30, width - 30);
            y = random(30, height - 30);
            type = floor(random(2)); // Randomly choose food type
            value = (type == 0) ? 10 : 15; // Apples = 10 points, Carrots = 15 points
        }
        
        void display() {
            if (type == 0) {
                // Draw apple with scaling for better visibility
                pushMatrix();
                translate(x, y);
                scale(1.5f); // Scale up the food items
                image(appleImg, -appleImg.width/2, -appleImg.height/2);
                popMatrix();
            } else {
                // Draw carrot with scaling for better visibility
                pushMatrix();  
                translate(x, y);
                scale(1.5f); // Scale up the food items
                image(carrotImg, -carrotImg.width/2, -carrotImg.height/2);
                popMatrix();
            }
        }
    }
}