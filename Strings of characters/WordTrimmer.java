package Strings of characters;

public class WordTrimmer {
    public static void main(String[] args) {
        String word = "alina";
        
        while (word.length() > 0) {
            System.out.println(word);
            word = word.substring(1, word.length() - 1);
        }
    }
}

