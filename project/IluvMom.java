import processing.core.*;

public class IluvMom extends PApplet {
    // Character position and movement
    float characterX = -100;
    float characterY = 350;
    float moveSpeed = 2;
    
    // Flower animation
    float flowerAngle = 0;
    
    // Heart animation
    float heartSize = 20;
    float heartGrow = 0.2f;
    
    // Cloud positions
    float[] cloudX = {100, 350, 600};
    float[] cloudSpeed = {0.5f, 0.7f, 0.4f};
    
    // Birds
    float[] birdX = {500, 650, 400};
    float[] birdY = {100, 150, 80};
    float[] birdSpeed = {-1.5f, -1.2f, -1.8f};
    
    // New: Rainbow effect
    float rainbowY = 200;
    boolean showRainbow = false;
    int rainbowTimer = 0;
    
    // New: Gift box
    float giftX = 400;
    float giftY = 380;
    boolean giftOpen = false;
    int giftOpenTimer = 0;
    
    public static void main(String[] args) {
        PApplet.main("IluvMom");  // Fixed to match class name
    }
    
    public void settings() {
        size(800, 500);
    }
    
    public void setup() {
        background(135, 206, 235); // Sky blue background
    }
    
    public void draw() {
        // Draw sky
        background(135, 206, 235);
        
        // Draw ground (grass)
        fill(76, 153, 0);
        rect(0, 400, width, 100);
        
        // Draw rainbow occasionally
        updateRainbow();
        if (showRainbow) {
            drawRainbow();
        }
        
        // Draw clouds
        drawClouds();
        
        // Draw birds
        drawBirds();
        
        // Draw sun
        fill(255, 255, 0);
        stroke(255, 200, 0);
        strokeWeight(4);
        circle(700, 80, 70);
        
        // Draw title text
        fill(255, 105, 180);
        textSize(40);
        textAlign(CENTER);
        text("Happy Mother's Day!", width/2, 100);
        
        // Draw subtitle
        fill(255, 20, 147);
        textSize(24);
        text("I Love You Mom!", width/2, 140);
        
        // Draw gift box
        drawGift();
        
        // Draw little character
        drawCharacter(characterX, characterY);
        
        // Move character
        characterX += moveSpeed;
        if (characterX > width + 100) {
            characterX = -100;
        }
        
        // Animate flower
        flowerAngle += 0.05;
        
        // Animate hearts
        heartSize += heartGrow;
        if (heartSize > 30 || heartSize < 20) {
            heartGrow *= -1;
        }
        
        // Draw floating hearts
        drawHearts();
    }
    
    void drawCharacter(float x, float y) {
        pushMatrix();
        translate(x, y);
        
        // Body (white with black outline)
        fill(255);
        stroke(0);
        strokeWeight(2);
        ellipse(0, -30, 40, 50); // Body
        
        // Head
        ellipse(0, -65, 45, 40);
        
        // Face
        fill(0);
        ellipse(-10, -70, 5, 8); // Left eye
        ellipse(10, -70, 5, 8);  // Right eye
        
        // Smile
        noFill();
        arc(0, -60, 20, 15, 0, PI);
        
        // Arms
        line(-20, -30, -40, -45); // Left arm
        
        // Right arm holding flowers
        line(20, -30, 40, -50);
        
        // Flowers
        pushMatrix();
        translate(45, -60);
        
        // Stem
        stroke(0, 128, 0);
        line(0, 0, 0, 30);
        
        // Flower petals
        noStroke();
        fill(255, 105, 180); // Pink
        
        // Animate flower petals
        pushMatrix();
        rotate(flowerAngle);
        ellipse(-10, -10, 15, 15);
        ellipse(10, -10, 15, 15);
        ellipse(-10, 10, 15, 15);
        ellipse(10, 10, 15, 15);
        popMatrix();
        
        // Flower center
        fill(255, 255, 0);
        ellipse(0, 0, 10, 10);
        
        popMatrix();
        
        // Legs
        stroke(0);
        line(-10, -5, -15, 30); // Left leg
        line(10, -5, 15, 30);  // Right leg
        
        popMatrix();
        
        // Check if character is near gift box to open it
        if (abs(x - giftX) < 50 && !giftOpen) {
            giftOpen = true;
            giftOpenTimer = 0;
        }
    }
    
    void drawClouds() {
        fill(255);
        noStroke();
        
        for (int i = 0; i < cloudX.length; i++) {
            // Draw cloud
            ellipse(cloudX[i], 80, 70, 50);
            ellipse(cloudX[i] - 30, 80, 50, 40);
            ellipse(cloudX[i] + 30, 80, 50, 40);
            
            // Move cloud
            cloudX[i] += cloudSpeed[i];
            
            // Wrap around
            if (cloudX[i] > width + 100) {
                cloudX[i] = -100;
            }
        }
    }
    
    void drawHearts() {
        fill(255, 0, 0, 200);
        noStroke();
        
        // Draw hearts at different positions
        drawHeart(width/2 - 100, 200, heartSize);
        drawHeart(width/2 + 100, 200, 35 - heartSize);
        drawHeart(width/2, 150, heartSize * 1.2f);
        
        // Add extra hearts if gift is open
        if (giftOpen) {
            drawHeart(giftX - 20, giftY - 80 - giftOpenTimer/2, 15 + sin(frameCount * 0.1f) * 5);
            drawHeart(giftX + 20, giftY - 100 - giftOpenTimer/2, 10 + sin(frameCount * 0.15f + 1) * 5);
            drawHeart(giftX, giftY - 120 - giftOpenTimer/2, 20 + sin(frameCount * 0.08f + 2) * 5);
        }
    }
    
    void drawHeart(float x, float y, float size) {
        pushMatrix();
        translate(x, y);
        
        beginShape();
        vertex(0, size/2);
        bezierVertex(size/2, -size/2, size, size/2, 0, size * 1.5f);
        bezierVertex(-size, size/2, -size/2, -size/2, 0, size/2);
        endShape();
        
        popMatrix();
    }
    
    void drawBirds() {
        stroke(0);
        strokeWeight(1.5f);
        
        for (int i = 0; i < birdX.length; i++) {
            // Draw simple bird (^ shape)
            pushMatrix();
            translate(birdX[i], birdY[i]);
            
            // Animate wings
            float wingAngle = sin(frameCount * 0.2f + i) * 0.3f;
            
            line(-10, 0, 0, -5);
            pushMatrix();
            translate(0, -5);
            rotate(wingAngle);
            line(0, 0, 10, 5);
            popMatrix();
            
            popMatrix();
            
            // Move birds
            birdX[i] += birdSpeed[i];
            
            // Wrap around
            if (birdX[i] < -20) {
                birdX[i] = width + 20;
            }
        }
    }
    
    void drawGift() {
        pushMatrix();
        translate(giftX, giftY);
        
        if (!giftOpen) {
            // Closed gift box
            fill(255, 20, 147);  // Pink box
            stroke(0);
            strokeWeight(2);
            rect(-25, -20, 50, 40);
            
            // Ribbon
            fill(255, 215, 0);  // Gold ribbon
            rect(-5, -20, 10, 40);
            rect(-25, -5, 50, 10);
            
            // Bow
            ellipse(-10, -25, 15, 10);
            ellipse(10, -25, 15, 10);
        } else {
            // Open gift box
            giftOpenTimer++;
            
            // Bottom of box
            fill(255, 20, 147);
            stroke(0);
            strokeWeight(2);
            rect(-25, -5, 50, 25);
            
            // Box sides
            beginShape();
            vertex(-25, -5);
            vertex(-35, -20);
            vertex(35, -20);
            vertex(25, -5);
            endShape(CLOSE);
            
            // Box lid (opening animation)
            pushMatrix();
            translate(0, -20);
            rotate(min(PI/2, giftOpenTimer * 0.05f));
            rect(-35, -15, 70, 15);
            popMatrix();
            
            // Show rainbow after gift opens
            if (giftOpenTimer > 30) {
                showRainbow = true;
            }
        }
        
        popMatrix();
    }
    
    void drawRainbow() {
        noFill();
        strokeWeight(10);
        
        // Draw rainbow arcs
        stroke(255, 0, 0, 150);  // Red
        arc(width/2, 600, 500, 500, PI, TWO_PI);
        
        stroke(255, 127, 0, 150);  // Orange
        arc(width/2, 600, 470, 470, PI, TWO_PI);
        
        stroke(255, 255, 0, 150);  // Yellow
        arc(width/2, 600, 440, 440, PI, TWO_PI);
        
        stroke(0, 255, 0, 150);  // Green
        arc(width/2, 600, 410, 410, PI, TWO_PI);
        
        stroke(0, 0, 255, 150);  // Blue
        arc(width/2, 600, 380, 380, PI, TWO_PI);
        
        stroke(75, 0, 130, 150);  // Indigo
        arc(width/2, 600, 350, 350, PI, TWO_PI);
        
        stroke(143, 0, 255, 150);  // Violet
        arc(width/2, 600, 320, 320, PI, TWO_PI);
    }
    
    void updateRainbow() {
        if (showRainbow) {
            rainbowTimer++;
            if (rainbowTimer > 300) {
                showRainbow = false;
                rainbowTimer = 0;
            }
        } else {
            // Random chance to show rainbow
            if (random(1000) < 1) {
                showRainbow = true;
                rainbowTimer = 0;
            }
        }
    }
}