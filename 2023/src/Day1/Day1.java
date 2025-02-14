package Day1;

import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.Scanner;

public class Day1 {
    public static Integer findFirstDigitOfTheLine(String line , boolean b){
        String [] numbers = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        String [] numbers_reversed = {"orez","eno","owt","eerht","ruof","evif","xis","neves","thgie","enin"};
        int num;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<line.length();i++){
            sb.append(line.charAt(i));
            for(int j=0;j<10 && sb.toString().length()>2;j++){
                if(b) {
                    if (sb.toString().contains(numbers[j])) {
                        return j;
                    }
                }
                else{
                    if (sb.toString().contains(numbers_reversed[j])) {
                        return j;
                    }
                }
            }
            if(Character.isDigit(line.charAt(i))){
                return line.charAt(i)-'0';
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        long ans=0;
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            long num=0;
            num=findFirstDigitOfTheLine(s,true);
            num*=10;
            StringBuilder sb = new StringBuilder();
            sb.append(s);
            sb.reverse();
            num+=findFirstDigitOfTheLine(sb.toString(),false);
            ans+=num;
        }
        System.out.println(ans);
    }
}
