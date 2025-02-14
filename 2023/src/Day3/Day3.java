package Day3;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day3 {

    public static boolean adjacentToSymbol(char[][] matrix,int row,int first,int last){
      if(row!=0){
          for(int i=first;i<=last;i++){
              if(matrix[row-1][i]!='.' && !Character.isDigit(matrix[row-1][i])){
                  return true;
              }
          }
      }
      if(row!=matrix.length-1){
          for(int i=first;i<=last;i++){
              if(matrix[row+1][i]!='.' && !Character.isDigit(matrix[row+1][i])){
                  return true;
              }
          }
      }
      if(first!=0){
          //top left
          if(row!=0){
              if(matrix[row-1][first-1]!='.' && !Character.isDigit(matrix[row-1][first-1])){
                  return true;
              }
          }
          //bottom left
          if(row!=matrix.length){
              if(matrix[row+1][first-1]!='.' && !Character.isDigit(matrix[row+1][first-1])){
                  return true;
              }
          }
          //left
          if(matrix[row][first-1]!='.' && !Character.isDigit(matrix[row][first-1])){
              return true;
          }
      }
        if(last!=matrix[row].length-1){
            //top right
            if(row!=0){
                if(matrix[row-1][last+1]!='.' && !Character.isDigit(matrix[row-1][last+1])){
                    return true;
                }
            }
            //bottom right
            if(row!=matrix.length-1){
                if(matrix[row+1][last+1]!='.' && !Character.isDigit(matrix[row+1][last+1])){
                    return true;
                }
            }
            //right
            if(matrix[row][last+1]!='.' && !Character.isDigit(matrix[row][last+1])){
                return true;
            }
        }
        return false;
    }
    public static List<Long> function(char [][] matrix){
        long ans=0;
        long num = 0;
        int rin=0; //rrr
        List<Long> list = new ArrayList<>();
        for(int i=0;i<matrix.length;i++){
            int first=0;
            int last=0;
            for(int j=0;j<matrix[i].length;j++){
                if(Character.isDigit(matrix[i][j])){
                    if(num==0) {
                        num += matrix[i][j] - '0';
                        first=j;
                    }
                    else {
                        num*=10;
                        num+=matrix[i][j]-'0';
                    }
                }
                else{
                    if(num!=0)
                    {
                        last=j-1;
                        if(adjacentToSymbol(matrix,i,first,last)){
                            ans+=num;
                            rin++;
                            list.add(num);
                        }
                    }
                    num=0;
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        long ans=0;
        int num=1;
        char [][] matrix = new char[150][150];
        int count = 0;
        StringBuilder sb = new StringBuilder();
        int col = 0;
        int row=0;
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            col=s.length();
            matrix[row]=s.toCharArray();
            row++;
        }
        List<Long> rez = function(matrix);
        for(int i=0;i<rez.toArray().length;i++){
            System.out.printf(rez.get(i)+", ");
        }

    }
}
