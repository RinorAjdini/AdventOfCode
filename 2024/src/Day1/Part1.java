package Day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class Part1 {

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
        Collections.sort(arr);
        Collections.sort(arr1);
        long dis=0;
        for(int i=0;i<arr.size();i++){
            dis+=Math.abs(arr.get(i) - arr1.get(i));
        }
        System.out.println(dis);
    }
}
