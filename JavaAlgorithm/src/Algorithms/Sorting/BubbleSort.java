package Algorithms.Sorting;


class ArrayBub {
    private long[] a;
    private int nElems;

    public ArrayBub(int max){
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value){
        a[nElems] = value;
        nElems++;
    }

    public void display(){
        for (int i = 0; i <= nElems ; i++) {
            System.out.println(a[i] + " ");
            System.out.println("");
        }
    }

    public void BubbleSort(){

        for (int out = nElems-1; out > 1; out--) { // outer loop (backward)
            for (int in = 0; in < out; in++) { // inner loop (forward)
                if (a[in] == a[in+1]) {  //out of order ?
                    swap(in, in+1);  // swap them
                }
            }
        }
    }

    private void swap (int one, int two){
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
}


public class BubbleSort {
    public static void main(String[] args) {
        int maxSize = 100;
        ArrayBub arr;
        arr = new ArrayBub(maxSize);

        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);

        arr.display();

        arr.BubbleSort();

        arr.display();
    }
}
