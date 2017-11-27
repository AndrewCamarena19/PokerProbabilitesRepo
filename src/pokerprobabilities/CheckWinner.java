/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokerprobabilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Andy
 */
public class CheckWinner {
    
    static double wins = 0;
    static ArrayList<String> Suits = new ArrayList<>(Arrays.asList("c", "s", "h", "d"));
    static ArrayList<Card> Deck = new ArrayList<>();
    
    private static void CheckWinner(PokerHand Seat1, PokerHand Seat2) {
        Seat1.CalculateHand();
        Seat2.CalculateHand();
        if (Seat1.getHandStrength() > Seat2.getHandStrength()) {
            wins++;
        } else if (Seat1.getHandStrength() < Seat2.getHandStrength()) {
            
        } else {
            //easy check for first card
            if (Seat1.getCard(0).getRank() > Seat2.getCard(0).getRank())
            {wins++;}
            else if(Seat1.getCard(0).getRank() < Seat2.getCard(0).getRank())
            {}
            else {
                //may need to check all cards
                int count = 1;
                boolean done = false;
                while (count < 5 && !done) {
                    if (Seat1.getCard(count).getRank() > Seat2.getCard(count).getRank()) {
                        wins++;
                        done = true;
                    } else if (Seat1.getCard(count).getRank() < Seat2.getCard(count).getRank()) {
                        //Pot.setText("Seat 2 wins");
                        done = true;
                    } else
                        count++;
                }
                if (!done)
                {}
            }
        }
    }
    
    public static void main(String args[]) {
        Card one = new Card(1, "s");
        Card two = new Card(1, "c");
        Card three = new Card(13, "s");
        Card four = new Card(13, "c");
        Card five = new Card(10, "d");
        Card six = new Card(4, "s");
        Card seven = new Card(7, "c");
        Card eight = new Card(2, "h");
        for (int i = 0; i < Suits.size(); i++) {
            for (int k = 1; k < 14; k++) {
                Card toAdd = new Card(k, Suits.get(i));
                if(!toAdd.isCard(one) && !toAdd.isCard(two) && !toAdd.isCard(three) && !toAdd.isCard(four) &&
                   !toAdd.isCard(five) && !toAdd.isCard(six) && !toAdd.isCard(seven) && !toAdd.isCard(eight))
                    Deck.add(toAdd);
            }
        }
        double totalhands = 0;
        Collections.shuffle(Deck);
        for(int i = 0; i < Deck.size(); i++)
            for(int k = i+1 ; k < Deck.size(); k++)
                for(int j = k+1; j < Deck.size(); j++)
                    for(int l = j+1; l < Deck.size(); l++)
                        for(int m = l+1; m < Deck.size(); m++)
                        {
                            PokerHand me2 = new PokerHand();
                            me2.addCard(one);
                            me2.addCard(two);
                            //me2.addCard(three);
                            //me2.addCard(four);
                            me2.addCard(Deck.get(i));
                            me2.addCard(Deck.get(j));
                            me2.addCard(Deck.get(k));
                            me2.addCard(Deck.get(l));
                            me2.addCard(Deck.get(m));
                            PokerHand opp2 = new PokerHand();
                            //opp2.addCard(five);
                            //opp2.addCard(six);
                            opp2.addCard(seven);
                            opp2.addCard(eight);
                            opp2.addCard(Deck.get(i));
                            opp2.addCard(Deck.get(j));
                            opp2.addCard(Deck.get(k));
                            opp2.addCard(Deck.get(l));
                            opp2.addCard(Deck.get(m));
                            CheckWinner(me2,opp2);
                            totalhands++;
                        }
            
        double percent = wins/totalhands;
        System.out.println(totalhands);
        System.out.println(percent*100);
    }
}
