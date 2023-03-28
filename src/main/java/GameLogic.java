import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class GameLogic {
    private final Scanner scanner = new Scanner(System.in);
    private final Controller controller = new Controller();
    public String SECRET_WORD;
    public HashSet<Character> ERROR_CHARS;
    public HashSet<Character> GUESSED_UNIQ_CHARS;
    public int SECRET_WORD_UNIQ_CHAR_COUNT;

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
            controller.startMenu();
        } while (true);
    }

    private boolean validateMenuInput(String input) {
        if ( Objects.equals(input, "1") ) {
            startGameRound();
        } else if (Objects.equals(input, "2")) {
            return true;
        }
        else System.out.println("Enter number 1-2");
        return false;
    }

    private void startGameRound() {
        initGameData();
        System.out.println("Start Game");

    }

    private void initGameData() {
        SECRET_WORD = controller.getSecretWord();
        ERROR_CHARS = new HashSet<>();
        GUESSED_UNIQ_CHARS = new HashSet<>();
        SECRET_WORD_UNIQ_CHAR_COUNT = setSecretWordUniqCharCount();
    }
    public int setSecretWordUniqCharCount() {
        Set<Character> tryCharSet = new HashSet<>();

        for ( Character ch : SECRET_WORD.toCharArray() ) {
            tryCharSet.add(ch);
        }

        return tryCharSet.size();
    }
}
