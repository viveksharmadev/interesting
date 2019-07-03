// https://leetcode.com/problems/robot-room-cleaner/
/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */
 /*Time complexity : O(4^N−M), where N is a number of cells in the room and M is a number of obstacles, because for each cell the algorithm checks 4 directions.

Space complexity : O(N−M), where N is a number of cells in the room and M is a number of obstacles, to track visited cells
*/
class robot-room-cleaner {
    // Make sure dirs are aligned to logic
    int[][] dirs = {{0,1}, {1,0},{0,-1},{-1,0}};
    public void cleanRoom(Robot robot) {
        cleanWholeRoom(robot, 0, 0, 0, new HashSet<String>());
    }
    
    private void cleanWholeRoom(Robot robot, int x, int y, 
                                int index, Set<String> visited){
        String path = x+"-"+y;// make sure some string in between else backtracking would cause problem, we have to make the paths distinct ex: 103 can be either 1-03 or 10-3 so need something in between
        if(visited.contains(path)) return;
        visited.add(path);
        robot.clean();
        for(int i=0; i<4; i++){
            if(robot.move()){
                int xx = x+dirs[index][0];
                int yy = y+dirs[index][1];
                cleanWholeRoom(robot, xx, yy, index, visited);
                // Back, move is because of robot is hardware, have to manually move it forward to go back to explore other directions of cleaning
                robot.turnLeft();
                robot.turnLeft();
                robot.move();
                robot.turnLeft();
                robot.turnLeft();
            }
            robot.turnRight();
            index = (index+1)%4;
        }
    }
}
