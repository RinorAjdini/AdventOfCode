package Day9;


import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Day9 {

    public static boolean checkTheArrayIsZero(List<Integer> arr){
        for(Integer i : arr){
            if(i!=0)
                return false;
        }
        return true;
    }
    public static long increment (List<Integer> arr){

        long ans = 0;
        while(!checkTheArrayIsZero(arr)){
            List<Integer> help = new ArrayList<>();
            for(int i=1;i<arr.size();i++){
                help.add(arr.get(i) - arr.get(i - 1));
            }
            ans+=help.getLast();
            arr=help;
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
            ans+=increment(arr)+arr.getLast();
        }
        System.out.println(ans);
    }
}
