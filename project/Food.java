import processing.core.*;

class Food {
  PApplet parent;
  float x, y;
  int type; // 0 = apple, 1 = carrot
  int value;
  
  Food(PApplet p) {
    parent = p;
    x = parent.random(30, parent.width - 30);
    y = parent.random(30, parent.height - 30);
    type = parent.floor(parent.random(2)); // Randomly choose food type
    value = (type == 0) ? 10 : 15; // Apples = 10 points, Carrots = 15 points
  }
  
  void display() {
    // Get reference to main class
    HungryPig main = (HungryPig) parent;
    
    if (type == 0) {
      // Draw apple with scaling for better visibility
      parent.pushMatrix();
      parent.translate(x, y);
      parent.scale(1.5f); // Scale up the food items
      parent.image(main.appleImg, -main.appleImg.width/2, -main.appleImg.height/2);
      parent.popMatrix();
    } else {
      // Draw carrot with scaling for better visibility
      parent.pushMatrix();  
      parent.translate(x, y);
      parent.scale(1.5f); // Scale up the food items
      parent.image(main.carrotImg, -main.carrotImg.width/2, -main.carrotImg.height/2);
      parent.popMatrix();
    }
  }
}