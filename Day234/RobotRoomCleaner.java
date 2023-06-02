//package Day234;
//
//import java.awt.*;
//import java.util.HashSet;
//import java.util.Set;
//
//public class RobotRoomCleaner {
//
//    private static final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//    public static void cleanRoom(Robot robot) {
//        moveFrom(0, 0, 0, robot, new HashSet<>());
//    }
//
//    private static void moveFrom(int x, int y, int orientation, Robot robot, Set<String> visited) {
//        //clean current cell
//        robot.clean();
//        visited.add(x + ", " + y);
//        //Try moving forward in 4 directions
//        for (int i = 0; i < 4; i++) {
//            int curOrientation = (i + orientation) % 4;
//            int nx = x + directions[curOrientation][0];
//            int ny = y + directions[curOrientation][1];
//
//            if (!visited.contains(nx + ", " + ny) && robot.move()) {
//                moveFrom(nx, ny, curOrientation, robot, visited);
//                robot.turnRight();
//                robot.turnRight();
//                robot.move();
//                robot.turnLeft();
//                robot.turnLeft();
//            }
//            robot.turnRight();
//        }
//    }
//}
