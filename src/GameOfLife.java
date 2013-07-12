
public class GameOfLife {
    private int width;
    private int height;
    private Cell [] cells;

    public GameOfLife(int w, int h){
        this.width = w;
        this.height = h;
        this.__createCells();
    }

    public GameOfLife(int w, int h, String layout){
        this.width = w;
        this.height = h;
        this.__createCells();
        this.__render(layout);
    }

    private void __render(String layout){
        int size = this.width * this.height;
        for (int i = 0; i < size; i++) {
            char c = layout.charAt(i);
            if (c == '1') {
                this.cells[i].live();
            }
        }
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

    public void nextGeneration(){

    }

    public String currentGenerationLayout(){
        String layout = "";
        return layout;
    }

    public Cell findCell(int col, int row){
        int idx = 0;
        idx = row * this.width + col;
        return this.cells[idx];
    }
}