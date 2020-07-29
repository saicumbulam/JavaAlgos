/*
Time complexity : o(logn + k) , logn for binary serach, k for finding k closest numbers
space complexity : o(1)

* */

package Leetcode.Medium;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class FindKClosestElements {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 4;
        int x = -1;
        System.out.println(Calculate(arr, k, x));
    }
    static class Element
    {
        int key;
        int val;

        public Element(int key, int val)
        {
            this.key = key;
            this.val = val;
        }
    }

    private static List<Integer> Calculate (int[] arr, int k, int x)
    {
        int index = binarySearch(arr, x);
        int low = index-k;
        int high = index + x;

        low = Math.max(0,low);
        high = Math.min(high,arr.length-1);

        PriorityQueue<Element> minHeap = new PriorityQueue<>((a,b) -> a.key - b.key);
        for (int i = low; i <= high ; i++) {
            minHeap.add(new Element(Math.abs(arr[i] - x), arr[i]));
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            result.add(minHeap.poll().val);
        }

        Collections.sort(result);
        return result;
    }

    private static int binarySearch(int[] arr, int target)
    {
        int left = 0, right = arr.length-1;
        while (left <= right)
        {
            int mid = left + (right - left)/2;
            if (arr[mid] == target)
            {
                return mid;
            }

            if (arr[mid] > target)
            {
                right = mid-1;
            }
            else
            {
                left = mid+1;
            }
        }

        return -1;
    }
}
