package cardGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    public static void main(String[] args) {
        List<Card> deck = new ArrayList<>(52);

        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                deck.add(new Card(r, s));
            }
        }
        
        Collections.sort(deck);
        System.out.println("***Sorted Deck***");
        for (Card card : deck) {
            System.out.println(card);
        }
        
        Collections.shuffle(deck);
        System.out.println("***Shuffled Deck***");
        for (Card card : deck) {
            System.out.println(card);
        }
    }

}