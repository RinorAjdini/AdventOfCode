package Day6;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Day6 {
    public static int[] findFirstNumber(int timeList,int distance){
        for(int i=1;i<=distance/2;i++){
            if((timeList-i)*i>distance)
            {
                return new int[]{i,timeList-i};
            }
        }
        return null;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        long ans = 1;
        String line1 = sc.nextLine().split(":")[1].trim();
        String [] parts = line1.split("\\s+");
        ArrayList<Integer> timeList = new ArrayList<>();
        for(String part : parts){
            timeList.add(Integer.parseInt(part));
        }
        String line2 = sc.nextLine().split(":")[1].trim();
        parts = line2.split("\\s+");
        ArrayList<Integer> distanceList = new ArrayList<>();
        for(String part : parts){
            distanceList.add(Integer.parseInt(part));
        }
        for(int i=0;i<timeList.size();i++){
            int [] res = findFirstNumber(timeList.get(i), distanceList.get(i));
            ans *= res[1]-res[0]+1;
        }
        System.out.println(ans);

    }
}