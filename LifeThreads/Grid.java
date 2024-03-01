import java.io.*;
import java.util.*;

public class Grid {

    int height = 13;
    int width = 13;
    int gens;

    Cell [][] cell2darray = new Cell[height][width];

    public void get_grid() throws IOException{

        String pathname = "C:\\Users\\Jayton Schreiner\\Documents\\CS\\OOP\\LifeThreads\\input.txt";
        Scanner scanner = new Scanner(new File(pathname));

        for (int row = 0; row < height; row++) {
            String line = scanner.next();
            for (int col = 0; col < width; col++) {
                if (line.charAt(col) == '.') {
                    cell2darray[row][col].is_alive = false;
                } else {
                    cell2darray[row][col].is_alive = true;
                }
            }
        }
        gens = scanner.nextInt();
        scanner.close();
    }

    public void display_grid () {

        for (int row = 0; row < height; row++ ) {
            for (int col = 0; col < width; col++) {
                if (cell2darray[row][col].is_alive == true) {
                    System.out.print("X");
                } else if (cell2darray[row][col].is_alive == false) {
                    System.out.print(".");
                }
            }

            System.out.println();
        }
    }    
}