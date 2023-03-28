import java.util.HashSet;

public class ConsoleOutput {
    public void viewMenu(){
            System.out.println("1.New Game");
            System.out.println("2.Exit");
    }

    public void startGameInputChar() {
        System.out.println("The game has begun, enter the char.");
    }

    public void newGame() {
        System.out.println("New Game");
    }

    public void exit() {
        System.out.println("New Game");
    }

    public void maskWord(String secretWord, HashSet<Character> tryChars){
        char[] secretWordChars = secretWord.toCharArray();

        for (int i = 0; i < secretWordChars.length; i++) {
            if ( !tryChars.contains(secretWordChars[i]) && secretWordChars[i] != '*' ) {
                secretWordChars[i] = '*';
            }
        }
        System.out.println(secretWordChars);
    }

    public void hung(int size) {
        System.out.println("╔ ═ ═ ═ ═ ═ ═ ═");
        System.out.println("║" + (size > 0 ? "           │" : ""));
        System.out.println("║" + (size > 1 ? "           ◯" : ""));
        System.out.println("║" + (size > 2 ? "          /" : "") + (size > 3 ? "│" : "") + (size > 4 ? "\\" : ""));
        System.out.println("║" + (size > 5 ? "          /" : "") + (size > 6 ? " \\" : ""));
        System.out.println("║");
        System.out.println("║");
        System.out.println("╚═ ═ ═ ═ ═ ═ ═ ═ ");
    }

    public void errorChars(HashSet<Character> errorChars) {
        System.out.println("Mistakes: " + errorChars + " " + errorChars.size());

    }
}
