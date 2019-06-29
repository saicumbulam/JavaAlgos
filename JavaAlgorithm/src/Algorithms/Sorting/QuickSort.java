package Algorithms.Sorting;

class Arrayqik{
    private long[] theArray;
    private int nElems;

    public Arrayqik(int max){
        theArray = new long[max];
        nElems = 0;
    }

    public void insert(long value){
        theArray[nElems] = value;
        nElems++;
    }

    public void display(){
        for (int i = 0; i <nElems ; i++) {
            System.out.println(theArray[nElems] + " ");
        }
    }

    public void quickSort(){
        recQuickSort(0, nElems-1);
    }

    private void recQuickSort(int left, int right) {
        if (right - left <= 0) {
            return;
        } else {
            long pivot = theArray[right];
            int partition = partionIt(left, right, pivot);
            recQuickSort(left, partition-1);
            recQuickSort(partition+1, right);
        }
    }

    private int partionIt(int left, int right, long pivot){
        int leftptr = left - 1;
        int rightptr = right;

        while(true){
            while (leftptr < right && theArray[leftptr++] < pivot);

            while (rightptr > 0 && theArray[--rightptr] > pivot);

            if (leftptr > rightptr) {
                break;
            } else {
                swap(leftptr, rightptr);
            }
        }
        return leftptr;
    }

    private void swap(int leftptr, int rightptr) {
        long temp = theArray[leftptr];
        theArray[leftptr] = theArray[rightptr];
        theArray[rightptr] = temp;
    }

}

public class QuickSort {
    public static void main(String[] args) {
        int maxSize = 16; // array size
        Arrayqik arr; // reference to array
        arr = new Arrayqik(maxSize); // create the array
        for(int j=0; j<maxSize; j++) // fill array with
        { // random numbers
            long n = (int)(java.lang.Math.random()*99);
            arr.insert(n);
        }
        arr.display(); // display items
        arr.quickSort(); // quicksort them
        arr.display(); // display them again
    }
}
