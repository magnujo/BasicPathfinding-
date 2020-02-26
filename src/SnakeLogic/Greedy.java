// Magnus Johannsen EC2 Exam

package SnakeLogic;

/**
 *  Class that contains a greedy search algorithm. The algorithm uses booleans to not get stuck.
 *  It never moves in a direction opposite, of the direction it is moving,
 *  unless no other option is available.
 */

public class Greedy extends SuperSearch implements GreedyInterface {

    private boolean searchingX;
    public boolean searchingY;
    private boolean movingEast = false;
    private boolean movingNorth = false;
    private boolean movingSouth = false;
    private boolean movingWest = false;
    private Maze mazeObject = new Maze();
    private int[][] maze = mazeObject.getMaze();


    public boolean searchForGoal(Rambler rambler, Item goal) {
        //Update the ramblers position
        int ramblerY = rambler.getY();
        int ramblerX = rambler.getX();
        // Position ramblerPosition = new Position(rambler.getX(),rambler.getY()); <--- Could have done this to easier compare positions

        //Update the goals position. Isnt usefull unless the goal moves.
        int goalX = goal.getX();
        int goalY = goal.getY();

        //Update the goals distance from rambler. In this case it is only used to determine whether it is negative or positive
        int goalDistanceX = goalX - ramblerX;
        int goalDistanceY = goalY - ramblerY;

        int south = maze[ramblerX][ramblerY + 1]%2;
        int east = maze[ramblerX + 1][ramblerY]%2;
        int west = maze[ramblerX - 1][ramblerY]%2;
        int north = maze[ramblerX][ramblerY - 1]%2;


        isGoalReached(maze,rambler);

        if (!isGoalReached(maze,rambler)) {

            //First it tries to find the correct y position
            if (ramblerY != goalY && searchingX == false) {
                System.out.println("-----------------------");
                System.out.println("Searching Y...");
                searchingY = true;
                movingWest = false;
                movingEast = false;
                movingNorth = false;
                movingSouth = false;

                if (goalDistanceY > 0) {
                    System.out.println("Goal is south...");

                    if (south == 0) {
                        rambler.moveSouth();
                        System.out.println("Moving south...");
                        movingSouth = true;
                        movingEast = false;
                        movingWest = false;
                    }

                    else if (east == 0 && movingWest == false) {
                        rambler.moveEast();
                        System.out.println("Moving east...");
                        movingEast = true;
                    }

                    else if (west == 0) {
                        rambler.moveWest();
                        System.out.println("Moving west...");
                        movingEast = false;
                        movingWest = true;
                    }
                }

                if (goalDistanceY < 0) {
                    System.out.println("Goal is north");

                    if (north == 0) {
                        rambler.moveNorth();
                        System.out.println("Moving north...");
                        movingNorth = true;
                        movingEast = false;
                        movingWest = false;
                    }

                    else if (west == 0 && movingEast == false) {
                        rambler.moveWest();
                        System.out.println("Moving west...");
                        movingWest = true;
                    }

                    else if (east == 0) {
                        rambler.moveEast();
                        System.out.println("Moving east...");
                        movingEast = true;
                        movingWest = false;
                    }

                }
            }

            // Then it tries to find x
            else if (ramblerX != goalX) {
                System.out.println("----------------");
                System.out.println("searching X...");
                searchingX = true;
                movingWest = false;
                movingEast = false;

                if (goalDistanceX > 0) {
                    System.out.println("goal is east");

                    if (east == 0) {
                        movingNorth = false;
                        movingSouth = false;
                        movingWest = false;
                        movingEast = true;
                        rambler.moveEast();
                        System.out.println("moving east...");
                    }

                    else if (north == 0 && movingSouth == false) {
                        rambler.moveNorth();
                        movingNorth = true;
                        System.out.println("moving north...");
                    }

                    else if (south == 0) {
                        movingNorth = false;
                        rambler.moveSouth();
                        movingSouth = true;
                        System.out.println("moving south...");
                    }
                    else rambler.moveNorth();
                }

                if (goalDistanceX < 0) {
                    System.out.println("goal is west");

                    if (west == 0) {
                        rambler.moveWest();
                        movingSouth = false;
                        movingNorth = false;
                        movingWest = true;
                        System.out.println("Moving west...");
                    }

                    else if (south == 0 && movingNorth == false) {
                        rambler.moveSouth();
                        movingSouth = true;
                        System.out.println("Moving south...");
                    }

                    else if (north == 0) {
                        rambler.moveNorth();
                        movingNorth = true;
                        movingSouth = false;
                        System.out.println("Moving north...");
                    }

                    else rambler.moveSouth();
                }
            }
            else searchingX = false;
        }
        return false;
    }
}