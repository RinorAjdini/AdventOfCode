package Day11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Part1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        List<Long> stones = Arrays.stream(s.split(" "))
                .map(Long::parseLong)
                .toList();
        stones = transformStones(stones,75);
        System.out.println(stones.size());
    }
    private static List<Long> transformStones(List<Long> stones,int steps){
        for(int i=0;i<steps;i++){
            ArrayList<Long> newStones = new ArrayList<>();
            for(int j=0;j<stones.size();j++){
                if(stones.get(j) ==0){
                    newStones.add(j, 1L);
                }
                else if(countDigits(stones.get(j))%2==0){
                    newStones.add(getHalfOfTheNumber(stones.get(j),true));
                    newStones.add(getHalfOfTheNumber(stones.get(j),false));
                }
                else{
                    newStones.add(stones.get(j)*2024);
                }
            }
            stones=newStones;
        }
        return stones;
    }
    private static int countDigits(long n){
        int cnt=0;
        while(n>0){
            cnt++;
            n=n/10;
        }
        return cnt;
    }
    private static long getHalfOfTheNumber(long n,boolean first){
        String s= String.valueOf(n);
        int cnt = countDigits(n);
        String firstHalf="";
        if(first) {
            for (int i = 0; i < cnt / 2; i++) {
                firstHalf += s.charAt(i);
            }
        }
        else{
            for(int i=cnt/2;i<cnt;i++){
                firstHalf+=s.charAt(i);
            }
        }
        return Long.parseLong(String.valueOf(firstHalf));
    }
}
