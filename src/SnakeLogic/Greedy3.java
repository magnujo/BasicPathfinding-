// Magnus Johannsen EC2 Exam

package SnakeLogic;

import java.util.Stack;

/**
 *Class that contains a greedy search algorithm
 *Will search for goal using a Greedy search algorithm with a stack collection to store position.
 */

public class Greedy3 extends SuperSearch implements GreedyInterface {


    private Stack<Position> isVisited = new Stack<Position>();
    private Maze mazeObject = new Maze();
    private int[][] maze = mazeObject.getMaze();
    private boolean start = true;

    public boolean searchForGoal(Rambler rambler, Item goal){
        //Update the ramblers position
        int ramblerY = rambler.getY();
        int ramblerX = rambler.getX();
        // Position ramblerPosition = new Position(rambler.getX(),rambler.getY()); <--- Could have done this to easier compare positions

        //Update the goals position. Isnt usefull unless the goal moves ofcourse.
        int goalX = goal.getX();
        int goalY = goal.getY();

        //Update the goals distance from rambler.
        int goalDistanceX = goalX - ramblerX;
        int goalDistanceY = goalY - ramblerY;


        //Next positions
        int north = maze[ramblerX][ramblerY-1]%2;
        int south = maze[ramblerX][ramblerY+1]%2;
        int east = maze[ramblerX+1][ramblerY]%2;
        int west = maze[ramblerX-1][ramblerY]%2;

        //I need to add the first position two times, or else the lastY and lastX variables (line 49)
        // will be out of bound on the first update.
        if (start){
            isVisited.push(new Position(ramblerX,ramblerY));
            start = false;
        }


        //Store position
        isVisited.push(new Position(ramblerX,ramblerY));

        //
        int lastY = isVisited.get(isVisited.size() - 2).getY();
        int lastX = isVisited.get(isVisited.size() - 2).getX();


        isGoalReached(maze,rambler);

        if (!isGoalReached(maze,rambler)){


            // goal is north west?

            if (goalDistanceX < 0 && goalDistanceY < 0){
                System.out.println("Searching north west...");



                //Is goal furthes on the y axis?
                if (Math.abs(goalDistanceX) <= Math.abs(goalDistanceY)){

                    //is north clear and not just visited?
                    if(north == 0 && lastY !=ramblerY-1){
                        rambler.moveNorth();
                    }

                    else if (west == 0 && lastX !=ramblerX-1) {
                        rambler.moveWest();
                    }
                }

                else{
                    //is west clear and not just visitied?

                    if (west == 0 && lastX !=ramblerX-1) {
                        rambler.moveWest();
                    }

                    else if(north == 0 && lastY !=ramblerY-1){
                        rambler.moveNorth();
                    }
                }

                //is west and north not clear?
                if (west == 1 && north == 1){

                    //Is goal furthes from rambler on the Y-axis (north)? Then DONT move further away (south) but move east.
                    if (Math.abs(goalDistanceX) <= Math.abs(goalDistanceY)){
                        if (east == 0 && lastX !=ramblerX+1){
                            rambler.moveEast();
                        }
                        else{rambler.moveSouth();}
                    }

                    //Is goal furthes from rambler on the X-axis (west)? Then DONT move further away (east) but move south.
                    else if (Math.abs(goalDistanceY) <= Math.abs(goalDistanceX)){
                        if (south == 0 && lastY !=ramblerY+1){
                            rambler.moveSouth();
                        }
                        else{rambler.moveEast();}
                    }
                }
            }

//--------------------------------------------------------------------------------------------------------------------------------------------

            // goal is north east?
            if (goalDistanceX > 0 && goalDistanceY < 0){
                System.out.println("Searching north east...");


                //Is goal furthes on the y axis?
                if (Math.abs(goalDistanceX) <= Math.abs(goalDistanceY)){

                    //is north clear and not just visited?
                    if(north == 0 && lastY !=ramblerY-1){
                        rambler.moveNorth();
                    }

                    else if (east == 0 && lastX !=ramblerX+1) {
                        rambler.moveEast();
                    }
                }
                else{
                    //is west clear and not just visitied?

                    if (east == 0 && lastX !=ramblerX+1) {
                        rambler.moveEast();
                    }

                    else if(north == 0 && lastY !=ramblerY-1){
                        rambler.moveNorth();
                    }
                }

                //is east and north not clear?
                if (east == 1 && north == 1){

                    if (Math.abs(goalDistanceX) <= Math.abs(goalDistanceY)){
                        if (west == 0 && lastX !=ramblerX-1){
                            rambler.moveWest();
                        }
                        else{rambler.moveSouth();}
                    }

                    //Is goal furthes from rambler on the X-axis (west)? Then DONT move further away (east) but move south.
                    else if (Math.abs(goalDistanceY) <= Math.abs(goalDistanceX)){
                        if (south == 0 && lastY !=ramblerY+1){
                            rambler.moveSouth();
                        }
                        else{rambler.moveWest();}
                    }
                }
            }

//---------------------------------------------------------------------------------------------------------------------------------------------

            //goal is south west?
            if (goalDistanceX < 0 && goalDistanceY > 0){
                System.out.println("Searching south west...");


                //Is goal furthes on the y axis?
                if (Math.abs(goalDistanceX) <= Math.abs(goalDistanceY)){

                    //is north clear and not just visited?
                    if(south == 0 && lastY !=ramblerY+1){
                        rambler.moveSouth();
                    }

                    else if (west == 0 && lastX !=ramblerX-1) {
                        rambler.moveWest();
                    }
                }
                else{
                    //is west clear and not just visitied?

                    if (west == 0 && lastX !=ramblerX-1) {
                        rambler.moveWest();
                    }

                    else if(south == 0 && lastY !=ramblerY+1){
                        rambler.moveSouth();
                    }
                }

                //is west and south not clear?
                if (west == 1 && south == 1){

                    if (Math.abs(goalDistanceX) <= Math.abs(goalDistanceY)){
                        if (east == 0 && lastX !=ramblerX+1){
                            rambler.moveEast();
                        }
                        else{rambler.moveNorth();}
                    }

                    //Is goal furthes from rambler on the X-axis (west)? Then DONT move further away (east) but move south.
                    else if (Math.abs(goalDistanceY) <= Math.abs(goalDistanceX)){
                        if (north == 0 && lastY !=ramblerY-1){
                            rambler.moveNorth();
                        }
                        else{rambler.moveEast();}
                    }
                }
            }

//-------------------------------------------------------------------------------------------------------------------------------------------

            //goal is south east?
            if (goalDistanceX > 0 && goalDistanceY > 0){
                System.out.println("Searching south east...");


                //Is goal furthes on the y axis?
                if (Math.abs(goalDistanceX) <= Math.abs(goalDistanceY)){

                    //is north clear and not just visited?
                    if(south == 0 && lastY !=ramblerY+1){
                        rambler.moveSouth();
                    }

                    else if (east == 0 && lastX !=ramblerX+1) {
                        rambler.moveEast();
                    }
                }
                else{
                    //is west clear and not just visitied?

                    if (east == 0 && lastX !=ramblerX+1) {
                        rambler.moveEast();
                    }

                    else if(south == 0 && lastY !=ramblerY+1){
                        rambler.moveSouth();
                    }
                }

                //is east and south not clear?
                if (east == 1 && south == 1){

                    if (Math.abs(goalDistanceX) <= Math.abs(goalDistanceY)){
                        if (west == 0 && lastX !=ramblerX-1){
                            rambler.moveWest();
                        }
                        else{rambler.moveNorth();}
                    }

                    //Is goal furthes from rambler on the X-axis (west)? Then DONT move further away (east) but move south.
                    else if (Math.abs(goalDistanceY) <= Math.abs(goalDistanceX)){
                        if (north == 0 && lastY !=ramblerY-1){
                            rambler.moveNorth();
                        }
                        else{rambler.moveWest();}
                    }
                }
            }

//-------------------------------------------------------------------------------------------------------------------------------------------

            //goal is south?
            if (goalDistanceX == 0 && goalDistanceY > 0){
                System.out.println("Searching south...");

                //is south clear and not just visited?
                if(south == 0 && lastY !=ramblerY+1){
                    rambler.moveSouth();
                }

                if (south==1){
                    if(east == 0 && lastX !=ramblerX+1){
                        rambler.moveEast();
                    }

                    else if(west == 0 && lastX !=ramblerX-1){
                        rambler.moveWest();
                    }
                }
            }

//-------------------------------------------------------------------------------------------------------------------------------------------


            //goal is north?
            if (goalDistanceX == 0 && goalDistanceY < 0){
                System.out.println("Searching north...");



                if(north == 0 && lastY !=ramblerY-1){
                    rambler.moveNorth();
                }

                if (north==1){
                    if(east == 0 && lastX !=ramblerX+1){
                        rambler.moveEast();
                    }

                    else if(west == 0 && lastX !=ramblerX-1){
                        rambler.moveWest();
                    }
                }
            }

//-------------------------------------------------------------------------------------------------------------------------------------------


            //goal is east?
            if (goalDistanceX > 0 && goalDistanceY == 0){
                System.out.println("Searching east...");



                if(east == 0 && lastX !=ramblerX+1){
                    rambler.moveEast();
                }

                if (east==1){
                    if(north == 0 && lastY !=ramblerY-1){
                        rambler.moveNorth();
                    }

                    else if(south == 0 && lastY !=ramblerY+1){
                        rambler.moveSouth();
                    }
                }
            }



//-------------------------------------------------------------------------------------------------------------------------------------------



            //goal is west?
            if (goalDistanceX < 0 && goalDistanceY == 0){
                System.out.println("Searching west...");


                if(west == 0 && lastX !=ramblerX-1){
                    rambler.moveWest();
                }

                if (west==1){
                    if(north == 0 && lastY !=ramblerY-1){
                        rambler.moveNorth();
                    }

                    else if(south == 0 && lastY !=ramblerY+1){
                        rambler.moveSouth();
                    }
                }
            }
        }
        maze[ramblerX][ramblerY]=1;

        return true;
    }
}
