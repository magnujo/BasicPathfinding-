// Magnus Johannsen EC2 Exam

package SnakeLogic;

import javafx.scene.paint.Color;

/**
 * Items in the "maze"
 */
public class Item {
    protected Color Color;
    private int x;
    private int y;

    public Item(Color color, int x, int y) {
        Color = color;
        this.setX(x);
        this.setY(y);
    }

    public Color getColor() {
        return Color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean equals(Item object){ //could have been used to compare items position
        if(object.getY()==this.y && object.getX()==this.x){
            return true;
        }
        else return false;

    }
}
