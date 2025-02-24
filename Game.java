import java.util.Random;
import java.util.Scanner;

public class Game {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("""
                Welcome to the Number Guessing Game!
                I'm thinking of a number between 1 and 100.
                You have 5 chances to guess the correct number.
                
                Please select the difficulty level:
                1. Easy (10 chances)
                2. Medium (5 chances)
                3. Hard (3 chances)
                others number to stop the game
                """);


        System.out.print("Enter your choice : ");
        int choice = sc.nextInt();

        switch (choice){
            case 1 -> {
                System.out.println("""
                Great! You have selected the Easy difficulty level.
                Let's start the game!
                """);
                runGame(10, randomNumber());
            }
            case 2 -> {
                System.out.println("""
                Great! You have selected the Medium difficulty level.
                Let's start the game!
                """);
                runGame(5, randomNumber());
            }
            case 3 -> {
                System.out.println("""
                Great! You have selected the Hard difficulty level.
                Let's start the game!
                """);
                runGame(3, randomNumber());
            }
            default -> System.out.println("Arrêt du jeu");
        }
    }

    private static int randomNumber(){
        return new Random().nextInt(100);
    }

    private static void runGame(int chances, int randomNumber){

        int guessNumber = 0, attemps = 1;
        boolean isPlayerWin = false;
        do {
            System.out.print("Enter your guess : " );
            guessNumber = sc.nextInt();
            if(guessNumber == randomNumber){
                isPlayerWin = true;
            } else{
                chances--;
                if(guessNumber > randomNumber){
                    System.out.println("Incorrect! The number is less than "+ guessNumber + ".");
                } else{
                    System.out.println("Incorrect! The number is greater than "+ guessNumber + ".");
                }
                attemps++;
            }

        } while(!isPlayerWin && chances > 0);

        if(isPlayerWin){
            System.out.println("Congratulations! You guessed the correct number in "+ attemps +" attempts.");
        } else {
            System.out.println("Game Over");
        }


    }
}
