import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char choice;
        do{
            System.out.println("You are in a land full of dragons. In front of you,");
            System.out.println("you see two caves. In one cave, the dragon is friendly");
            System.out.println("and will share his treasure with you.  The other dragon");
            System.out.println("is greedy and hungry and will eat you on sight.");
            System.out.println("Which cave will you go into (1 or 2)");
            choice = input.next().charAt(0);
        }while(choice != '1' && choice != '2');
        if(choice == '1'){
            System.out.println("You approach the cave...");
            System.out.println("It is dark and spooky...");
            System.out.println("A large dragon jumps out in front of you! He opens his jaws and...");
            System.out.println("Gobbles you down in one bite!");
        } else {
            System.out.println("You approach the cave...");
            System.out.println("It is dark but feels strangely welcoming...");
            System.out.println("As you turn a corner, you see a large dragon on a pile of treasure and...");
            System.out.println("The dragon showers you with gold!");
        }

    }
}