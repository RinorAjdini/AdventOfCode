package Day9;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Day9_part2 {
    public static boolean checkTheArrayIsZero(List<Integer> arr){
        for(Integer i : arr){
            if(i!=0)
                return false;
        }
        return true;
    }
    public static long increment (List<Integer> arr){
        long ans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(arr.getFirst());
        while(!checkTheArrayIsZero(arr)){
            List<Integer> help = new ArrayList<>();

            for(int i=1;i<arr.size();i++){
                help.add(arr.get(i) - arr.get(i - 1));
            }
            stack.add(help.getFirst());
            arr=help;
        }
        int count=1;
        for(Integer i : stack){
            if(count%2==0){
                i*=-1;
            }
            ans+=i;
            count++;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        long ans = 0;
        while(sc.hasNextLine()){
            String s=sc.nextLine();
            List<Integer> arr = new ArrayList<>();
            String[] parts = s.split(" ");
            for(String part : parts){
                arr.add(Integer.parseInt(part));
            }
            ans+=increment(arr);
        }
        System.out.println(ans);
    }
}
