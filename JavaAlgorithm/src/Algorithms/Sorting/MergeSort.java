package Algorithms.Sorting;

class ArrayMer{
    private long[] theArray;
    private int nElemn;
    private long[] aux;

    public ArrayMer(int max){
        theArray = new long[max];
        nElemn++;
    }

    public void insert(long value){
        theArray[nElemn] = value;
        nElemn++;
    }

    public void display() {
        for (int i = 0; i < nElemn ; i++) {
            System.out.println(theArray[i] + " ");
        }
    }

    public void mergeUp(){
        aux = new long[theArray.length-1];
        sortup(theArray, 0, theArray.length-1);
    }

    private void sortup(long[] a, int lo, int hi){
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi -lo)/2;
        sortup(a, lo, mid);
        sortup(a, mid+1, hi);
        merge(a, lo, mid, hi);
    }

    private void merge(long[] a, int lo, int mid, int hi) {
        int i = lo, j = mid+1;
        for (int k = 0; k <= hi ; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi ; k++) {
            if (i >  mid) {
                a[k] = aux[j++];
            }
             else if (j < mid){
                 a[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                aux[k] = aux[j++];
            } else {
                 a[k] = aux[i++];
            }
        }
    }
}

public class MergeSort {
}
