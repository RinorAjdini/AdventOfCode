package Day3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long res = 0;
        boolean b = true;
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            for(int i=0;i<s.length()-8;i++){
                if(b){
                    if(s.substring(i,i+7).equals("don't()")){
                        b=false;
                        i+=7;
                        continue;
                    }
                    if(s.substring(i,i+4).equals("mul(")){
                        String sx="";
                        String sy="";
                        int x=0,y=0;
                        int j=i+4;
                        while(!s.substring(j,j+1).equals(",")){
                            sx+=s.substring(j,j+1);
                            j++;
                        }
                        j++;
                        while(!s.substring(j,j+1).equals(")")){
                            sy+=s.substring(j,j+1);
                            j++;
                        }
                        try{
                            x=Integer.parseInt(sx);
                        } catch (NumberFormatException e){
                            continue;
                        }
                        try{
                            y=Integer.parseInt(sy);
                        } catch (NumberFormatException e){
                            continue;
                        }
                        res+=x*y;
                    }
                }
                else if(s.substring(i,i+4).equals("do()")){
                    b=true;
                    i+=4;
                }
            }
        }
        System.out.println(res);
    }
}