package Day4;

import java.io.BufferedInputStream;
import java.util.*;

public class Day4_part2 {
    public static int[] sum(int [] set, int poz, int num){
        for(int i=poz+1;i<num+poz+1;i++){
            if(i<set.length) {
                int k = set[poz];
                set[i] = k + set[i];
            }
        }
        return set;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        StringBuilder sb = new StringBuilder();
        int ans=0;
        int[] lista = new int[202];
        for(int i=0;i< 202;i++){
            lista[i]=1;
        }
        int letmecount=0;
        int count=0;
        while(sc.hasNextLine()) {
            String s = sc.nextLine();
            String parts[] = s.split(":\\s+");
            String numbers = parts[1];
            String win[] = numbers.split("\\|\\s+");
            String[] letra = win[0].split("\\s+");
            HashSet<Integer> set = new HashSet<>();
            for(String number : letra){
                set.add(Integer.parseInt(number));
            }
            String [] myCart = win[1].split("\\s+");
            int poena=0;
            letmecount=0;
            for(String number : myCart) {
                if (number != " ") {
                    int n = Integer.parseInt(number);
                    if (set.contains(n)) {
                        poena++;
                    }
                    letmecount++;
                }

            }
            lista = sum(lista,count,poena);
            count++;
        }
        for(int i=0;i<count;i++){
            ans+=lista[i];
        }
        System.out.println(ans);
    }
}
