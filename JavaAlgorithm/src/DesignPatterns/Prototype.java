package DesignPatterns;

import java.util.HashMap;
import java.util.Map;


/* Prototype pattern refers to creating duplicate object while keeping performance in mind.
This type of design pattern comes under creational pattern as this pattern provides
one of the best ways to create an object.

This pattern involves implementing a prototype interface which tells to create a
clone of the current object. This pattern is used when creation of object directly is costly.
For example, an object is to be created after a costly database operation.
We can cache the object, returns its clone on next request and update the database as
and when needed thus reducing database calls.*/

public class Prototype {

    public static void main(String[] args) {
        ColorStore.getColor("blue").addColor();
        ColorStore.getColor("black").addColor();
        ColorStore.getColor("black").addColor();
        ColorStore.getColor("blue").addColor();
    }

    static abstract class Color implements Cloneable {

        protected String colorName;

        abstract void addColor();

        public Object clone() {
            Object clone = null;
            try {
                clone = super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return clone;
        }
    }

    static class blueColor extends Color {
        public blueColor() {
            this.colorName = "blue";
        }

        @Override
        void addColor() {
            System.out.println("Blue color added");
        }

    }

    static class blackColor extends Color {

        public blackColor() {
            this.colorName = "black";
        }

        @Override
        void addColor() {
            System.out.println("Black color added");
        }
    }

    static class ColorStore {

        private static Map<String, Color> colorMap = new HashMap<String, Color>();

        static {
            colorMap.put("blue", new blueColor());
            colorMap.put("black", new blackColor());
        }

        public static Color getColor(String colorName) {
            return (Color) colorMap.get(colorName).clone();
        }
    }
}
