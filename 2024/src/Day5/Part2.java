package Day5;

import java.util.*;

public class Part2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long res = 0;
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if (s.isEmpty()) {
                break;
            }
            int[] arr = new int[2];
            arr[0] = Integer.parseInt(s.split("\\|")[0]);
            arr[1] = Integer.parseInt(s.split("\\|")[1]);
            ArrayList<Integer> list;
            if (!map.containsKey(arr[1])) {
                list = new ArrayList<>();
            } else {
                list = map.get(arr[1]);
            }
            list.add(arr[0]);
            map.put(arr[1], list);
        }
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            Map<Integer, HashSet<Integer>> map1 = new HashMap<>();
            HashSet<Integer> set = new HashSet<>();
            boolean b = false;
            String[] str = s.split(",");
            int[] nums = new int[str.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(str[i]);
            }
            for (int i = 0; i < nums.length; i++) {
                if (set.contains(nums[i])) {
                    for (int j = 0; j <i; j++) {
//                        boolean endit = false;
                        ArrayList<Integer> lista1 = new ArrayList<>();
                        if (!map.containsKey(nums[j]))
                            continue;
                        lista1 = map.get(nums[j]);
                        for (int nn : lista1) {
                            if (nn == nums[i]) {
                                int k = nums[i];
                                nums[i] = nums[j];
                                nums[j] = k;
                                b=true;
                               // break;
                            }
                        }

                    }

                }
                if (map.containsKey(nums[i])) {
                    set.addAll(map.get(nums[i]));
                }
            }
            if(b)
            res+=nums[nums.length/2];
        }
        System.out.println(res);
    }
}
