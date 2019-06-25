package Algorithms.Array;

import java.util.List;

public class DeleteDupsfromSrtArr {
    public static int deleteDuplicates(List<Integer> array){
        if (array.isEmpty()) {
            return 0;
        }

        int writeIndex = 1;
        for (int i = 1; i < array.size(); i++) {
            if (!array.get(writeIndex -1).equals(array.get(i))) {
                array.set(writeIndex++, array.get(i));
            }
        }
        return writeIndex;
    }
}
