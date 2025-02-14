package Day6;

import java.util.ArrayList;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long res = 0;
        char[][] matrix = new char[150][150];
        int startx=0,starty=0;
        int a=0;
        boolean findStart=false;
        int direction=3;
        int b=0;

        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if(a==0)
                b=s.length();
            if(s.isEmpty())
                break;
            for (int i = 0; i < s.length(); i++) {
                matrix[a][i]=s.charAt(i);
                if (!findStart) {
                    if (s.charAt(i) == '>' || s.charAt(i) == 'v' || s.charAt(i) == '^' || s.charAt(i) == '<') {
                        if (s.charAt(i) == '^') {
                            direction = 0;
                        } else if (s.charAt(i) == '>') {
                            direction = 1;
                        } else if (s.charAt(i) == 'v') {
                            direction = 2;
                        }
                        findStart = true;
                        startx = a;
                        starty = i;
                    }
                }
            }
            a++;
        }
        // 0 - up   1 - right  2 - down  3 - left
        int sx=startx,sy=starty;
        boolean endit=false;
        int cnt=1;
        int i=0,j=0;
        matrix[sx][sy]='R';
        while((sx!=0 && direction==0) || (sy!=b-1 && direction==1 ) || (sx!=b-1 && direction==2) || (sy!=0 && direction==3)){
            if(direction==0){
                for(i=sx-1;i>=0;i--){
                    if(matrix[i][sy]=='#'){
                        direction=1;
                        break;
                    }
                    else if(matrix[i][sy]=='.'){
                        matrix[i][sy]='R';
                        cnt++;
                    }
//                    else if(matrix[i][sy]=='R'){
//                        endit=true;
//                        break;
//                    }
                }
                sx=i+1;

            }
            else if(direction==1){
                for(j=sy+1;j<b;j++){
                    if(matrix[sx][j]=='#'){
                        direction=2;
                        break;
                    }
                    else if(matrix[sx][j]=='.'){
                        matrix[sx][j]='R';
                        cnt++;
                    }
//                    else if(matrix[sx][j]=='R'){
//                        endit=true;
//                        break;
//                    }
                }
                sy=j-1;
            }
            else if(direction==2){
                for(i=sx+1;i<b;i++){
                    if(matrix[i][sy]=='#'){
                        direction=3;
                        break;
                    }
                    else if(matrix[i][sy]=='.'){
                        matrix[i][sy]='R';
                        cnt++;
                    }
//                    else if(matrix[i][sy]=='R'){
//                        endit=true;
//                        break;
//                    }
                }
                sx=i-1;
            }
            else if(direction==3){
                for(j=sy-1;j>=0;j--){
                    if(matrix[sx][j]=='#'){
                        direction=0;
                        break;
                    }
                    else if(matrix[sx][j]=='.'){
                        matrix[sx][j]='R';
                        cnt++;
                    }
//                    else if(matrix[sx][j]=='R'){
//                        endit=true;
//                        break;
//                    }
                }
                sy=j+1;
            }
            if(endit)
                break;
        }
        System.out.println(cnt);
        for(int k=0;k<a;k++){
            for(int p=0;p<b;p++){
                System.out.print(matrix[k][p]);
            }
            System.out.println();
        }
    }
}
