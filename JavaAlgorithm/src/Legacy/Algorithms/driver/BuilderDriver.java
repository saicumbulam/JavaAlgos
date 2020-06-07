package Legacy.Algorithms.driver;

import DesignPattern.LunchOrderBuilder;

public class BuilderDriver {
    public static void main(String[] args) {
        LunchOrderBuilder.Builder builder = new LunchOrderBuilder.Builder();
        builder.bread("Wheat").condiment("Lettuce").dressing("Mayo").meat("Turkey");

        LunchOrderBuilder lunchOrderBuilder = builder.build();

        System.out.println(lunchOrderBuilder.getBread());
        System.out.println(lunchOrderBuilder.getCondiment());
        System.out.println(lunchOrderBuilder.getDressing());
        System.out.println(lunchOrderBuilder.getMeat());
    }
}
