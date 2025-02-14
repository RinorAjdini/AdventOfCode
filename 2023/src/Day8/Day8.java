package Day8;

import com.sun.source.tree.BinaryTree;
import com.sun.source.tree.Tree;

import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        String instructions = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        Map<String,Pair> map = new HashMap<String, Pair>();
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            if(!s.isEmpty()){
                String [] parts = s.split(" = ");
                String [] parts1 = parts[1].substring(1,parts[1].length()-1).split(", ");
                map.put(parts[0],new Pair(parts1[0],parts1[1]));
            }
        }
        String rez = "AAA";
        long ans = 0;
        while(!rez.equals("ZZZ")){
            for(int i=0;i<instructions.length();i++){
                if(instructions.charAt(i)=='L')
                {
                    rez = map.get(rez).getLeft();
                }
                else {
                    rez = map.get(rez).getRight();
                }
                ans++;
            }
        }
        System.out.println(ans);
    }
}
