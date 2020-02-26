// Magnus Johannsen EC2 Exam

package SnakeLogic;


/**
 * This is rambler (ghost) class. In the class is methods that moves to new positions the ghost.
 */


public class Rambler extends Item {


    public Rambler(javafx.scene.paint.Color color, int x, int y) {
        super(color, x, y);
    }


    public boolean moveNorth() {
        setY(getY() - 1);
       //System.out.println("Moving north");
        return true;
    }


    public boolean moveSouth() {
        setY(getY() + 1);
       // System.out.println("Moving south");
        return true;
    }


    public boolean moveEast() {
       // System.out.println("moving east");
        setX(getX()+1);
        return true;
    }


    public boolean moveWest() {
      //  System.out.println("moving west");
        setX(getX()-1);
        return true;
    }
}
