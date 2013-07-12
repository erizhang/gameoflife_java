import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJUnit {
    @Test
    public void testGameOfLifeDefaultConstructor(){
        GameOfLife game = new GameOfLife(2, 2);
        assertEquals("0000", game.currentGenerationLayout());
    }

    @Test
    public void testGameOfLifeLayoutConstructor(){
        GameOfLife game = new GameOfLife(3, 3, "000010000");
        assertEquals(true, game.findCell(1, 1).isAlive());
    }

    @Test
    public void testLayoutOutput(){
        GameOfLife game = new GameOfLife(3, 3, "001001001");
        String layout = game.currentGenerationLayout();
        assertEquals("001001001", layout);
    }

    @Test
    public void testNextGeneration(){
        GameOfLife game = new GameOfLife(3, 3, "000010000");
        game.nextGeneration();
        String layout = game.currentGenerationLayout();
        assertEquals("000000000", layout);
    }
}