import processing.core.PApplet;

public class Sketch extends PApplet {

  // Declare variables
  int numSnow = 10;
  float[] snowX = new float[numSnow];
  float[] snowY = new float[numSnow];
  float[] snowSPD = new float[numSnow];
  boolean[] ballHideStatus = new boolean[numSnow];
  int snowCnt = 10;
  float[] SnowX = new float[snowCnt];
  float[] SnowY = new float[snowCnt];
  float[] SnowSPD = new float[snowCnt];
  boolean[] ballHideStatus = new boolean[snowCnt];
  int Lives = 3;

  float playerX, playerY;
  float playerSPD = 10;

  boolean upPressed = false;
  boolean downPressed = false;
  boolean rightPressed = false;
  boolean leftPressed = false;
  boolean Collision = false;

  public void setttings(){
    size(400, 400);
  }

  public void setup(){
    background(0,0,0);
  }
  {

  // Draw player on screen
  playerX = 400 / 2;
  playerY = 400 / 2;

  // Setup snowfalkes
  for(int i = 0; i < numSnow; i++){
    snowX[i] = random(width);
    snowY[i] = random(height);
    snowSPD[i] = random(1, 4);

    for(int i = 0; i < snowCnt; i++){
      SnowX[i] = random(width);
      SnowY[i] = random(height);
      SnowSPD[i] = random(1, 4);

      ballHideStatus[i] = false;
    }
  }

  }

  public void draw(){
    background(0,0,0);

    // Display the number of lives the player has
    printLives();

    // Display player on screen
    fill(52, 253, 76);
    ellipse(playerX, playerY, 10, 10);

    // Determine how much the player will move if WASD is pressed
    if(upPressed){
      playerY -= 4;
    }
    else if(downPressed){
      playerY -= 4;
    }
    else if(rightPressed){
      playerX -= 4;
    }
    else if(leftPressed){
      playerX -= 4;
    }
  }
  {


  // Draw snowflakes on the screen
  for(int i = 0; i < numSnow; i++){
    for(int i = 0; i < snowCnt; i++){
      if(!ballHideStatus[i]){
        fill(255, 255, 255);
        ellipse(snowX[i], snowY[i], 20, 20);
        ellipse(SnowX[i], SnowY[i], 20, 20);

  // Check if player collides with snowflakes
  if(dist(playerX, playerY, snowX[i], snowY[i]) < 20 && !Collision){
    if(dist(playerX, playerY, SnowX[i], SnowY[i]) < 20 && !Collision){

      // Make live counter go down and reset player for next round
      if(Lives > 0){
        Lives --;
        resetPlayer();
        Collision = true;
      }
    }
  }
}

// Update snowflakes

SnowY[i] += SnowSPD[i];
snowY[i] += snowSPD[i];

// Add collision detection to showflakes and make them go back to the top of screen 
if(SnowY[i] > 400){
  SnowY[i] = 0;
  SnowX[i] = random(width);
  if(snowY[i] > 400){
    snowY[i] = 0;
    snowX[i] = random(width);
  }
}

// If player hits a snowflake, reset the Collision variable
if(Collision){
  Collision = false;
}

// If player loses all lives, end the game
if(Lives <= 0){
  textSize(50);
  text("You lost! Better luck next time!", 200, 200);
}

// Move snowflakes based on arrow key presses
public void keyPressed(){
  if(keyCode == UP){
    for(int i = 0; i < numSnow; i++){
      SnowSPD[i] *= 2;
      for(int i = 0; i < snowCnt; i++){
        snowSPD[i] *= 2;
      }
    }
  }
    else if(keyCode == DOWN){
       for(int i = 0; i < numSnow; i++){
      SnowSPD[i] *= 2;
      for(int i = 0; i < snowCnt; i++){
        snowSPD[i] *= 2;
      }
    }
    }

// Move player based on WASD presses
if(key == 'w'){
  upPressed = true;
}
if(key == 's'){
  downPressed = true;
}
if(key == 'a'){
  leftPressed = true;
}
if(key == 'd'){
  rightPressed = true;
}

// If player releases WASD, player stops moving
public void keyReleased(){
  if(key == 'w'){
  upPressed = false;
}
if(key == 's'){
  downPressed = false;
}
if(key == 'a'){
  leftPressed = false;
}
if(key == 'd'){
  rightPressed = false;
}
}

// Reset player if they lose a life
public void resetPlayer(){
  playerX = 200;
  playerY = 370;
}

// Update the player's life counter
public void printLives(){
  for(int i = 0; i < Lives; i++){
    fill(255, 23,23);
    ellipse(width - 40 - i * 40, 10, 30, 30);
  }
}

// Detect if a snowflakes has been clicked on by the mouse
public void mouseClicked(){
  for(int i = 0; i < numSnow; i++){
    for(int i = 0; i < snowCnt; i++){
      if(!ballHideStatus[i] && dist(mouseX, mouseY, SnowX[i], SnowY[i])){
            if(!ballHideStatus[i] && dist(mouseX, mouseY, snowX[i], snowY[i])){
            if(mousePressed){
              ballHideStatus[i] = true;
            }

}

  
}
  }
}
}
}
  