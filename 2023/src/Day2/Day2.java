package Day2;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Day2 {
    public static boolean isThisLinePossible(String line){
        int num=0;
        for(int i=0;i<line.length();i++){
            if(Character.isDigit(line.charAt(i))){
                num*=10;
                num+=line.charAt(i)-'0';
            }
            else{
                if (num > 14)
                    return false;
                else if (line.charAt(i)!=' '){
                    if (line.charAt(i) == 'r') {
                        if (num > 12)
                            return false;
                        i += 4;
                    } else if (line.charAt(i) == 'g') {
                        if (num > 13)
                            return false;
                        i += 6;
                    } else {
                        i += 5;
                    }
                    num = 0;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        long ans=0;
        int num=1;
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            String[] str = s.split(": ");
            if(isThisLinePossible(str[1])){
                ans+=num;
            }
            num++;
        }
        System.out.println(ans);
    }
}
