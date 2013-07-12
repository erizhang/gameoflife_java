
public class GameOfLife {
    private int width;
    private int height;
    private Cell [] cells;

    public GameOfLife(int w, int h){
        this.width = w;
        this.height = h;
        this.__createCells();
    }

    private void __createCells(){
        int size = this.width * this.height;

        this.cells = new Cell[size];
        int idx = 0;
        for (int x = 0; x < this.width; x++){
            for (int y = 0; y < this.height; y++){
                idx = y * width + x;
                this.cells[idx] = new Cell(x, y);
                System.out.print(".");
            }
        }
        System.out.println();
    }

    public Cell findCell(int col, int row){
        int idx = 0;
        idx = row * this.width + col;
        return this.cells[idx];
    }
}