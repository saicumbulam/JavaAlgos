package Leetcode.Easy;

public class DefangingIpAddress {
    public static void main(String[] args) {
        String address = "1.1.1.1";
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < address.length(); i++)
        {
            if (address.charAt(i) == '.')
            {
                result.append("[.]");
            }
            else
            {
                result.append(String.valueOf(address.charAt(i)));
            }
        }

        System.out.println(result.toString());
    }
}
