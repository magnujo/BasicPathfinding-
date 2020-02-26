// Magnus Johannsen EC2 Exam

package SnakeLogic;

import javafx.scene.paint.Color;

import java.util.List;

public class Maze {

    private int[][] maze = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 2, 4, 2, 2, 2, 2, 2, 2, 4, 1},
            {1, 4, 1, 2, 1, 1, 1, 2, 1, 2, 1},
            {1, 2, 1, 2, 2, 1, 2, 2, 1, 2, 1},
            {1, 2, 1, 2, 4, 4, 2, 2, 1, 2, 1},
            {1, 2, 2, 1, 1, 2, 1, 1, 2, 2, 1},
            {1, 1, 2, 1, 2, 9, 2, 1, 2, 1, 1},
            {1, 1, 2, 2, 4, 1, 2, 2, 2, 1, 1},
            {1, 1, 2, 1, 2, 2, 4, 1, 2, 1, 1},
            {1, 2, 2, 1, 1, 2, 1, 1, 2, 2, 1},
            {1, 2, 1, 2, 2, 2, 2, 2, 1, 2, 1},
            {1, 2, 1, 2, 2, 1, 2, 2, 1, 2, 1},
            {1, 2, 1, 2, 1, 1, 1, 2, 1, 2, 1},
            {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
    };

    public int[][] getMaze() {
        return this.maze;
    }



    public boolean addItems(List<Wall> walls, List<Item> startingPoints, Item goal, List<Item> validPath) {
        for (int row = 0; row < maze.length; row++) {
            for (int column = 0; column < maze[0].length; column++) {
                switch (maze[row][column]) {
                    case 2:
                        validPath.add(new Item(Color.WHITE,row,column));
                        break;
                    case 1:
                        walls.add(new Wall(Color.GREY, row, column));
                        break;
                    case 4:
                        startingPoints.add(new Item(Color.WHITE,row,column));
                        break;
                    case 9:
                        goal.setX(row);
                        goal.setY(column);
                }
            }
        }
        return true;
    }
}
