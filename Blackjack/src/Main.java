import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Stack<Card> deck = new Stack<>();
        ArrayList<Card> playerHand = new ArrayList<>();
        ArrayList<Card> dealerHand = new ArrayList<>();
        Scanner scr = new Scanner(System.in);
        String input;
        List<String> hitStand = List.of("h", "s");
        deck = buildDeck(deck);

        do {
            int playerPts;
            int dealerPts;

            if(deck.size() < 15){
                deck = buildDeck(deck);
            }

            playerHand.add(deck.pop());
            dealerHand.add(deck.pop());
            playerHand.add(deck.pop());
            dealerHand.add(deck.pop());

            showCards(playerHand, dealerHand);

            playerPts = calculatePts(playerHand);
            System.out.println("Your score is: " + playerPts);

            do {
                System.out.println("Enter H to hit or S to stand.");
                while (true) {
                    try {
                        input = getInput(scr, hitStand);
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                if (input.equals("h")) {
                    System.out.println("You draw the " + deck.peek() + ".");
                    playerHand.add(deck.pop());
                    showCards(playerHand, dealerHand);
                    playerPts = calculatePts(playerHand);
                    System.out.println("Your score is: " + playerPts);
                } else {
                    System.out.println("You stand on " + playerPts + ".");
                }

            } while (playerPts < 21 && !input.equals("s"));

            System.out.println("Dealer's turn...");
            Thread.sleep(1500);

            System.out.println("The dealer has " + dealerHand);
            dealerPts = calculatePts(dealerHand);

            while (playerPts <= 21 && dealerPts <= 16) {
                System.out.println("The dealer draws: " + deck.peek());
                dealerHand.add(deck.pop());
                dealerPts = calculatePts(dealerHand);
                Thread.sleep(2000);
            }

            System.out.println("The dealer has " + dealerHand);

            System.out.println();
            System.out.println("The dealer's score is: " + dealerPts);

            String winLoss = ((playerPts <= 21 && playerPts > dealerPts) || dealerPts > 21) ? "You win!" : "You're a loser!";

            System.out.println(winLoss);

            System.out.println("Play again? (Y/N)");
            while (true) {
                try {
                    input = getInput(scr, List.of("y", "n"));
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            playerHand.clear();
            dealerHand.clear();

        }while(input.equals("y"));

        System.out.println("Goodbye!");
    }

    public static void showCards(ArrayList<Card> playerHand, ArrayList<Card> dealerHand){
        System.out.println();
        System.out.println("The dealer's hand so far: " + dealerHand.get(0));

        System.out.println();
        System.out.println("Your hand so far: ");
        System.out.println(playerHand);
    }
    public static int calculatePts(ArrayList<Card> hand){
        int points = hand.stream().filter(c -> (!c.getRank().equals("A"))).mapToInt(Card::getPoints).sum();
        List<Card> aces = hand.stream().filter(c -> c.getRank().equals("A")).collect(Collectors.toList());

        for(Card c : aces){
            points += c.getPoints(points);
        }

        return points;
    }
    public static String getInput(Scanner scr, List<String> choices) throws Exception {
        String input = scr.next().toLowerCase().substring(0, 1);
        if(choices.contains(input)){
            return input;
        }else{
            throw new Exception("Invalid input, try again.");
        }
    }
    public static Stack<Card> buildDeck(Stack<Card> deck){
        deck.clear();

        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] suits = {"Hearts", "Diamonds", "Spades", "Clubs"};

        for(String r : ranks){
            for(String s : suits){
                Card card = new Card(r, s);
                deck.add(card);
            }
        }

        System.out.println("Shuffling the deck...");
        Collections.shuffle(deck);

        return deck;
    }
}