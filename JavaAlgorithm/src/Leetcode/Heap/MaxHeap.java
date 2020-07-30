package Leetcode.Heap;

public class MaxHeap {
    static int[] heapArr;
    public static void main(String[] args) {
        heapArr = new int[] {1,2,3,4,5,6};
        for (int i = 0; i < heapArr.length; i++) {
            System.out.println(RemoveMax());
        }
    }

    private static void BuildMaxHeap(int[] heapArr, int heapSize) {

        for (int i = (heapSize-1)/2; i >= 0 ; i--) {
            MaxHeapify(heapArr, i, heapSize);
        }
    }

    private static int RemoveMax()
    {
        BuildMaxHeap(heapArr, heapArr.length);
        int max = heapArr[0];
        heapArr[0] = heapArr[heapArr.length-1];
        return max;
    }

    private static void MaxHeapify(int[] heapArr, int index, int heapSize)
    {
        int largest = index;
        while (largest < heapSize/2)
        {
            int left = (2*index) + 1;
            int right = (2*index) + 2;

            if (left < heapSize && heapArr[left] > heapArr[index])
            {
                largest = left;
            }

            if (right < heapSize && heapArr[right] > heapArr[largest])
            {
                largest = right;
            }

            if (largest != index)
            {
                int temp = heapArr[index];
                heapArr[index] = heapArr[largest];
                heapArr[largest] = temp;
                index = largest;
            }
            else {
                break;
            }
        }
    }
}
