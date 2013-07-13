
public class GameOfLife {
    private int width;
    private int height;
    private int size;
    private Cell [] cells;
    private String currentLayout;

    public GameOfLife(int w, int h){
        this.width = w;
        this.height = h;
        this.size = w*h;
        this.__createCells();
    }

    public GameOfLife(int w, int h, String layout){
        this.width = w;
        this.height = h;
        this.size = w*h;
        this.__createCells();
        this.__render(layout);
    }

    private void __render(String layout){
        for (int i = 0; i < this.size; i++) {
            char c = layout.charAt(i);
            if (c == '1') {
                this.cells[i].live();
            }
        }
    }

    private void __createCells(){
        this.cells = new Cell[this.size];
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

    private int __countAliveCell(int col, int row){
        if ((col < 0 || col >= this.width) ||
            (row < 0 || row >= this.height)) {
            return 0;
        }
        int idx = 0;
        idx = row * this.width + col;
        char c = this.currentLayout.charAt(idx);
        if (c == '1') {
            return 1;
        }
        return 0;
    }

    private int __aliveNeighboursCount(int col, int row){
        int offset[][] = {{-1, -1}, {0, -1}, {1, -1}, 
                          {-1, 0},  {1, 0}, 
                          {-1, 1},  {0, 1}, {1, 1}};
        int count = 0;
        for (int i = 0; i < offset.length; i++){
             count += this.__countAliveCell(col + offset[i][0], row + offset[i][1]);

        }
        return count;
    }


    public void nextGeneration(){
        this.currentLayout = this.currentGenerationLayout();
        int idx = 0;
        for (int x = 0; x < this.width; x++){
            for (int y = 0; y < this.height; y++){
                idx = y * width + x;
                int count = this.__aliveNeighboursCount(x, y);
                if (count == 3 && this.cells[idx].isAlive() == false) {
                    this.cells[idx].live();
                    continue;
                }

                if (this.cells[idx].isAlive() && (count < 2 || count > 3)) {
                    this.cells[idx].die();
                }
            }
        }
    }

    public String currentGenerationLayout(){
        String layout = "";
        for (int i = 0; i < this.size; i++){
            if (this.cells[i].isAlive()){
                layout += "1";
            }
            else{
                layout += "0";
            }
        }
        return layout;
    }
}