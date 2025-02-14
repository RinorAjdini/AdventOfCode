package Day8;

import java.io.BufferedInputStream;
import java.util.*;

public class Day8_part2 {

    public static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static long  findLCM(List<Long> array){
        long lcm=array.get(0);
        for(int i=1;i<array.size();i++){
            lcm = lcm(lcm,array.get(i));
        }
        return lcm;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        String instructions = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        Map<String,Pair> map = new HashMap<String, Pair>();
        List<String> stringList = new ArrayList<>();
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            if(!s.isEmpty()){
                String [] parts = s.split(" = ");
                String [] parts1 = parts[1].substring(1,parts[1].length()-1).split(", ");
                map.put(parts[0],new Pair(parts1[0],parts1[1]));
                if(parts[0].endsWith("A")){
                    stringList.add(parts[0]);
                }
            }
        }
        long ans = 0;
        List<Long> lista = new ArrayList<>();
        for(int j=0;j<stringList.size();j++) {
            String rez=stringList.get(j);
            ans=0;
            while (!rez.endsWith("Z")) {
                for (int i = 0; i < instructions.length(); i++) {
                    if (instructions.charAt(i) == 'L') {
                        rez = map.get(rez).getLeft();
                    } else {
                        rez = map.get(rez).getRight();
                    }
                    ans++;
                }
            }
            lista.add(ans);
        }
        System.out.println(findLCM(lista));
    }
}
