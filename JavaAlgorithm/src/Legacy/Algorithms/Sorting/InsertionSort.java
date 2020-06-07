package Legacy.Algorithms.Sorting;

class ArrayIns{
    private long[] a;
    private int nElems;

    public ArrayIns(int max){
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value){
        a[nElems] = value;
        nElems++;
    }

    public void display(){
        for (int i = 0; i < nElems; i++) {
            System.out.println(a[i] + " ");
            System.out.println("");
        }
    }

    public void insertionSort(){
        int in;

        for (int out = 1; out < nElems; out++) { // out is the dividing line
            long temp = a[out];                  // remove marked item
            in = out;

            while(in > 0 && a[in-1] >= temp){  // until one is smaller
                a[in] = a[in-1];               // shift item to right
                in--;                          // go left one position
            }
            a[in] = temp;                      // insert marked item
        }
    }
}

public class InsertionSort {
    public static void main(String[] args) {
        int maxSize = 100;
        ArrayIns arr;

        arr = new ArrayIns(maxSize);

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

        arr.insertionSort();

        arr.display();
    }
}
