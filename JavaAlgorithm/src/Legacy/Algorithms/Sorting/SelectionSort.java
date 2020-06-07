package Legacy.Algorithms.Sorting;


class ArraySel {
    private long[] a;
    private int nElems;

    ArraySel(int max){
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value){
        a[nElems] = value;
        nElems++;
    }

    public void display(){
        for (int i = 0; i < nElems; i++) {
            System.out.println(a[i] + " " );
            System.out.println("");
        }
    }

    public void SelectionSort(){
        int min;

        for (int out = 0; out < nElems-1; out++) {  // outer loop
            min = out;                              // minimum
            for (int in = out+1; in < nElems; in++) {  // inner loop
                if (a[in] < a[min]) {
                    min = in;
                    swap(out, min);
                }
            }
        }
    }

    private void swap(int out, int in) {
        long temp = a[out];
        a[out] = a[in];
        a[in] = temp;
    }
}
public class SelectionSort {
    public static void main(String[] args) {
        int maxSize = 100;
        ArraySel arr;
        arr = new ArraySel(maxSize);

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

        arr.SelectionSort();

        arr.display();
    }
}
