package Day7;

import java.io.BufferedInputStream;
import java.util.*;

public class newDay7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        List<Card> cardList = new ArrayList<Card>();
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            String [] part = s.split("\\s+");
            cardList.add(new Card(part[0],Integer.parseInt(part[1])));
        }
        String s="";//remove this
        Collections.sort(cardList);
        long ans=0;
        for(int i=0;i<cardList.size();i++){
            ans+= (long) (i + 1) *cardList.get(i).getHowMuch();
        }
        System.out.println(ans);
    }
}
