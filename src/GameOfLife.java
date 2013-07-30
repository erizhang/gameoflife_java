
public class GameOfLife {
    private int width;
    private int height;
    private int size;
    private Cell [] cells;

    public GameOfLife(int w, int h, String layout){
        this.width = w;
        this.height = h;
        this.size = w*h;
        this.__createCells();
        this.__render(layout);
    }

    private void __render(String layout){
        for (int i = 0; i < this.size; i++) {
            if (layout.charAt(i) == '1') {
                this.cells[i].live();
            }
        }
    }

    private int __indexByCoordinate(int col, int row) {
        int idx = 0;
        return idx = row * this.width + col;
    }

    private Cell __getCell(int col, int row){
        if ((col < 0 || col >= this.width) ||
            (row < 0 || row >= this.height)) {
            return null;
        }
        int idx = __indexByCoordinate(col, row);
        return this.cells[idx];
    }

    private void __createCells(){
        this.cells = new Cell[this.size];
        int idx = 0;
        for (int x = 0; x < this.width; x++){
            for (int y = 0; y < this.height; y++){
                idx = this.__indexByCoordinate(x, y);
                this.cells[idx] = new Cell(x, y);
            }
        }
    }

    private int __countAliveCell(int col, int row){
        Cell cell = this.__getCell(col, row);

        if (null != cell && cell.isAlive()) {
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

    private void __saveCurrentCellsState() {
        for (int x = 0; x < this.width; x++) {
            for (int y = 0; y < this.height; y++) {
                Cell cell = this.__getCell(x, y);
                cell.saveState();
            }
        }
    }

    public void nextGeneration(){
        this.__saveCurrentCellsState();

        for (int x = 0; x < this.width; x++){
            for (int y = 0; y < this.height; y++){
                int count = this.__aliveNeighboursCount(x, y);
                Cell cell = this.__getCell(x, y);

                if (count == 3){
                    cell.live();
                    continue;
                }

                if (count < 2 || count > 3) {
                    cell.die();
                }
            }
        }
    }

    public String currentGenerationLayout(){
        this.__saveCurrentCellsState();
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