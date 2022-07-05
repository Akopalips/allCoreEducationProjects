package core;


public class Core {
    public static void main(String[] args) {
        /*
        System.out.println(Branch.getMaterial());
        Branch oakBranch = new Branch(1, 2);
        System.out.println(oakBranch.getMaterial());
        Branch birchBranch = new Branch(1, 2);
        System.out.println(oakBranch);
        for ( aShit each : aShit.values()){
            System.out.println(each.name());
            System.out.println(each.ordinal());
        }


        Human Oleg = new Human();
        Human Olga = new Human((byte)18, "Olga", "Ansavishna");
        Human Egor = new Human((byte)48, "Egor", "Jelezni", "Golf");
        */
        if (true) {
            for (int i = 0; i < 10; i++) {
                Robot robot = new Robot();
                System.out.println("I look " + robot.getDirection());
                System.out.println(robot.getX());
                System.out.println(robot.getY());
                moveRobot(robot, -1, 1);
                System.out.println(robot.getX());
                System.out.println(robot.getY());
            }
        }
    }

public static void moveRobot(Robot robot, int toX, int toY) {
    int x = robot.getX();
    int y = robot.getY();
    Direction direction = robot.getDirection();
    if (y < toY) {
        turnAndMove(robot, toY - y, Direction.UP);
    }
    if (y > toY) {
        turnAndMove(robot, y - toY, Direction.DOWN);
    }
    if (x > toX) {
        turnAndMove(robot, x - toX, Direction.LEFT);
    }
    if (x < toX) {
        turnAndMove(robot, toX - x, Direction.RIGHT);
    }
}

private static void turnAndMove(Robot robot, int steps, Direction direction) {
    while (robot.getDirection() != direction) {
        if (robot.getDirection().ordinal() % 3 == 0) {
            if (direction.ordinal() % 2 == 0) {
                robot.turnLeft();
            } else {
                robot.turnRight();
            }
        } else {
            if (direction.ordinal() % 2 == 1) {
                robot.turnLeft();
            } else {
                robot.turnRight();
            }
        }
    }
    System.out.println("Forward " + steps);
    for (int iterator = 0; iterator < steps; iterator++) {
        robot.stepForward();
    }
}

    public static void moveRobot_v2(Robot robot, int toX, int toY) {//здеcь прoверка направлeния & развoрот
        boolean[] ifFinishCordsRLess = new boolean[]{toX < robot.getX(), toY < robot.getY()};
        while (toX != robot.getX() || toY != robot.getY()) {
            switch (robot.getDirection()) {
                case UP:
                    if (!ifFinishCordsRLess[1]) {
                        moveY(robot, toY);
                    }
                    if (ifFinishCordsRLess[0]) {
                        robot.turnLeft();
                    } else {
                        robot.turnRight();
                    }
                    break;
                case DOWN:
                    if (ifFinishCordsRLess[1]) {
                        moveY(robot, toY);
                    }
                    if (ifFinishCordsRLess[0]) {
                        robot.turnRight();
                    } else {
                        robot.turnLeft();
                    }
                    break;
                case LEFT:
                    if (ifFinishCordsRLess[0]) {
                        moveX(robot, toX);
                    }
                    if (ifFinishCordsRLess[1]) {
                        robot.turnLeft();
                    } else {
                        robot.turnRight();
                    }
                    break;
                case RIGHT:
                    if (!ifFinishCordsRLess[0]) {
                        moveX(robot, toX);
                    }
                    if (ifFinishCordsRLess[1]) {
                        robot.turnRight();
                    } else {
                        robot.turnLeft();
                    }
                    break;
            }
        }
    }


    private static void moveX(Robot robot, int toX) {//здесь рассчет и движение по х
        int robotX = robot.getX(), countSteps = 0;
        boolean[] isNegativeX = new boolean[]{toX < 0, robotX < 0};

        if (isNegativeX[0] && isNegativeX[1] || !isNegativeX[0] && !isNegativeX[1]) {
            countSteps = Math.abs(toX - robotX);
        } else {
            if (isNegativeX[0]) {
                countSteps = Math.abs(toX) + robotX;
            }
            if (isNegativeX[1]) {
                countSteps = toX + Math.abs(robotX);
            }
        }
        for (int count = 0; count < countSteps; count++) {
            robot.stepForward();
        }
    }

    private static void moveY(Robot robot, int toY) {//здесь рассчет и движение по у
        int robotY = robot.getY(), countSteps = 0;
        boolean[] isNegativeY = new boolean[]{toY < 0, robotY < 0};

        if (isNegativeY[0] && isNegativeY[1] || !isNegativeY[0] && !isNegativeY[1]) {
            countSteps = Math.abs(toY - robotY);
        } else {
            if (isNegativeY[0]) {
                countSteps = Math.abs(toY) + robotY;
            }
            if (isNegativeY[1]) {
                countSteps = toY + Math.abs(robotY);
            }
        }
        for (int count = 0; count < countSteps; count++) {
            robot.stepForward();
        }
    }
}