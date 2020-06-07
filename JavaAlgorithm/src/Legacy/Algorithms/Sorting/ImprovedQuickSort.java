package Legacy.Algorithms.Sorting;


class ArrayIqik{
    private long[] theArray;
    private int nElems;

    private ArrayIqik(int max){
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

    public void quickSort(){
        recQuicksort(0, nElems-1);
    }

    private void recQuicksort(int left, int right) {
        int size = right-left + 1;
        if (size < 10) {
            insertionSort(left, right);
        } else {
            long median = medianof3(left, right);
            int partition = partitionIt(left, right, median);
            recQuicksort(left, partition-1);
            recQuicksort(partition+1, right);
        }
    }

    private int partitionIt(int left, int right, long pivot) {
        int leftptr = left;
        int rightptr = right-1;

        while (true) {
            while (theArray[leftptr++] < pivot);
            while (theArray[--rightptr] > pivot);

            if (leftptr >= rightptr) {
                break;
            } else {
                swap(leftptr, rightptr);
            }
        }
        swap(leftptr, right-1);   // restore pivot
        return leftptr;                // return pivot location
    }

    private long medianof3(int left, int right) {
        int center = (left + right)/2;

        if (theArray[left] > theArray[center]) {
            swap(left, center);
        }
        if (theArray[left] > theArray[right]) {
            swap(left, right);
        }
        if (theArray[center] >  theArray[right]) {
            swap(center, right);
        }
        swap(center, right-1); // put pivot on right
        return theArray[right-1]; // return median value
    }

    private void swap(int left, int right) {
        long temp = theArray[left];
        theArray[left] = theArray[right];
        theArray[right] = temp;
    }

    private void insertionSort(int left, int right) {
        int in, out;
        for (out = left+1;  out <= right ; out++) {
            long temp = theArray[out];
            in = out;

            while (in > left && theArray[in-1] >= temp){
                theArray[in] = theArray[in-1];
                in--;
            }
            theArray[in] = temp;
        }
    }
}
public class ImprovedQuickSort {
}
