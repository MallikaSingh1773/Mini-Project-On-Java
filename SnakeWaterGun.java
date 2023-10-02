import java.util.Random;
import java.util.Scanner;

public class SnakeWaterGun {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to Snake Water Gun Game!");
        System.out.println("Choose one: ");
        System.out.println("1. Snake");
        System.out.println("2. Water");
        System.out.println("3. Gun");

        int playerChoice = scanner.nextInt();
        String[] choices = {"Snake", "Water", "Gun"};
        String playerSelection = choices[playerChoice - 1];

        int computerChoice = random.nextInt(3);
        String computerSelection = choices[computerChoice];

        System.out.println("You chose: " + playerSelection);
        System.out.println("Computer chose: " + computerSelection);

        String result = determineWinner(playerSelection, computerSelection);
        System.out.println(result);

        scanner.close();
    }

    public static String determineWinner(String player, String computer) {
        if (player.equals(computer)) {
            return "It's a tie!";
        } else if ((player.equals("Snake") && computer.equals("Water")) ||
                (player.equals("Water") && computer.equals("Gun")) ||
                (player.equals("Gun") && computer.equals("Snake"))) {
            return "You win!";
        } else {
            return "Computer wins!";
        }
    }
}

