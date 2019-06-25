package Algorithms.Array;

public class ReverseString {
    public static void main(String[] args) {
        String input = "Geeks For Geeki";
        char[] temporary = input.toCharArray();

        int left = 0;
        int right = temporary.length - 1;

        for (left = 0;  left < right; left++, right--) {
            // swap values of right and left
            char temp = temporary[left];
            temporary[left] = temporary[right];
            temporary[right] = temp;
        }
        for (char item: temporary
             ) {
            System.out.println(item);
        }

    }
}
