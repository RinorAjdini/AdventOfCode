package Day13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part1 {

    private static class Machine{
        int ax,ay,bx,by,totalx,totaly;

        public Machine(int ax, int ay, int bx, int by, int totalx, int totaly) {
            this.ax = ax;
            this.ay = ay;
            this.bx = bx;
            this.by = by;
            this.totalx = totalx;
            this.totaly = totaly;
        }
    }

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       List<Machine> machines  = new ArrayList<>();
        int ax=0,bx=0,ay=0,by=0,totalx=0,totaly=0;
       while(sc.hasNextLine()){
           String s = sc.nextLine().trim();

           if(s.isEmpty()) {
               continue;
           }
           if(s.startsWith("Button A")){
               String[] parts = s.split(": ")[1].split(", ");
               ax=Integer.parseInt(String.valueOf(parts[0].split("\\+")[1]));
               ay=Integer.parseInt(String.valueOf(parts[1].split("\\+")[1]));
           }
           else if (s.startsWith("Button B")) {
               String[] parts = s.split(": ")[1].split(", ");
               bx=Integer.parseInt(String.valueOf(parts[0].split("\\+")[1]));
               by=Integer.parseInt(String.valueOf(parts[1].split("\\+")[1]));
           }
           else {
               String[] parts = s.split(": ")[1].split(", ");
               totalx=Integer.parseInt(String.valueOf(parts[0].split("=")[1]));
               totaly=Integer.parseInt(String.valueOf(parts[1].split("=")[1]));
               machines.add(new Machine(ax,ay,bx,by,totalx,totaly));
           }
       }
       int total=0;
       for( Machine m : machines){
           int cost = minimumTokensForMachine(m);
           if(cost!=Integer.MAX_VALUE){
               total+=cost;
           }
       }
        System.out.println(total);
    }
    private static int minimumTokensForMachine(Machine m){
        int min = Integer.MAX_VALUE;
        for(int i=0;i<=100;i++){
            int x=i*m.ax;
            int y=i*m.ay;
            int xrem = m.totalx-x;
            if(xrem % m.bx != 0 ) continue;
            int n = xrem / m.bx;
            if(n<0) continue;
            if(y + n * m.by == m.totaly){
                int cost = 3* i + n;
                min = Math.min(min,cost);
            }
        }
        return min;
    }
}
