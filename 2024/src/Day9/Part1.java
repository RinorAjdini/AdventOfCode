package Day9;

import java.util.*;

public class Part1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        StringBuilder res = new StringBuilder();
        long id=0;
        TreeMap<Long,Long> map = new TreeMap<>();
        TreeMap<Long,Long> map1 = new TreeMap<>(Comparator.reverseOrder());
        long count=0;
        long really=0;
        for(long i=0;i<input.length();i++){
            for(long j = 0; j<Integer.parseInt(String.valueOf(input.charAt((int) i))); j++){
                if(i%2==0) {
                    res.append(i/2);
                    map.put(id,i/2);
                    map1.put(id,i/2);
                    id++;
                    really+=count;
                    count=0;
                }
                else {
                    res.append(".");
                    id++;
                    count++;
                }
            }
        }
        long ans=0;
        long d = map1.firstKey();
        for(long i=1;i<=d-really;i++){
            if(map.containsKey(i)){
                ans+=i * map.get(i);
            }
            else {
                ans+= i * map1.firstEntry().getValue();
                map1.remove(map1.firstKey());
            }
        }
        System.out.println(ans);



//        for(int i=0;i<res.length();i++){
//            if(res.charAt(i)=='.'){
//                for(int j=res.length()-1;j>i;j--){
//                    if(Character.isDigit(res.charAt(j))){
//                        res.setCharAt(i, res.charAt(j));
//                        res.setCharAt(j,'.');
//                        break;
//                    }
//                }
//            }
//        }
//        long ans=0;
//        for(int i=1;i<res.length();i++){
//            if(res.charAt(i)=='.')
//                break;
//            ans+= (long) Integer.parseInt(String.valueOf(res.charAt(i))) * i;
//        }
//        System.out.println(ans);
    }
}

