// Magnus Johannsen EC2 Exam

package SnakeGUI;


import SnakeLogic.*;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.*;

public class Controller {

    @FXML
    Canvas canvas;

    private double fieldHeight;
    private double fieldWidth;
    private int width = 15;
    private int height = 11;
    private float refreshRate =500;

    private Random random = new Random();
    private Maze maze = new Maze();
    private ArrayList<Item> items = new ArrayList<Item>();
    private ArrayList<Item> validPath = new ArrayList<>();
    private ArrayList<Item> startingPoints = new ArrayList<>();
    private ArrayList<Wall> walls = new ArrayList<Wall>();
    private Rambler rambler1 = new Rambler(Color.RED,1,1);
    private Rambler rambler2 = new Rambler(Color.GREEN,1,1);
    private Rambler rambler3 = new Rambler(Color.BLUE,1,1);
    private Item goal = new Item(Color.YELLOW,1,1);


    private Greedy greedy = new Greedy();
    private Greedy3 greedy3 = new Greedy3();
    private DepthFirst depthFirst = new DepthFirst();

    public void btnStartAction(ActionEvent event)
    {

        int randomIndex =  random.nextInt(validPath.size());
        goal.setY(validPath.get(randomIndex).getY());
        goal.setX(validPath.get(randomIndex).getX());
        drawCanvas();
    }


    public void initialize()
    {
        AddItems();
        calculateFields();

        // Start and control game loop
        new AnimationTimer(){
            long lastUpdate;
            public void handle (long now)
            {
                if (now > lastUpdate + refreshRate * 1000000)
                {
                    lastUpdate = now;
                    update(now);
                }             }
        }.start();
    }


    private void AddItems() {

        maze.addItems(walls,startingPoints,goal,validPath);

        rambler1.setX(startingPoints.get(0).getX());
        rambler1.setY(startingPoints.get(0).getY());
        rambler2.setX(startingPoints.get(1).getX());
        rambler2.setY(startingPoints.get(1).getY());
        rambler3.setX(startingPoints.get(2).getX());
        rambler3.setY(startingPoints.get(2).getY());
    }

    private void update(long now)
    {

        drawCanvas();
        depthFirst.searchForGoal(rambler2);
        greedy.searchForGoal(rambler1,goal);
        greedy3.searchForGoal(rambler3,goal);

    }

    private void calculateFields() {
        this.fieldHeight = canvas.getHeight() / this.height;
        this.fieldWidth = canvas.getWidth() / this.width;
    }

    private void drawCanvas() {
        GraphicsContext g = canvas.getGraphicsContext2D();

        g.clearRect(0,0,width*fieldWidth ,height*fieldHeight);

        for (Item path : validPath)
        {
            g.setFill(path.getColor());
            g.fillRoundRect(path.getX() * fieldWidth, path.getY() * fieldHeight, fieldWidth, fieldHeight, 5,5);
        }


        for (Item item : items)
        {
            g.setFill(item.getColor());
            g.fillRoundRect(item.getX() * fieldWidth, item.getY() * fieldHeight, fieldWidth, fieldHeight, 5,5);
        }

        for (Item wall : walls)
        {
            g.setFill(wall.getColor());
            g.fillRoundRect(wall.getX() * fieldWidth, wall.getY() * fieldHeight, fieldWidth, fieldHeight, 5,5);
        }

        for (Item start : startingPoints)
        {
            g.setFill(start.getColor());
            g.fillRoundRect(start.getX() * fieldWidth, start.getY() * fieldHeight, fieldWidth, fieldHeight, 5,5);
        }


        g.setFill(goal.getColor());
        g.fillRoundRect(this.goal.getX() * fieldWidth, this.goal.getY() * fieldHeight, fieldWidth, fieldHeight, 3, 3);

        g.setFill(rambler1.getColor());
        g.fillRoundRect(this.rambler1.getX() * fieldWidth, this.rambler1.getY() * fieldHeight, fieldWidth, fieldHeight, 3, 3);

        g.setFill(rambler2.getColor());
        g.fillRoundRect(this.rambler2.getX() * fieldWidth, this.rambler2.getY() * fieldHeight, fieldWidth, fieldHeight, 3, 3);

        g.setFill(rambler3.getColor());
        g.fillRoundRect(this.rambler3.getX() * fieldWidth, this.rambler3.getY() * fieldHeight, fieldWidth, fieldHeight, 3, 3);
    }
}
