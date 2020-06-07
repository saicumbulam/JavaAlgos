package Leetcode.Easy;

public class CountPrimes {
    public static void main(String[] args) {
        int n = 10;
        boolean[] primes = new boolean[n+1];

        for (int i = 2; i * i < n ; i++) {
            if(!primes[i])
            {
                for (int j = i; j*i < n; j++) {
                    primes[j*i] = true;
                }
            }
        }

        int count = 0;

        for (int i = 2; i < n; i++) {
            if(!primes[i])
            {
                count++;
            }
        }

        System.out.println(count);
    }
}
