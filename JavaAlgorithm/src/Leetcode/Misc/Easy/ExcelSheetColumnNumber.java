package Leetcode.Misc.Easy;

public class ExcelSheetColumnNumber {
    public static void main(String[] args) {
        String str = "AA";

        int sum = 0;

        for (int i = 0; i < str.length(); i++) {
            sum *= 26;
            sum += (str.charAt(i) - 'A' + 1);
        }

        System.out.println(sum);
    }
}
