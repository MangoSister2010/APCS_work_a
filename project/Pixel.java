import processing.core.*;

class Pixel {
  private PApplet parent;
  
  Pixel(PApplet p) {
    parent = p;
  }
  
  PImage createPigImage(int width, int height) {
    PImage img = parent.createImage(width, height, PApplet.ARGB);
    img.loadPixels();
    
    // Pig colors
    int pigPink = parent.color(255, 170, 180);
    int pigDarkPink = parent.color(220, 140, 150);
    int pigNose = parent.color(200, 100, 110);
    int pigEyes = parent.color(30, 30, 30);
    
    // Scale factors
    float scaleX = width / 20.0f;
    float scaleY = height / 20.0f;
    float centerX = width / 2.0f;
    float centerY = height / 2.0f;
    
    // Draw pig face pixel by pixel
    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        // Convert to original scale for calculations
        float origX = x / scaleX;
        float origY = y / scaleY;
        
        // Default transparent
        img.pixels[y * width + x] = parent.color(0, 0, 0, 0);
        
        // Pig body (basic circle)
        float distFromCenter = parent.dist(x, y, centerX, centerY);
        if (distFromCenter < (9 * scaleX)) {
          img.pixels[y * width + x] = pigPink;
        }
        
        // Pig ears
        if ((x < (5 * scaleX) && y < (5 * scaleY)) || (x > (14 * scaleX) && y < (5 * scaleY))) {
          float earX = x < (5 * scaleX) ? (4 * scaleX) : (15 * scaleX);
          float earY = 4 * scaleY;
          if (parent.dist(earX, earY, x, y) < (4 * scaleX)) {
            img.pixels[y * width + x] = pigDarkPink;
          }
        }
        
        // Pig eyes
        if ((parent.dist(x, y, 6 * scaleX, 8 * scaleY) < (2 * scaleX)) || 
            (parent.dist(x, y, 14 * scaleX, 8 * scaleY) < (2 * scaleX))) {
          img.pixels[y * width + x] = pigEyes;
        }
        
        // Pig nose
        if (y > (10 * scaleY) && y < (15 * scaleY) && x > (7 * scaleX) && x < (13 * scaleX)) {
          if (parent.dist(x, y, 10 * scaleX, 12 * scaleY) < (3 * scaleX)) {
            img.pixels[y * width + x] = pigNose;
          }
        }
        
        // Pig nostrils
        if ((parent.dist(x, y, 8.5f * scaleX, 12 * scaleY) < (1 * scaleX)) || 
            (parent.dist(x, y, 11.5f * scaleX, 12 * scaleY) < (1 * scaleX))) {
          img.pixels[y * width + x] = parent.color(150, 80, 90);
        }
      }
    }
    
    img.updatePixels();
    return img;
  }
  
  PImage createAppleImage(int width, int height) {
    PImage img = parent.createImage(width, height, PApplet.ARGB);
    img.loadPixels();
    
    // Scale factors
    float scaleX = width / 16.0f;
    float scaleY = height / 16.0f;
    
    int apple = parent.color(220, 30, 30);
    int stem = parent.color(100, 70, 30);
    int leaf = parent.color(30, 180, 30);
    
    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        // Convert to original scale for calculations
        float origX = x / scaleX;
        float origY = y / scaleY;
        
        // Default transparent
        img.pixels[y * width + x] = parent.color(0, 0, 0, 0);
        
        // Apple body
        float distFromCenter = parent.dist(x, y, 8 * scaleX, 9 * scaleY);
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
    PImage img = parent.createImage(width, height, PApplet.ARGB);
    img.loadPixels();
    
    // Scale factors
    float scaleX = width / 16.0f;
    float scaleY = height / 16.0f;
    
    int carrot = parent.color(255, 140, 0);
    int leaves = parent.color(30, 180, 30);
    
    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        // Convert to original scale for calculations
        float origX = x / scaleX;
        float origY = y / scaleY;
        
        // Default transparent
        img.pixels[y * width + x] = parent.color(0, 0, 0, 0);
        
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
    PImage img = parent.createImage(width, height, PApplet.RGB);
    img.loadPixels();
    
    // Grass colors
    int lightGrass = parent.color(150, 230, 120);
    int darkGrass = parent.color(130, 210, 100);
    
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
}