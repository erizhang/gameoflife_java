import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJUnit {
    @Test
    public void testAdd() {
        String str= "Junit is working fine";
        assertEquals("Junit is working fine",str);
    }

    @Test
    public void testCell(){
        GameOfLife game = new GameOfLife(2, 2);
        assertEquals(false, game.findCell(1, 1).isAlive());
    }

    @Test
    public void testGameLayout(){
        GameOfLife game = new GameOfLife(3, 3, "000010000");
        assertEquals(true, game.findCell(1, 1).isAlive());
    }

    @Test
    public void testNextGeneration(){
        GameOfLife game = new GameOfLife(3, 3, "000010000");
        game.nextGeneration();
        String layout = game.currentGenerationLayout();
        assertEquals("000000000", layout);
    }
}