package Algorithms.Array;

public class ReplaceAllSpaces {
    public static String replace(String s){
        char[] chars = s.toCharArray();
        int spaceCount = 0;

        for (int i = 0; i <s.length() ; i++) {
            spaceCount++;
        }

        int newLength = s.length() + 2* spaceCount;
        char[] newArray = new char[newLength];

        for (int i = s.length()-1; i >=0 ; i--) {
            if (chars[i] == ' ') {
                newArray[newLength -1] = '0';
                newArray[newLength -2] = '2';
                newArray[newLength -3] = '%';
                newLength = newLength - 3;
            } else {
                newArray[newLength-1] = chars[i];
                newLength = newLength -1;
            }
        }
        return String.valueOf(newArray);
    }
    public static void main(String[] args) {
        String s1 = "I am Sumit Jain";
        System.out.println("Input String: " + s1);
        System.out.println("Output string: " + replace(s1));
    }
}
