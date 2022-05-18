import processing.core.PApplet;

public class Sketch extends PApplet {
	int intCellWidth = 20;
  int intCellHeight = 20;
  int intMargin = 5;
  int intRowCount = 10;
  int intColumnCount = 10;
  int intCounter = 0;
  int intScreenWidth = intColumnCount * intCellWidth + (intMargin * (intColumnCount + 1)); 
  int intScreenHeight = intRowCount * intCellHeight + (intMargin * (intRowCount + 1));
  int intGrid [][] = new int [10][10];

  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
    // put your size call here
    size(intScreenWidth, intScreenHeight);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(0);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    for(int row = 0; row < intRowCount; row++){
      for(int column = 0; column < intColumnCount; column++ ){
        if(intGrid[row][column] == 1){
          fill(0,255,0);
          rect(column * (intCellWidth + intMargin) + intMargin, row * (intCellHeight + intMargin) + intMargin, intCellWidth, intCellHeight);
        }
        
        else{
          fill(255);
          rect(column * (intCellWidth + intMargin) + intMargin, row * (intCellHeight + intMargin) + intMargin, intCellWidth, intCellHeight);
        }
      }
    }
  }

  /** 
   * This method, mousePressed(), checks the mouse coordinate and grid coordinate, using it to light up a cell to green if pressed o in the draw() method.
   */
  public void mousePressed() {
    System.out.println("mouse coordinates: (" + mouseX + ", " + mouseY + "); ");
    for(int row = 0; row < intRowCount; row++){
      for(int column = 0; column < intColumnCount; column++ ){
        if(mouseX > column * (intCellHeight + intMargin) + intMargin && mouseX < column * (intCellHeight + intMargin) + intMargin + 20 && mouseY > row * (intCellWidth + intMargin) + intMargin && mouseY < row * (intCellWidth + intMargin) + intMargin + 20){
          System.out.println("grid coordinates: (row: " + (row + 1) + ", column: " + (column + 1) + ")");
          if(intGrid[row][column] == 1){
            intGrid[row][column] = 0;
          }
          else if(intGrid[row][column] == 0){
            intGrid[row][column] = 1;
          }
        }
      }
    }
  }
}
