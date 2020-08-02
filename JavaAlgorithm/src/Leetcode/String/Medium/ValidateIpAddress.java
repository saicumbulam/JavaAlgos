package Leetcode.String.Medium;

public class ValidateIpAddress {
    public static void main(String[] args) {
        System.out.println(validIPAddress("172.16.254.1"));
    }

    public static String validIPAddress(String IP) {
        if (IP.split("\\.").length == 4)
        {
            return ValidateIpv4(IP.split("\\."));
        }
        else if (IP.split(":").length == 8)
        {
            return ValidateIpV6(IP.split(":"));
        }
        else
        {
            return "Neither";
        }
    }

    private static String ValidateIpV6(String[] str) {
        String hexDigits = "123456abcdefABCDEF";
        for (String x: str
        ) {
            if (x.length() > 4)
            {
                return "Neither";
            }

            for (char item: x.toCharArray()
            ) {
                if (!hexDigits.contains(String.valueOf(item)))
                {
                    return "Neither";
                }
            }
        }
        return "IPv6";
    }

    private static String ValidateIpv4(String[] str) {
        for (String x: str
             ) {
            if (x.length() > 3)
            {
                return "Neither";
            }

            if (x.charAt(0) == '0' && x.length() != 1)
            {
                return "Neither";
            }
            for (char item: x.toCharArray()
                 ) {
                if (!Character.isDigit(item))
                {
                    return "Neither";
                }
            }

            if (Integer.parseInt(x) > 255)
            {
                return "Neither";
            }
        }
        return "IPv4";
    }


}
