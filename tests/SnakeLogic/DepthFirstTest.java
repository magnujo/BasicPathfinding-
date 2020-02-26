// Magnus Johannsen EC2 Exam

package SnakeLogic;

import javafx.scene.paint.Color;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DepthFirstTest {
DepthFirst depthFirst;

    @Before
    public void setUp() throws Exception {
        depthFirst = new DepthFirst();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void searchForGoal() {
        Rambler rambler = new Rambler(Color.GREEN,1,1);
        assertEquals(depthFirst.searchForGoal(rambler),true);
    }
}