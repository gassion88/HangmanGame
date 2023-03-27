import java.util.Objects;
import java.util.Scanner;

public class GameLogic {
    private final Scanner scanner = new Scanner(System.in);
    private final Controller controller = new Controller();

    public  void launchGame(){
        do {
            controller.startMenu();
            String input = userInput();

            if (validateMenuInput(input)) return;
        }while (true);
    }

    private  String userInput() {
        do {
            String input = scanner.next();

            if ( input.length() == 1 ) {
                return input;
            }

            System.out.println("Enter one character");
        } while (true);
    }

    private boolean validateMenuInput(String input) {
        if ( Objects.equals(input, "1") ) {
            System.out.println("Start Game!");
        } else if (Objects.equals(input, "2")) {
            return true;
        }
        else System.out.println("Enter number 1-2");

        return false;
    }

}
