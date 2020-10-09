package InterViewPrep;

public class CaesarCipherEncryptor {
    public static void main(String[] args) {
        String str = "xyz";
        int key = 2;
        System.out.println(Calculate(str, key));
    }

    //time: o(n) | space: o(n)
    private static String Calculate(String str, int key)
    {
        char[] newLetters = new char[str.length()];
        int newKey = key%26;
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < str.length(); i++) {
            newLetters[i] = getNewLetter(str.charAt(i), newKey, alphabet);
        }
        return new String(newLetters);
    }

    private static char getNewLetter(char letter, int key,
                                     String alphabet)
    {
        int newLetterCode = alphabet.indexOf(letter) + key;
        return alphabet.charAt(newLetterCode%26);
    }


}
