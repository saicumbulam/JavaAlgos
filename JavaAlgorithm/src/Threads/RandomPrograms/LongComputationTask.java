package Threads.RandomPrograms;

import java.math.BigInteger;

public class LongComputationTask {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new LongComputation(new BigInteger("2"),
                new BigInteger("10")));
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(100);
        thread.interrupt();
    }

    private static class LongComputation implements Runnable
    {
        private BigInteger base;
        private BigInteger power;

        public LongComputation(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            System.out.println(base + "*" + power + "= " + pow(base, power));
        }

        private BigInteger pow(BigInteger base, BigInteger power)
        {
            BigInteger result = BigInteger.ONE;

            for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
                result = result.multiply(base);
            }
            return result;
        }
    }
}
