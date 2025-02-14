package Day2;

import java.util.ArrayList;
import java.util.Scanner;
public class Part2 {

    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        long count=0;
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            if (line.trim().isEmpty()) continue;
            String[] numbers = line.split("\\s+");
            ArrayList<Integer> a = new ArrayList<>();
            boolean tolerate = false;
            for (String number : numbers) {
                int current = Integer.parseInt(number);
                a.add(current);
            }
            if(isSafe(a)){
                count++;
            }
            else{
                ArrayList<Integer> newList = new ArrayList<>(a);
                for(int i=0;i<a.size();i++){
                    newList.remove(i);
                    if(isSafe(newList)){
                        count++;
                        break;
                    }
                    newList=new ArrayList<>(a);
                }
            }
        }
        System.out.println(count);
    }

    public static boolean isSafe(ArrayList<Integer> arr){
        if(arr.size()<2)
            return true;
        ArrayList<Integer> diff = new ArrayList<>();
        for(int i=1;i<arr.size();i++){
            diff.add(arr.get(i)-arr.get(i-1));
        }
        boolean inc = diff.get(0) > 0;
        for(int d : diff){
            if(Math.abs(d)>3 || d==0) return false;
            if(inc && d<0) return false;
            if(!inc && d>0) return false;
        }
        return true;
    }

}

