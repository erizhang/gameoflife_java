
public class GameOfLife {
    private int width;
    private int height;
    private int size;
    private Cell [] cells;

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

    private int aliveNeighboursCount(int col, int row){
        return 0;
    }

    public void nextGeneration(){
        int idx = 0;
        for (int x = 0; x < this.width; x++){
            for (int y = 0; y < this.height; y++){
                idx = y * width + x;
                int count = this.aliveNeighboursCount(x, y);
                if (count == 3) {
                    this.cells[idx].live();
                    continue;
                }

                if (count < 2 || count > 4) {
                    this.cells[idx].die();
                }
            }
        }
    }

    public String currentGenerationLayout(){
        String layout = "";
        for (int i = 0; i < this.size; i++){
            if (this.cells[i].isAlive() == true){
                layout += "1";
            }
            else{
                layout += "0";
            }
        }
        return layout;
    }
}