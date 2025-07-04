package Strings; of characters;

public class WordSuffixChecker {
    public static void main(String[] args) {
        int n = 6;
        String[] words = {"ion", "revelion", "ionel", "bulion", "milion", "pionul"}; 
        
        String firstWord = words[0];
        int count = 0;
        
        for (int i = 1; i < n; i++) {
            if (words[i].endsWith(firstWord)) {
                count++;
            }
        }
        
        System.out.println(count);
    }
}

