package Leetcode.Thread.Course;

public class SuperManProblem {
    private static volatile SuperManProblem superman;

    private SuperManProblem() {

    }

    public static SuperManProblem getInstance() {

        if (superman == null) {
            synchronized (SuperManProblem.class) { //to limit to only one thread

                if (superman == null) {
                    superman = new SuperManProblem();
                }
            }
        }

        return superman;
    }

    public void fly() {
        System.out.println("I am Superman & I can fly !");
    }
}
