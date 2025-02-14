package Day11;

import java.util.*;

public class Part2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        List<Long> stones = Arrays.stream(s.split(" "))
                .map(Long::parseLong)
                .toList();
        System.out.println(transformStones(stones,75));
    }
    private static long transformStones(List<Long> stones,int steps){
        Map<Long,Long> map = new HashMap<>();
        for(long stone : stones){
            map.put(stone,map.getOrDefault(stone,0L)+1);
        }
        for(int i=0;i<steps;i++){
            Map<Long,Long> newStones = new HashMap<>();
            for(Map.Entry<Long,Long> entry : map.entrySet()){
                long stone = entry.getKey();
                long count = entry.getValue();
                if(stone==0){
                    newStones.put(1L,newStones.getOrDefault(1,0L)+count);
                }
                else if(countDigits(stone)%2==0){
                    String digits = String.valueOf(stone);
                    int mid = digits.length()/2;
                    long left = Long.parseLong(digits.substring(0,mid));
                    long right = Long.parseLong(digits.substring(mid));
                    newStones.put(left,newStones.getOrDefault(left,0L)+count);
                    newStones.put(right,newStones.getOrDefault(right,0L)+count);
                }
                else {
                    long newStone = stone*2024;
                    newStones.put(newStone,newStones.getOrDefault(newStone,0L)+count);
                }
            }
            map = newStones;
        }
        long total = 0;
        for(long count : map.values())
            total+=count;

        return total;
    }
    private static int countDigits(long n){
        int cnt=0;
        while(n>0){
            cnt++;
            n=n/10;
        }
        return cnt;
    }
}
