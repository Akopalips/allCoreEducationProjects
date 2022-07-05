package core;

import java.sql.SQLOutput;
import java.util.Random;

public class Robot {


    private Direction direction;
    private int x, y;

    public Direction getDirection() {
        return direction;
        // текущее направление взгляда
    }

    public Robot() {
        Random rng = new Random();
        x = rng.nextInt() % 20;
        y = rng.nextInt() % 20;

        switch (Math.abs(rng.nextInt()) % 4) {
            case 0:
                direction = Direction.UP;
                break;
            case 1:
                direction = Direction.DOWN;
                break;
            case 2:
                direction = Direction.LEFT;
                break;
            case 3:
                direction = Direction.RIGHT;
                break;
        }
    }

    public Robot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return x;
        // текущая координата X
    }

    public int getY() {
        return y;
        // текущая координата Y
    }

    public void turnLeft() {
        System.out.println("Left");
        switch (direction) {
            case UP:
                direction = Direction.LEFT;
                break;
            case DOWN:
                direction = Direction.RIGHT;
                break;
            case RIGHT:
                direction = Direction.UP;
                break;
            case LEFT:
                direction = Direction.DOWN;
                break;
        }
        // повернуться на 90 градусов против часовой стрелки
    }

    public void turnRight() {
        System.out.println("Right");
        switch (direction) {
            case UP:
                direction = Direction.RIGHT;
                break;
            case DOWN:
                direction = Direction.LEFT;
                break;
            case RIGHT:
                direction = Direction.DOWN;
                break;
            case LEFT:
                direction = Direction.UP;
                break;
            // повернуться на 90 градусов по часовой стрелке
        }
    }

    public void stepForward() {
        //System.out.println("Forward");
        switch (direction) {
            case UP:
                y++;
                break;
            case DOWN:
                y--;
                break;
            case RIGHT:
                x++;
                break;
            case LEFT:
                x--;
                break;
            // шаг в направлении взгляда
            // за один шаг робот изменяет одну свою координату на единицу
        }
    }
}
