
public class Threader implements Runnable{
    private Grid grid;
    private int row;
    private int col;

    public void getparams (Grid ingrid, int inrow, int incol) {
        grid = ingrid;
        row = inrow;
        col = incol;
    }

    @Override
    public void run() {

        //count neighbors
        grid.cell2darray[row][col].neighbors = grid.cell2darray[row][col].count_neighbors(row, col, grid);

        //determine status
        grid.cell2darray[row][col].nextgen = grid.cell2darray[row][col].determine_status(grid.cell2darray[row][col], grid.cell2darray[row][col].neighbors);
    }
}
