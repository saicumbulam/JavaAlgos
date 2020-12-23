package InterViewPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bug {
    public static void main(String[] args) {
        List<List<Integer>> A = new ArrayList<>();
        A.add(Arrays.asList(1,2,3,4));
        A.add(Arrays.asList(5,6,7,8));
        A.add(Arrays.asList(9,10,11,12));

        List<List<Integer>> B = performOps(A);
        for (int i = 0; i < B.size(); i++) {
            for (int j = 0; j < B.get(i).size(); j++) {
                System.out.print(B.get(i).get(j) + " ");
            }
        }
    }


    private static List<List<Integer>> performOps(List<List<Integer>> A) {
        List<List<Integer>> B = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            B.add(new ArrayList<Integer>());

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).add(0);
            }

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).set(A.get(i).size() - 1 - j, A.get(i).get(j));
            }
        }
        return B;
    }


}
