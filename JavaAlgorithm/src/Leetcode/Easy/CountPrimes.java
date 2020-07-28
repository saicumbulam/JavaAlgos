/*
problem:
Count the number of prime numbers less than n.

time complexity is o(n)
space complexity is o(n)

pseudocode:
1. Initialize the bool array n+1. iterate the array from 2 to i*i < n.
2. if !bool[i], iterate from i to 'j'*i < n. mark bool[j*i] true.
3. iterate 2 to n after step 2 completed. get count of !bool[i].
*/
package Leetcode.Easy;

public class CountPrimes {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(Calculate(n));
    }

    private static int Calculate(int n) {
        if (n < 2)
        {
            return 0;
        }
        boolean[] primes = new boolean[n+1];

        // 2 starting number is important
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

        return count;
    }
}
