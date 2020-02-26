// Magnus Johannsen EC2 Exam

package SnakeLogic;


/**
 * Class that stores positions.
 */
public class Position{

    private int x;
    private int y;



    public Position (int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public boolean equals(Position position){ //could have been used to compare position
        if(position.getX()==this.x && position.getY()==this.y)
            return true;

        else return false;
    }
}
