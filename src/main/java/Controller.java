public class Controller {
    private final  ConsoleOutput consoleOutput = new ConsoleOutput();
    private final Dictionary dictionary = new Dictionary();

    public void startMenu(){
        consoleOutput.viewMenu();
    }

    public String getSecretWord() {
        return dictionary.secretWordChoice();
    }
}
