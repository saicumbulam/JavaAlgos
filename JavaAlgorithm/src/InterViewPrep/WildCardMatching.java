package InterViewPrep;

public class WildCardMatching {
    public static void main(String[] args) {
        String s = "aa";
        String p = "*";

        System.out.println(Calculate(s, p));
    }

    private static boolean Calculate(String s, String p)
    {
        if(p.isEmpty())
        {
            return s.isEmpty();
        }

        if(p.charAt(0) == '*')
        {
            return Calculate(s, p.substring(1)) ||
                    (s.length() > 0 && Calculate(s.substring(1), p));
        }
        else if (p.charAt(0) == '?')
        {
            return s.length() > 0 && Calculate(s.substring(1), p.substring(1));
        }
        else
        {
            return s.length() > 0 && s.charAt(0) == p.charAt(0) &&
                    Calculate(s.substring(1), p.substring(1));
        }
    }
}
