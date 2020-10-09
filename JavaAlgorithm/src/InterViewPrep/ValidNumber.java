package InterViewPrep;

public class ValidNumber {
    public static void main(String[] args) {
        String str = "2e10";
        System.out.println(Calculate(str));
    }

    private static boolean Calculate(String str) {
        str = str.trim();
        boolean eSeen = false;
        boolean numberSeen = false;
        boolean pointSeen = false;
        boolean numberAfterE = false;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (Character.isDigit(c))
            {
                numberSeen = true;
                numberAfterE = true;
            }
            else if (c == 'e')
            {
                if (eSeen || !numberSeen) return false;
                eSeen = true;
                numberAfterE = false;
            }
            else if (c == '.')
            {
                if (eSeen || pointSeen) return false;
                pointSeen = true;
            }
            else if (c == '+' || c == '-')
            {
                if (i != 0 || str.charAt(i-1) != 'e') return false;
            }
            else
            {
                return false;
            }
        }

        return numberSeen && numberAfterE;
    }

}
