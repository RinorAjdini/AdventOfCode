package Day2;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Day2_part2 {
    public static Integer isThisLinePossible(String line){
        int min_r=Integer.MIN_VALUE;
        int min_b=Integer.MIN_VALUE;
        int min_g=Integer.MIN_VALUE;
        int num=0;
        for(int i=0;i<line.length();i++){
            if(Character.isDigit(line.charAt(i))){
                num*=10;
                num+=line.charAt(i)-'0';
            }
            else{
                i++;
                if (line.charAt(i) == 'r') {
                    if(num>min_r)
                        min_r=num;
                    i+=4;
                } else if (line.charAt(i) == 'g') {
                    if(num>min_g)
                        min_g=num;
                        i += 6;
                    } else {
                    if(num>min_b)
                        min_b=num;
                        i += 5;
                    }
                    num = 0;
                }
            }
        return min_r * min_g * min_b;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        long ans=0;
        int num=1;
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            String[] str = s.split(": ");
            ans+=isThisLinePossible(str[1]);
            num++;
        }
        System.out.println(ans);
    }
}
