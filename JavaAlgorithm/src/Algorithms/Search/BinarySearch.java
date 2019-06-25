package Algorithms.Search;

public class BinarySearch {
    private static BinarySearch search = new BinarySearch();

    private int binarySearch(int[] array, int key){
        int left = 0, right = array.length -1 ;

        while (left <= right) {
            int mid = (left + right)/2;
            if (array[mid] == key) {
                return mid;
            } else if (array[mid] > key){
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int array[] = {2,5,6,8,9,10};
        int key = 5;

        int index = search.binarySearch(array,key);

        if (index != -1) {
            System.out.println("Element found at index" + index);
        } else{
            System.out.println("Element not found");
        }
    }
}
