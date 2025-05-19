import processing.core.*;

class Pig {
  PApplet parent;
  float x, y;
  float size;
  float speed;
  int dirX, dirY;
  float eatAnimation;
  
  Pig(PApplet p) {
    parent = p;
    x = parent.width / 2;
    y = parent.height / 2;
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
    
    // Get reference to main class for width/height
    HungryPig main = (HungryPig) parent;
    
    // Keep pig within bounds
    x = parent.constrain(x, main.pigImg.width, parent.width - main.pigImg.width);
    y = parent.constrain(y, main.pigImg.height, parent.height - main.pigImg.height);
    
    // Update eat animation
    if (eatAnimation > 0) {
      eatAnimation -= 0.1f;
    }
  }
  
  void display() {
    // Get reference to main class
    HungryPig main = (HungryPig) parent;
    
    parent.pushMatrix();
    parent.translate(x, y);
    parent.scale(3.5f + eatAnimation); // Increased scale for better visibility
    parent.image(main.pigImg, -main.pigImg.width/2, -main.pigImg.height/2);
    parent.popMatrix();
  }
  
  boolean eats(Food food) {
    float distance = parent.dist(x, y, food.x, food.y);
    return distance < 70; // Increased detection radius to match larger graphics
  }
  
  void showEating() {
    eatAnimation = 0.5f; // Start eating animation
  }
}