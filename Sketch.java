import processing.core.PApplet;

/**
 * Description: A program that creates a user interactive grid using 2d arrays
 * @author: Brighton Zhang
 */

public class Sketch extends PApplet {
  // global variables
	int intCellWidth = 20;
  int intCellHeight = 20;
  int intMargin = 5;
  int intRowCount = 10;
  int intColumnCount = 10;
  int intScreenWidth = intColumnCount * intCellWidth + (intMargin * (intColumnCount + 1)); 
  int intScreenHeight = intRowCount * intCellHeight + (intMargin * (intRowCount + 1));
  int intConsecutiveCells = 2;
  int intRowCellCounter = 0;

  // creation of an empty 2d array
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
    // nested for loop to draw the main grid
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
    // prints out mouse coordinates
    System.out.println("mouse coordinates: (" + mouseX + ", " + mouseY + "); ");
    
    // this nested for loop determines which cells should be highlighted based on where the user clicks
    for(int row = 0; row < intRowCount; row++){
      for(int column = 0; column < intColumnCount; column++ ){
        if(mouseX > column * (intCellHeight + intMargin) + intMargin && mouseX < column * (intCellHeight + intMargin) + intMargin + 20 && mouseY > row * (intCellWidth + intMargin) + intMargin && mouseY < row * (intCellWidth + intMargin) + intMargin + 20){
          System.out.println("grid coordinates: (row: " + (row + 1) + ", column: " + (column + 1) + ")");
          // below is hard code that determines the pattern of highlighted cells
          // top left corner
          if(row == 0 && column == 0){
            // square clicked
            if(intGrid[row][column] == 1){
              intGrid[row][column] = 0;
            }
            else if(intGrid[row][column] == 0){
              intGrid[row][column] = 1;
            }
            // square right
            if(intGrid[row][column + 1] == 1){
              intGrid[row][column + 1] = 0;
            }
            else if(intGrid[row][column + 1] == 0){
              intGrid[row][column + 1] = 1;
            }
            // square below
            if(intGrid[row + 1][column] == 1){
              intGrid[row + 1][column] = 0;
            }
            else if(intGrid[row + 1][column] == 0){
              intGrid[row + 1][column] = 1;
            }
          }

          // top right corner
          else if(row == 0 && column == intGrid[row].length - 1){
            // square clicked
            if(intGrid[row][column] == 1){
              intGrid[row][column] = 0;
            }
            else if(intGrid[row][column] == 0){
              intGrid[row][column] = 1;
            }
            // square left
            if(intGrid[row][column - 1] == 1){
              intGrid[row][column - 1] = 0;
            }
            else if(intGrid[row][column - 1] == 0){
              intGrid[row][column - 1] = 1;
            }
            // square below
            if(intGrid[row + 1][column] == 1){
              intGrid[row + 1][column] = 0;
            }
            else if(intGrid[row + 1][column] == 0){
              intGrid[row + 1][column] = 1;
            }
          }

          // bottom left corner
          else if(row == intGrid.length - 1 && column == 0){
            // square clicked
            if(intGrid[row][column] == 1){
              intGrid[row][column] = 0;
            }
            else if(intGrid[row][column] == 0){
              intGrid[row][column] = 1;
            }
            // square right
            if(intGrid[row][column + 1] == 1){
              intGrid[row][column + 1] = 0;
            }
            else if(intGrid[row][column + 1] == 0){
              intGrid[row][column + 1] = 1;
            }
            // square up
            if(intGrid[row - 1][column] == 1){
              intGrid[row - 1][column] = 0;
            }
            else if(intGrid[row - 1][column] == 0){
              intGrid[row - 1][column] = 1;
            }
          }
          // bottom right corner
          else if(row == intGrid.length - 1 && column == intGrid[row].length - 1){
            // square clicked
            if(intGrid[row][column] == 1){
              intGrid[row][column] = 0;
            }
            else if(intGrid[row][column] == 0){
              intGrid[row][column] = 1;
            }
            // square left
            if(intGrid[row][column - 1] == 1){
              intGrid[row][column - 1] = 0;
            }
            else if(intGrid[row][column - 1] == 0){
              intGrid[row][column - 1] = 1;
            }
            // square up
            if(intGrid[row - 1][column] == 1){
              intGrid[row - 1][column] = 0;
            }
            else if(intGrid[row - 1][column] == 0){
              intGrid[row - 1][column] = 1;
            }
          }
          // top edge
          else if(row == 0 && column > 0 && column < intGrid[row].length - 1){
            // square clicked
            if(intGrid[row][column] == 1){
              intGrid[row][column] = 0;
            }
            else if(intGrid[row][column] == 0){
              intGrid[row][column] = 1;
            }
            // square left
            if(intGrid[row][column - 1] == 1){
              intGrid[row][column - 1] = 0;
            }
            else if(intGrid[row][column - 1] == 0){
              intGrid[row][column - 1] = 1;
            }
            // square down
            if(intGrid[row + 1][column] == 1){
              intGrid[row + 1][column] = 0;
            }
            else if(intGrid[row + 1][column] == 0){
              intGrid[row + 1][column] = 1;
            }
            // square right
            if(intGrid[row][column + 1] == 1){
              intGrid[row][column + 1] = 0;
            }
            else if(intGrid[row][column + 1] == 0){
              intGrid[row][column + 1] = 1;
            }
          }
          // bottom edge
          else if(row == intGrid.length - 1 && column > 0 && column < intGrid[row].length - 1){
            // square clicked
            if(intGrid[row][column] == 1){
              intGrid[row][column] = 0;
            }
            else if(intGrid[row][column] == 0){
              intGrid[row][column] = 1;
            }
            // square left
            if(intGrid[row][column - 1] == 1){
              intGrid[row][column - 1] = 0;
            }
            else if(intGrid[row][column - 1] == 0){
              intGrid[row][column - 1] = 1;
            }
            // square up
            if(intGrid[row - 1][column] == 1){
              intGrid[row - 1][column] = 0;
            }
            else if(intGrid[row - 1][column] == 0){
              intGrid[row - 1][column] = 1;
            }
            // square right
            if(intGrid[row][column + 1] == 1){
              intGrid[row][column + 1] = 0;
            }
            else if(intGrid[row][column + 1] == 0){
              intGrid[row][column + 1] = 1;
            }
          }
          // left edge
          else if(column == 0 && row > 0 && row < intGrid.length - 1){
            // square clicked
            if(intGrid[row][column] == 1){
              intGrid[row][column] = 0;
            }
            else if(intGrid[row][column] == 0){
              intGrid[row][column] = 1;
            }
            // square up
            if(intGrid[row - 1][column] == 1){
              intGrid[row - 1][column] = 0;
            }
            else if(intGrid[row - 1][column] == 0){
              intGrid[row - 1][column] = 1;
            }
            // square down
            if(intGrid[row + 1][column] == 1){
              intGrid[row + 1][column] = 0;
            }
            else if(intGrid[row + 1][column] == 0){
              intGrid[row + 1][column] = 1;
            }
            // square right
            if(intGrid[row][column + 1] == 1){
              intGrid[row][column + 1] = 0;
            }
            else if(intGrid[row][column + 1] == 0){
              intGrid[row][column + 1] = 1;
            }
          }
          // right edge
          else if(column == intGrid[row].length - 1 && row > 0 && row < intGrid.length - 1){
            // square clicked
            if(intGrid[row][column] == 1){
              intGrid[row][column] = 0;
            }
            else if(intGrid[row][column] == 0){
              intGrid[row][column] = 1;
            }
            // square up
            if(intGrid[row - 1][column] == 1){
              intGrid[row - 1][column] = 0;
            }
            else if(intGrid[row - 1][column] == 0){
              intGrid[row - 1][column] = 1;
            }
            // square down
            if(intGrid[row + 1][column] == 1){
              intGrid[row + 1][column] = 0;
            }
            else if(intGrid[row + 1][column] == 0){
              intGrid[row + 1][column] = 1;
            }
            // square left
            if(intGrid[row][column - 1] == 1){
              intGrid[row][column - 1] = 0;
            }
            else if(intGrid[row][column - 1] == 0){
              intGrid[row][column - 1] = 1;
            }
          }
          else{
            // square clicked
            if(intGrid[row][column] == 1){
              intGrid[row][column] = 0;
            }
            else if(intGrid[row][column] == 0){
              intGrid[row][column] = 1;
            }
            // square above
            if(intGrid[row - 1][column] == 1){
              intGrid[row - 1][column] = 0;
            }
            else if(intGrid[row - 1][column] == 0){
              intGrid[row - 1][column] = 1;
            }
            // square below
            if(intGrid[row + 1][column] == 1){
              intGrid[row + 1][column] = 0;
            }
            else if(intGrid[row + 1][column] == 0){
              intGrid[row + 1][column] = 1;
            }
            // square right
            if(intGrid[row][column + 1] == 1){
              intGrid[row][column + 1] = 0;
            }
            else if(intGrid[row][column + 1] == 0){
              intGrid[row][column + 1] = 1;
            }
            // square left
            if(intGrid[row][column - 1] == 1){
              intGrid[row][column - 1] = 0;
            }
            else if(intGrid[row][column - 1] == 0){
              intGrid[row][column - 1] = 1;
            }
          }
        }
      }
    }
    
    // nested for loop that counts and outputs the total number of highlighted cells
    int intCellCounter = 0;
    for(int row = 0; row < intRowCount; row++){
      for(int column = 0; column < intColumnCount; column++ ){
        if(intGrid[row][column] == 1){
          intCellCounter++;
        }
      }
    }
    System.out.println("Total of " + intCellCounter + " cells are selected.");

    // nested for loop that counts the total number of highlighted cells in a row, as well as consecutive cells
    for(int row = 0; row < intRowCount; row++){
      for(int column = 0; column < intColumnCount; column++ ){
        if(intGrid[row][column] == 1){
          intRowCellCounter++;
          // intConsecutiveCells is incremented for every consecutive cell beyond 3
          if(column >= 2 && intGrid[row][column - 1] == 1 && intGrid[row][column - 2] == 1){
            intConsecutiveCells++;
            // if the column is 10 or the consecutive flow of cells is broken, it outputs the line
            if(column == 9 || intGrid[row][column + 1] == 0){
              System.out.println("There are " + intConsecutiveCells + " continuous blocks selected on row " + (row + 1) + ".");
              intConsecutiveCells = 2;
            }
          }
        }
      }
      System.out.println("Row " + (row + 1) + " has " + intRowCellCounter + " cells selected");
      intRowCellCounter = 0;
    }

    // nested for loop that counts and outputs number of highlighted cells in every column
    for(int column = 0; column < intColumnCount; column++){
      int intColumnCellCounter = 0;
      for(int row = 0; row < intRowCount; row++ ){
        if(intGrid[row][column] == 1){
          intColumnCellCounter++;
        }
      }
      System.out.println("Column " + (column + 1) + " has " + intColumnCellCounter + " cells selected");
    }
  }
}
