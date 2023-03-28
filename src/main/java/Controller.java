import java.util.HashSet;

public class Controller {
    private final  ConsoleOutput consoleOutput = new ConsoleOutput();
    private final Dictionary dictionary = new Dictionary();

    public void startMenu(){
        consoleOutput.viewMenu();
    }

    public String getSecretWord() {
        return dictionary.secretWordChoice();
    }

    public void viewStartGameInputChar() {
        consoleOutput.startGameInputChar();
    }

    public void viewNewGame() {
        consoleOutput.newGame();
    }

    public void viewExit() {
        consoleOutput.exit();
    }
    public void viewHung(int size) {
       consoleOutput.hung(size);
    }

    public void viewMaskWord(String secretWord, HashSet<Character> tryChars) {
        consoleOutput.maskWord(secretWord, tryChars);
    }

    public void viewErrorChars(HashSet<Character> errorChars) {
        consoleOutput.errorChars(errorChars);
    }
}
