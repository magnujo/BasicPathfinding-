// Magnus Johannsen EC2 Exam

package SnakeLogic;

import javafx.scene.paint.Color;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RamblerTest {
    Rambler rambler;
    @Before
    public void setUp() throws Exception {
        rambler = new Rambler(Color.GREEN,1,1);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void moveNorth() {
        assertEquals(rambler.moveNorth(),true);
    }

    @Test
    public void moveSouth() {
        assertEquals(rambler.moveSouth(),true);

    }

    @Test
    public void moveEast() {
        assertEquals(rambler.moveEast(),true);

    }

    @Test
    public void moveWest() {
        assertEquals(rambler.moveWest(),true);

    }
}