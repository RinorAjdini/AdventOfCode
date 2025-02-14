package Day13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part2 {

    private static class Machine{
        long ax,ay,bx,by,totalx,totaly;

        public Machine(long ax, long ay, long bx, long by, long totalx, long totaly) {
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
                machines.add(new Machine(ax,ay,bx,by,totalx+10000000000000L,totaly+10000000000000L));
                //machines.add(new Machine(ax,ay,bx,by,totalx,totaly));
            }
        }
        long total=0;
        for( Machine m : machines){
            long cost = minimumTokensForMachine(m);
            if(cost!=-1){
                total+=cost;
            }
        }
        System.out.println(total);
    }
    private static long minimumTokensForMachine(Machine m){
        long d = m.ax * m.by - m.ay * m.bx;
        if(d==0)
            return -1;
        long dx = m.totalx * m.by - m.totaly * m.bx;
        long dy = m.totaly * m.ax - m.totalx * m.ay;
        if(dx % d !=0 || dy % d !=0)
            return -1;
        return dx/d * 3 + dy/d;
    }
}
