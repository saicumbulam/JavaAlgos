package Algorithms.Array;

public class FindDuplicateinArray {
    private static int findDuplicate(int[] array){
        int duplicate = -1;

        for (int i = 0; i < array.length; i++) {
            // get value of current element
            int val = (array[i] < 0) ? -array[i] : array[i];

            // make element at index (val-1) negative if it is positive
            if(array[val -1] >= 0) {
                array[val -1] = -array[val -1];
            } else {
                duplicate = val;
                break;
            }
        }
        for (int j = 0; j < array.length; j++) {
            if(array[j] < 0){
                array[j] = -array[j];
            }
        }
        return duplicate;
    }
    public static void main(String[] args) {
        int[] array = {1,2,3,4,2};
        System.out.println("Duplicate element is: " + findDuplicate(array) );
    }
}
