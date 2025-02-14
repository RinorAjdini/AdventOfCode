package Day7;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day7_part2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        List<CardPart2> cardList = new ArrayList<CardPart2>();
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            String [] part = s.split("\\s+");
            cardList.add(new CardPart2(part[0],Integer.parseInt(part[1])));
        }
        String s="";//remove this
        Collections.sort(cardList);
        long ans=0;
        for(int i=0;i<cardList.size();i++){
            ans+= (long) (i + 1) *cardList.get(i).getHowMuch();
            System.out.println(cardList.get(i).getCard());
        }
        System.out.println(ans);
    }
}
