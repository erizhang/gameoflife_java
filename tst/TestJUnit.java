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
}