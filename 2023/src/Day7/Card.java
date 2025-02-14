package Day7;

import java.util.HashMap;
import java.util.Map;

public class Card implements Comparable<Card>{
    private String card;
    private char highestCard;
    private int type;

    private int howMuch;
    public Card(String card,Integer howMuch) {
        this.card = card;
        this.howMuch=howMuch;
        highestCard='2';
        type=1;
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<card.length();i++){
            if(map.containsKey(card.charAt(i))){
                int k = map.get(card.charAt(i));
                map.put(card.charAt(i),k+1);
            }
            else{
                map.put(card.charAt(i),1);
            }
        }
        boolean b3 = false;
        boolean b2 = false;
        int b2count=0;
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(entry.getValue()==5)
                this.type=7;
            else if(entry.getValue()==4)
                this.type=6;
            else if(entry.getValue()==3)
            {
                b3=true;
                if(b2){
                    this.type=5;
                }
                else
                this.type=4;
            }
            else if(entry.getValue()==2){
                if(b3){
                    this.type=5;
                }
                else {
                    if(b2){
                        this.type=3;
                    }
                    else {
                        this.type=2;
                    }
                }
                b2=true;
            }
        }
    }

    public int getHowMuch() {
        return howMuch;
    }

    public String getCard() {
        return card;
    }

    private char[] lista = new char[]{'A', 'K', 'Q', 'J', 'T', '9', '8', '7', '6', '5', '4', '3', '2'};

    @Override
    public int compareTo(Card otherCard) {
        if (this.type != otherCard.type) {
            return Integer.compare(this.type, otherCard.type);
        }
        for(int i=0;i<5;i++){
            char ch1 = this.card.charAt(i);
            char ch2 = otherCard.getCard().charAt(i);
            for (char c : lista) {
                if (ch1 == c && ch2 != c) {
                    return 1;
                }
                if (ch2 == c && ch1 != c) {
                    return -1;
                }
            }
        }
        return 0;
    }
}
