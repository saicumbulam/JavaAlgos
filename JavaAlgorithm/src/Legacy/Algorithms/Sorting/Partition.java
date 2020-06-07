package Legacy.Algorithms.Sorting;


class ArrayPar{
    private long[] theArray;
    private int nElems;

    public ArrayPar(int max) {
        theArray = new long[max];
        nElems = 0;
    }

    public void insert(long value){
        theArray[nElems] = value;
        nElems++;
    }

    public void display(){
        for (int i = 0; i < nElems; i++) {
            System.out.println(theArray[i] + " ");
        }
    }

    public int size(){
        return nElems;
    }

    public int partition(int left, int right, long pivot){
        int leftPtr = left-1;
        int rightPtr = right + 1;

        while (true){
            while(leftPtr < right && theArray[++leftPtr] < pivot); // find bigger item

            while(rightPtr > left && theArray[--rightPtr] > pivot); // find smaller item

            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(leftPtr, rightPtr);
            }
        }
        return leftPtr;
    }

    private void swap(int dex1, int dex2) {
        long temp;
        temp = theArray[dex1];
        theArray[dex1] = theArray[dex2];
        theArray[dex2] = temp;
    }
}
public class Partition {
    public static void main(String[] args) {
        int maxSize = 16; // array size
        ArrayPar arr; // reference to array
        arr = new ArrayPar(maxSize); // create the array

        for(int j=0; j<maxSize; j++) // fill array with
        { // random numbers
            long n = (int)(java.lang.Math.random()*199);
            arr.insert(n);
        }
        arr.display(); // display unsorted array
        long pivot = 99; // pivot value

        System.out.print("Pivot is " + pivot);
        int size = arr.size();

        // partition array
        int partDex = arr.partition(0, size-1, pivot);
        System.out.println(", Partition is at index " + partDex);
        arr.display(); // display partitioned array
    }
}
