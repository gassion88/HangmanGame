import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Dictionary {
    public String secretWordChoice() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader( "./src/main/resources/WordsToGuess.txt" ) );
            ArrayList<String> list = new ArrayList<>();
            String str;
            String[] stringArr;

            while(( str = reader.readLine() ) != null ){
                if(!str.isEmpty()){
                    list.add(str);
                }}

            stringArr = list.toArray(new String[0]);
            return stringArr[(int) (Math.random() * (stringArr.length-1))];
        }catch (IOException Io) {
            throw new RuntimeException(Io);
        }

    }
}
