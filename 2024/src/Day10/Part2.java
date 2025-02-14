package Day10;

import java.util.*;

public class Part2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            if(!s.isEmpty())
                input.add(s);
        }

        int[][] map = new int[input.size()][input.getFirst().length()];

        for(int i=0;i<input.size();i++){
            for(int j=0;j<input.get(i).length();j++){
                map[i][j] = Integer.parseInt(String.valueOf(input.get(i).charAt(j)));
            }
        }

        int totalRating = calculateTotalRating(map);
        System.out.println("Total Rating: " + totalRating);
    }

    private static int calculateTotalRating(int[][] map) {
        int totalRating = 0;

        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[0].length; col++) {
                if (map[row][col] == 0) {
                    totalRating += calculateTrailheadRating(map, row, col);
                }
            }
        }

        return totalRating;
    }

    private static int calculateTrailheadRating(int[][] map, int startRow, int startCol) {
        int rows = map.length;
        int cols = map[0].length;

        Set<List<int[]>> trails = new HashSet<>();

        Stack<List<int[]>> stack = new Stack<>();
        List<int[]> initialTrail = new ArrayList<>();
        initialTrail.add(new int[]{startRow, startCol});
        stack.push(initialTrail);

        while (!stack.isEmpty()) {
            List<int[]> currentTrail = stack.pop();
            int[] currentPosition = currentTrail.get(currentTrail.size() - 1);
            int currentRow = currentPosition[0];
            int currentCol = currentPosition[1];
            int currentHeight = map[currentRow][currentCol];

            if (currentHeight == 9) {
                trails.add(currentTrail);
                continue;
            }
            for (int[] direction : new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}) {
                int newRow = currentRow + direction[0];
                int newCol = currentCol + direction[1];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                    int newHeight = map[newRow][newCol];
                    if (newHeight == currentHeight + 1) {
                        List<int[]> newTrail = new ArrayList<>(currentTrail);
                        newTrail.add(new int[]{newRow, newCol});
                        stack.push(newTrail);
                    }
                }
            }
        }

        return trails.size();
    }
}
