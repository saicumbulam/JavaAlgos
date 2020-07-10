package Leetcode.Medium;

public class CompareVersionNumber {
    public static void main(String[] args) {
        String version1 = "1.0.1", version2 = "1";
        System.out.println(Calculate(version1, version2));
    }

    private static int Calculate(String version1, String version2)
    {
        // splitting is important
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int n1 = v1.length, n2 = v2.length;

        int i1, i2 = 0;

        for (int i = 0; i < Math.max(n1, n2); i++) {
            i1 = i < n1 ? Integer.parseInt(v1[i]) : 0;
            i2 = i < n2 ? Integer.parseInt(v2[i]) : 0;
            if (i1 != i2)
            {
                return i1 > i2 ? 1 : -1;
            }

        }

        return 0;
    }
}
