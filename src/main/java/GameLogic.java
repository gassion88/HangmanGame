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
        String menuInput;

        do {
            controller.startMenu();

            menuInput = userInput();
        }while (validateMenuInput(menuInput));
    }

    private  String userInput() {
        do {
            String input = scanner.next();
            if ( input.length() == 1 ) {
                return input;
            }

            controller.viewEnterOneCharacter();
            controller.startMenu();
        } while (true);
    }

    private boolean validateMenuInput(String input) {
        if ( Objects.equals(input, "1") ) {
            startGameRound();
        } else if (Objects.equals(input, "2")) {
            return false;
        }
        else controller.viewEnterNumber();

        return true;
    }

    private void startGameRound() {
        initGameData();

        controller.viewStartGameInputChar();
        viewGameState();

        while (checkGameState()) {
            updateGameState(userInput());
            viewGameState();
        }
    }

    private void viewGameState() {
        controller.viewMaskWord(SECRET_WORD, GUESSED_UNIQ_CHARS);
        controller.viewErrorChars(ERROR_CHARS);
        controller.viewHung(ERROR_CHARS.size());
    }

    private boolean checkGameState() {
        if ( ERROR_CHARS.size() > 6 ){
            controller.viewGameOver();
            return false;
        } else if ( GUESSED_UNIQ_CHARS.size() ==  SECRET_WORD_UNIQ_CHAR_COUNT ) {
            controller.viewGameWin();
            return false;
        }

        return true;
    }

    public void updateGameState(String playerInput) {
        if (Objects.equals(playerInput, "1")) {
            controller.viewNewGame();
        } else if (Objects.equals(playerInput, "2")) {
            controller.viewExit();
        }

        playerInputValidation(playerInput);
    }

    public void playerInputValidation(String playerInput) {
            if ( GUESSED_UNIQ_CHARS.contains(playerInput.charAt(0)) || ERROR_CHARS.contains( playerInput.charAt(0)) ) {
                controller.viewHasBeenChar();
            } else if ( SECRET_WORD.contains(playerInput) ) {
                GUESSED_UNIQ_CHARS.add( playerInput.charAt(0) );
            } else {
                ERROR_CHARS.add(playerInput.charAt(0));
            }
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
