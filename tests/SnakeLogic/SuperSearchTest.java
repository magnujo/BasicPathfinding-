// Magnus Johannsen EC2 Exam

package SnakeLogic;

import javafx.scene.paint.Color;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SuperSearchTest {
    SuperSearch superSearch;

    @Before
    public void setUp() throws Exception {
        superSearch = new SuperSearch();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isGoalReached() {
        Maze mazeObject = new Maze();
        Item goal = new Item(Color.YELLOW,1,1);
        int[][] maze = mazeObject.getMaze();
        Rambler rambler = new Rambler(Color.GREEN,1,1);
        assertTrue(superSearch.isGoalReached(maze,rambler,goal));

    }
}