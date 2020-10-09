package InterViewPrep;

import java.util.Queue;
import java.util.LinkedList;

public class ShortestDistanceBtwAllBuildings {

    public static void main(String[] args) {
        int[][] arr = {{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};
        System.out.println(Calculate(arr));
    }

    // idea is to iterate through each buildings
    // and fill the distance and reachable arrays
    // for 0 marked matrix elements
    public static int Calculate(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if(m == 0) return 0;

        int[][] distToAllBuildings = new int[m][n];
        int[][] reachableBuildings = new int[m][n];
        int buildingCount = 0;

        // take building count
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    calcDistToEmptyCells(grid, distToAllBuildings, reachableBuildings, i, j);
                    buildingCount++;
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0 && buildingCount == reachableBuildings[i][j]) {
                    min = Math.min(min, distToAllBuildings[i][j]);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    static int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void calcDistToEmptyCells(int[][] grid, int[][] distToAllBuildings,
                                            int[][] reachableBuildings, int row,
                                            int col) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        q.add(new int[]{ row, col });
        visited[row][col] = true;
        int step = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] vertex = q.poll();
                int r = vertex[0];
                int c = vertex[1];
                distToAllBuildings[r][c] += step;
                reachableBuildings[r][c]++;
                for(int[] dir : dirs) {
                    int nextRow = r + dir[0];
                    int nextCol = c + dir[1];
                    if(nextRow >= 0 && nextRow < grid.length
                            && nextCol >= 0 && nextCol < grid[0].length
                            && !visited[nextRow][nextCol] && grid[nextRow][nextCol] == 0) {
                        q.add(new int[]{ nextRow, nextCol });
                        visited[nextRow][nextCol] = true;
                    }
                }
            }
            step++;
        }
    }
}
