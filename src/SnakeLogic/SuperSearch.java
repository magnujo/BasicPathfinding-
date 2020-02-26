// Magnus Johannsen EC2 Exam

package SnakeLogic;

/**
 * Class that contains method isGoalReached that all search algorithms need.
 */

public class SuperSearch {

    /**
     *This method returns true if the goal is reached, and moves the rambler to the goal,
     * if it is next to it (is very usefull with DFS).
     */
    public boolean isGoalReached(int[][] maze, Rambler rambler) {
        if (maze[rambler.getX()][rambler.getY()] == 9){
            System.out.println("MAZE SOLVED");
            return true;
        }

        else if(maze[rambler.getX()+1][rambler.getY()]==9){
            rambler.moveEast();
            return true;
        }

        else if(maze[rambler.getX()-1][rambler.getY()]==9){
            rambler.moveWest();
            return true;
        }

        else if(maze[rambler.getX()][rambler.getY()+1]==9){
            rambler.moveSouth();
            return true;
        }

        else if(maze[rambler.getX()][rambler.getY()-1]==9){
            rambler.moveNorth();
            return true;
        }

        return false;
    }

    public boolean isGoalReached(int[][] maze, Rambler rambler, Item goal) {
        if (goal.equals(rambler)){
            System.out.println("MAZE SOLVED");
            return true;
        }

        else if(maze[rambler.getX()+1][rambler.getY()]==9){
            rambler.moveEast();
            return true;
        }

        else if(maze[rambler.getX()-1][rambler.getY()]==9){
            rambler.moveWest();
            return true;
        }

        else if(maze[rambler.getX()][rambler.getY()+1]==9){
            rambler.moveSouth();
            return true;
        }

        else if(maze[rambler.getX()][rambler.getY()-1]==9){
            rambler.moveNorth();
            return true;
        }

        return false;
    }
}
