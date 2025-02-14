package Day5;

import java.util.*;

public class Part1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long res = 0;
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if(s.isEmpty()){
                break;
            }
            int[] arr = new int[2];
            arr[0] = Integer.parseInt(s.split("\\|")[0]);
            arr[1] = Integer.parseInt(s.split("\\|")[1]);
            ArrayList<Integer> list;
            if(!map.containsKey(arr[1])){
                list = new ArrayList<>();
            }
            else{
                list = map.get(arr[1]);
            }
            list.add(arr[0]);
            map.put(arr[1],list);
        }
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            HashSet<Integer> set = new HashSet<>();
            boolean b = true;
            String[] str = s.split(",");
            int[] nums = new int[str.length];
            for (int i=0;i<nums.length;i++){
                nums[i]=Integer.parseInt(str[i]);
            }
            for(int i=0;i<nums.length;i++){
                if(set.contains(nums[i])){
                    b=false;
                    break;
                }
                if(map.containsKey(nums[i]))
                    set.addAll(map.get(nums[i]));
            }
            if(b){
                res+=nums[nums.length/2];
            }
        }
        System.out.println(res);
    }
}
