import java.io.*;

public class Driver {

    public static Grid grid = new Grid();
    public static Thread threadarray[][] = new Thread[grid.height][grid.width];

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
            //run all threads
            for (int r = 0; r < grid.height; r++) {
                for (int c = 0; c < grid.width; c++) {
                    Runnable runner = new Threader();
                    ((Threader) runner).getparams(grid, r, c);
                    threadarray[r][c] = new Thread(runner);
                    threadarray[r][c].start();
                }
            }
            
            //join all threads
            for (int row = 0; row < grid.height; row++) {
                for (int col = 0; col < grid.width; col++) {
                    try {
                        threadarray[row][col].join();
                    } catch (Exception e) {
                        System.out.print(e);
                    }
                }
            }

            //update status of each cell
            for (int row = 0; row < grid.height; row++) {
                for (int col = 0; col < grid.width; col++) {
                    grid.cell2darray[row][col].is_alive = grid.cell2darray[row][col].nextgen;
                }
            }
        }

        //output to console
        grid.display_grid();
    }
}
