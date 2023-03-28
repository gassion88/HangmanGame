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
}
