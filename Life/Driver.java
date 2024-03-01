import java.io.*;

public class Driver {
    
    public static Grid grid = new Grid();

    public static void main (String args[]) throws IOException{

        //initialize each element to a Cell
        for (int row = 0; row < grid.height; row++ ) {
            for (int col = 0; col < grid.width; col++) {
                grid.cell2darray[row][col] = new Cell();
            }
        }

        //read in file to grid
        grid.get_grid();

        for (int i = 0; i < grid.gens; i++){

            //count all neighbors
            for (int r = 0; r < grid.height; r++) {
                for (int c = 0; c < grid.width; c++) {
                    grid.cell2darray[r][c].neighbors = grid.cell2darray[r][c].count_neighbors (r, c, grid);
                }
            }

            //determine if each cell is alive or dead
            for (int h = 0; h < grid.height; h++) {
                for (int w = 0; w < grid.width; w++) {
                    grid.cell2darray[h][w].is_alive = grid.cell2darray[h][w].determine_status(grid.cell2darray[h][w], grid.cell2darray[h][w].neighbors);
                }
            }
        }

        //output to console
        grid.display_grid();
    }
}
