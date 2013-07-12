
public class Cell {
    private int col;
    private int row;
    private boolean live;
    public Cell(int x, int y){
        col = x;
        row = y;
        live = false;
    }

    public boolean isAlive(){
        return live;
    }

    public void die(){
        live = false;
    }

    public void live(){
        live = true;
    }
}

