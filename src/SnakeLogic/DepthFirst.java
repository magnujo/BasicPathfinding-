// Magnus Johannsen EC2 Exam

package SnakeLogic;

import java.util.Stack;

/**
 *Class containing DFS algorithm using collection.
 */

public class    DepthFirst extends SuperSearch {
    //Stack containing the visited positions
    private Stack<Position> visited = new Stack<>();
    private Maze mazeObject = new Maze();
    private int[][] maze = mazeObject.getMaze();

    public boolean searchForGoal(Rambler rambler) {

        //Update the different positions:
        int ramblerX = rambler.getX();
        int ramblerY = rambler.getY();
        int north = maze[ramblerX][ramblerY-1];
        int south = maze[ramblerX][ramblerY+1];
        int east = maze[ramblerX+1][ramblerY];
        int west = maze[ramblerX-1][ramblerY];
        visited.push(new Position(ramblerX,ramblerY));


        isGoalReached(maze, rambler);

        if (!isGoalReached(maze, rambler)) {

            if (east%2 == 0) {
                rambler.moveEast();
            }

            else if (west%2 == 0) {
                rambler.moveWest();
            }

            else if (south%2 == 0) {
                rambler.moveSouth();
            }

            else if (north%2 == 0) {
                rambler.moveNorth();
            }

            else{
                rambler.setX(visited.get(visited.size()-2).getX());
                rambler.setY(visited.get(visited.size()-2).getY());
                visited.pop();
                visited.pop();
            }

            maze[rambler.getX()][rambler.getY()] = 1;
        }
        return true;
    }
}