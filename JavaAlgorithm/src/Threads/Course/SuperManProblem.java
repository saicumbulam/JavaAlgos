package Threads.Course;

public class SuperManProblem {
    private static volatile SuperManProblem superman;

    private SuperManProblem() {

    }

    public static SuperManProblem getInstance() {

        if (superman == null) {
            synchronized (SuperManProblem.class) {

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
