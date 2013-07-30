
public class Cell {
    private int col;
    private int row;
    private boolean live;
    private boolean current_live;
    public Cell(int x, int y){
        col = x;
        row = y;
        live = false;
        current_live = false;
    }

    public boolean isAlive(){
        return current_live;
    }

    public void die(){
        live = false;
    }

    public void live(){
        live = true;
    }

    public void saveState(){
        current_live = live;
    }
}

