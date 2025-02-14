package Day4;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class Part1 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            char[][] g = new char[150][150];
            int a = 0;
            int cnt = 0;
            while (sc.hasNextLine()) {
                String s = sc.nextLine();
                for(int i=0;i<s.length();i++){
                    g[a][i]=s.charAt(i);
                }
                a++;
            }
            int r = g.length;
            int c = g[0].length;
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                   if(g[i][j]=='X'){
                       //down
                       if(i+3<r && g[i+1][j]=='M' && g[i+2][j]=='A' && g[i+3][j]=='S')
                           cnt++;
                       //right
                       if(j+3<c && g[i][j+1]=='M' && g[i][j+2]=='A' && g[i][j+3]=='S')
                           cnt++;
                       //up
                       if(i-3>=0 && g[i-1][j]=='M' && g[i-2][j]=='A' && g[i-3][j]=='S')
                           cnt++;
                       //left
                       if(j-3>=0 && g[i][j-1]=='M' && g[i][j-2]=='A' && g[i][j-3]=='S')
                           cnt++;
                       //down-right
                       if(i+3<r && j+3<c && g[i+1][j+1]=='M' && g[i+2][j+2]=='A' && g[i+3][j+3]=='S')
                           cnt++;
                       //down-left
                       if(i+3<r && j-3>=0 && g[i+1][j-1]=='M' && g[i+2][j-2]=='A' && g[i+3][j-3]=='S')
                           cnt++;
                       //up-left
                       if(i-3>=0 && j-3>=0 && g[i-1][j-1]=='M' && g[i-2][j-2]=='A' && g[i-3][j-3]=='S')
                           cnt++;
                       //up-right
                       if(i-3>=0 && j+3<c && g[i-1][j+1]=='M' && g[i-2][j+2]=='A' && g[i-3][j+3]=='S')
                           cnt++;
                   }
                }
            }
            System.out.println(cnt);
        }
}

