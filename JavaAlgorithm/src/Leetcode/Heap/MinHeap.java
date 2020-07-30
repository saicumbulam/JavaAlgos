package Leetcode.Heap;

public class MinHeap {
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
        int min = heapArr[0];
        heapArr[0] = heapArr[heapArr.length-1];
        return min;
    }

    private static void MaxHeapify(int[] heapArr, int index, int heapSize)
    {
        int smallest = index;
        while (smallest < heapSize/2)
        {
            int left = (2*index) + 1;
            int right = (2*index) + 2;

            if (left < heapSize && heapArr[left] < heapArr[index])
            {
                smallest = left;
            }

            if (right < heapSize && heapArr[right] < heapArr[smallest])
            {
                smallest = right;
            }

            if (smallest != index)
            {
                int temp = heapArr[index];
                heapArr[index] = heapArr[smallest];
                heapArr[smallest] = temp;
                index = smallest;
            }
            else {
                break;
            }
        }
    }
}
