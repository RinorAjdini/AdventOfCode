package Day6;


import java.util.*;

public class Part2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        while(sc.hasNextLine()){
            input.add(sc.nextLine());
        }
        char[][] matrix = new char[input.size()][input.getFirst().length()];
        for(int i=0;i<input.size();i++){
            matrix[i]=input.get(i).toCharArray();
        }
        DaySixPartTwo(matrix);
    }
    private static void DaySixPartTwo(char[][] matrix){
        int x=0,y=0;
        boolean find=false;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]=='^'){
                    matrix[i][j]='.';
                    x=i-1;
                    y=j;
                    find=true;
                    break;
                }
                if(find)
                    break;
            }
        }
        stuckInLoop(matrix,x,y);
    }
    private static void stuckInLoop(char[][] matrix,int x,int y){
        int cnt=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(i==x && j==y){
                    continue;
                }
                if(matrix[i][j]=='.'){
                    matrix[i][j]='#';
                    cnt+=checkLoop(matrix,x,y) ? 1 : 0;
                    matrix[i][j]='.';
                }
            }
        }
        System.out.println(cnt);
    }

    private static boolean checkLoop(char[][] matrix,int x, int y){
        Set<String> visited = new HashSet<>();
        String direction="U";
        visited.add(x+" "+y+" "+direction);
        while(true){
            if(x<0 || x>=matrix.length || y<0 || y>=matrix[0].length)
                break;
            if(matrix[x][y]=='#'){
                switch (direction){
                    case "U":
                        direction="R";
                        x+=1;
                        y+=1;
                        break;
                    case "R":
                        direction="D";
                        x+=1;
                        y-=1;
                        break;
                    case "D":
                        direction="L";
                        x-=1;
                        y-=1;
                        break;
                    case "L":
                        direction="U";
                        x-=1;
                        y+=1;
                        break;
                }
            }
            if(x<0 || x>=matrix.length || y<0 || y>=matrix[0].length)
                break;
            if(matrix[x][y]=='.'){
                switch (direction){
                    case "U":
                        x-=1;
                        break;
                    case "R":
                        y+=1;
                        break;
                    case "D":
                        x+=1;
                        break;
                    case "L":
                        y-=1;
                        break;
                }
            }
            if(visited.contains(x+" "+y+" "+direction))
                return true;
            visited.add(x+" "+y+" "+direction);
        }
        return false;
    }

}