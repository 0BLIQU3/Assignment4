import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("dictionary.txt"))) {
            bufferedReader.readLine();
            String inputLine;
            int i = 0;
            SeparateChainingHashST separateChainingHashST = new SeparateChainingHashST<>(1000);
            LinearProbingHashST linearProbingHashST = new LinearProbingHashST<>(20000);
            while ((inputLine = bufferedReader.readLine()) != null) {
                separateChainingHashST.put(inputLine, i);
                linearProbingHashST.put(inputLine, i);
                i++;
            }
//            ConsoleColors.println("Separate Chaining Hash Table: ", "green");
//            separateChainingHashST.keys();
//            ConsoleColors.println("Linear Probing Hash Table: ", "green");
//            linearProbingHashST.keys();
            for (int j = 0; j < 5; j++) {
                ConsoleColors.println("Please enter password: ", "cyan");
                String passwordInput = StdIn.readString();

                if (weakPasswordCheck(passwordInput, separateChainingHashST) || weakPasswordCheckLP(passwordInput, linearProbingHashST)) {
                    ConsoleColors.println("Weak Password.", "red");
                }
                else {
                    ConsoleColors.println("Good Password!", "green");
                }
            }
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }
    }

    private static boolean weakPasswordCheck(String passwordInput, SeparateChainingHashST symbolTable) {
        if (passwordInput.length() < 8) {
            return true;
        }
        for (int i = 0; i < passwordInput.length(); i++) {
            //See if everything before potential digit is within the ST
            String wordPart = passwordInput.substring(0, i + 1);
            if (symbolTable.get(wordPart) != null) {
                return true;
            }
            //Go to end of string and check to see if digit
            if (Character.isDigit(passwordInput.charAt(i))) {
                //See if everything before potential digit is within the ST
                if (symbolTable.get(wordPart) != null) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean weakPasswordCheckLP(String passwordInput, LinearProbingHashST symbolTable) {
        if (passwordInput.length() < 8) {
            return true;
        }
        for (int i = 0; i < passwordInput.length(); i++) {
            //See if everything before potential digit is within the ST
            String wordPart = passwordInput.substring(0, i + 1);
            if (symbolTable.get(wordPart) != null) {
                return true;
            }
            //Go to end of string and check to see if digit
            if (Character.isDigit(passwordInput.charAt(i))) {
                //See if everything before potential digit is within the ST
                if (symbolTable.get(wordPart) != null) {
                    return true;
                }
            }
        }
        return false;
    }
}
