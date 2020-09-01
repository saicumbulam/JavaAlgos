package InterViewPrep;

public class StringsInterleaving {
    public static void main(String[] args) {
        //String m="abd"; String n="cef"; String p="abcdef";
        String m="abd"; String n="cef"; String p="adcbef";  // order not preserved so false result
        System.out.println(Calculate(m,n,p, 0,0,0));
    }

    private static boolean Calculate(String m , String n , String p, int mIndex, int nIndex, int pIndex)
    {
        if (mIndex == m.length() && nIndex == n.length() && pIndex == p.length())
        {
            return true;
        }

        if (pIndex == p.length())
        {
            return false;
        }

        boolean b1 = false, b2 = false;

        if (mIndex < m.length() && m.charAt(mIndex) == p.charAt(pIndex))
        {
            b1 = Calculate(m,n,p,mIndex+1,nIndex,pIndex+1);
        }

        if (nIndex < n.length() && n.charAt(nIndex) == p.charAt(pIndex))
        {
            b1 = Calculate(m,n,p,mIndex,nIndex+1,pIndex+1);
        }
        return b1 || b2;
    }
}
