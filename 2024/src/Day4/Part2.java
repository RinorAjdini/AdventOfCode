package Day4;

import java.util.Scanner;

public class Part2 {

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
                if(i+2<r && j+2<c && g[i][j]=='M' && g[i+1][j+1]=='A' && g[i+2][j+2]=='S' && g[i+2][j]=='M' && g[i][j+2]=='S')
                    cnt++;
                if(i+2<r && j+2<c && g[i][j]=='M' && g[i+1][j+1]=='A' && g[i+2][j+2]=='S' && g[i+2][j]=='S' && g[i][j+2]=='M')
                    cnt++;
                if(i+2<r && j+2<c && g[i][j]=='S' && g[i+1][j+1]=='A' && g[i+2][j+2]=='M' && g[i+2][j]=='M' && g[i][j+2]=='S')
                    cnt++;
                if(i+2<r && j+2<c && g[i][j]=='S' && g[i+1][j+1]=='A' && g[i+2][j+2]=='M' && g[i+2][j]=='S' && g[i][j+2]=='M')
                    cnt++;
            }
        }
        System.out.println(cnt);
    }
}
