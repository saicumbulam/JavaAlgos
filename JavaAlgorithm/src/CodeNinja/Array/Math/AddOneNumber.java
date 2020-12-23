package CodeNinja.Array.Math;

import java.util.ArrayList;

public class AddOneNumber {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        System.out.println(plusOne(arr));
    }

    public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        for (int i = A.size() - 1; i >= 0; i--)
        {
            if(A.get(i) > 8)
            {
                A.set(i, 0);
                return A;
            }
            else
            {
                A.set(i, A.get(i)+1);
            }
        }

        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(1);

        for(int i = 1; i <= A.size(); i++)
        {
            temp.add(0);
        }

        return temp;
    }
}
