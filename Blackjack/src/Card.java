import java.util.ArrayList;

public class Card {
    private String rank;
    private String suit;
    private int points;

    public Card(String rank, String suit){
        this.rank = rank;
        this.suit = suit;
    }
    public String getRank(){
        return this.rank;
    }

    @Override
    public String toString() {
        return String.format("%s of %s", this.rank, this.suit);
    }

    public int getPoints() {
        if(Character.isDigit(this.rank.charAt(0))){
            points = Integer.parseInt(this.rank);
        }else if(!(this.rank.charAt(0) == 'A')){
            points = 10;
        }
        return points;
    }
    public int getPoints(int handPoints){
        assert(this.rank.charAt(0) == 'A');
        return (handPoints + 11 > 21)? 1 : 11;
    }
}