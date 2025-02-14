package Day1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class Part2 {

    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> arr1 = new ArrayList<>();
        while(true){
            if(sc.hasNext()) {
                arr.add(sc.nextInt());
                arr1.add(sc.nextInt());
            }
            else
                break;
        }
        int[] freq = new int[9999999];
        for(int i=0;i<arr1.size();i++){
            freq[arr1.get(i)]++;
        }
        long sim=0;
        for(int i=0;i<arr.size();i++){
            if(freq[arr.get(i)]>0){
                sim+= (long) arr.get(i) *freq[arr.get(i)];
            }
        }
        System.out.println(sim);
    }
}
