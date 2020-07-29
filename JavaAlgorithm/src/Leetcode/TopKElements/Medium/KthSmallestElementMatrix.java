package Leetcode.Medium;

import java.util.PriorityQueue;

public class KthSmallestElementMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1,  5,  9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int n = 8;

        PriorityQueue<Element> minHeap = new PriorityQueue<>(
                (a,b) -> arr[a.row][a.col] - arr[b.row][b.col]);

        for (int i = 0; i < arr.length; i++) {
            minHeap.add(new Element(i, 0));
        }

        int k = 0;
        while (!minHeap.isEmpty())
        {
            Element polled = minHeap.poll();
            k++;
            if(k == n)
            {
                System.out.println(arr[polled.row][polled.col]);
            }

            if (polled.col < arr[0].length-1)
            {
                minHeap.add(new Element(polled.row, polled.col+1));
            }
        }

    }
}

class Element
{
    int row;
    int col;

    public Element(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
