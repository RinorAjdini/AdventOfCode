package Day4;

import java.io.BufferedInputStream;
import java.util.*;
import java.util.stream.Collectors;

public class Day4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        StringBuilder sb = new StringBuilder();
        int ans=0;
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
            boolean b= false;
            for(String number : myCart) {
                if (number != " ") {
                    int n = Integer.parseInt(number);
                    if (set.contains(n)) {
                        if (b) {
                            poena *= 2;
                        } else {
                            poena = 1;
                        }
                        b = true;
                    }
                }
            }
            ans+=poena;
        }
        System.out.println(ans);
    }
}
