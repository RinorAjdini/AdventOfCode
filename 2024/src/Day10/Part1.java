package Day10;

import java.util.*;

public class Part1 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    List<String> input = new ArrayList<>();
    while(sc.hasNextLine()){
        String s = sc.nextLine();
        if(s.isEmpty())
            continue;
        input.add(s);
    }
    int[][] matrix = new int[input.size()][input.getFirst().length()];
    for(int i=0;i<matrix.length;i++){
        for(int j=0;j<matrix[0].length;j++){
            matrix[i][j] = Integer.parseInt(String.valueOf(input.get(i).charAt(j)));
        }
    }
    int total=0;
    for(int i=0;i<matrix.length;i++){
        for(int j=0;j<matrix[0].length;j++){
            if(matrix[i][j]==0){
               total+=calculateTrailHeadScore(matrix,i,j);
            }
        }
    }
        System.out.println(total);
    }
    private static int calculateTrailHeadScore(int[][] matrix,int startRow,int startCol){
        int rows = matrix.length;
        int cols = matrix[0].length;
        Set<String> nines = new HashSet<>();
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startRow,startCol});
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int currRow = curr[0];
            int currCol = curr[1];
            if(visited[currRow][currCol])
                continue;
            visited[currRow][currCol]=true;
            for(int[] direction : new int[][]{{1,0},{-1,0},{0,1},{0,-1}}){
                int newRow = currRow + direction[0];
                int newCol = currCol + direction[1];
                if(newRow>=0 && newRow<rows && newCol>=0 && newCol<cols){
                    int currHeight = matrix[currRow][currCol];
                    int newHeight = matrix[newRow][newCol];
                    if(currHeight + 1 ==newHeight){
                        if(newHeight==9)
                            nines.add(newRow+","+newCol);
                        else
                            queue.add(new int[]{newRow,newCol});
                    }
                }
            }
        }
        return nines.size();
    }
}
