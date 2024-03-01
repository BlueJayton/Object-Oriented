
public class Cell {
    
    public int row;
    public int col;
    public boolean is_alive;
    public boolean nextgen;
    public int neighbors;

    public int count_neighbors ( int row, int col, Grid grid) {
        int numberofneighbors = 0;

        numberofneighbors = numberofneighbors + check_neighbors(row - 1, col - 1, grid); //top left
        numberofneighbors = numberofneighbors + check_neighbors(row - 1, col, grid); //top
        numberofneighbors = numberofneighbors + check_neighbors(row - 1, col + 1, grid); //top right
        numberofneighbors = numberofneighbors + check_neighbors(row, col - 1, grid); //left
        numberofneighbors = numberofneighbors + check_neighbors(row, col + 1, grid); //right
        numberofneighbors = numberofneighbors + check_neighbors(row + 1, col - 1, grid); //bottom left
        numberofneighbors = numberofneighbors + check_neighbors(row + 1, col, grid); //bottom
        numberofneighbors = numberofneighbors + check_neighbors(row + 1, col + 1, grid); //bottom right

        return numberofneighbors;
    }

    private int check_neighbors (int row, int col, Grid grid) {

        if (row < 0){
            return 0;
        } 
        if (col < 0){
            return 0;
        }
        if (row >= grid.height) {
            return 0;
        }
        if (col >= grid.width) {
            return 0;
        }

        if (grid.cell2darray[row][col].is_alive == true) {
            return 1;
        } else {
            return 0;
        }
    }

    public boolean determine_status (Cell cell, int neighbors) {

        boolean alive = true;
        boolean dead = false;

        if (cell.is_alive == true) {
            if (neighbors < 2) {
                return dead;
            } else if (neighbors > 3) {
                return dead;
            } else  if (neighbors == 2 || neighbors == 3) {
                return alive;
            }

        } else if (cell.is_alive == dead) {
            if (neighbors == 3) {
                return alive;
            }
        }

        return cell.is_alive; //if others fail, return what came in
    }
}
