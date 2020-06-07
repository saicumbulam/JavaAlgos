package Legacy.Algorithms.Array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DutchFlag {
    public static enum Color {RED, WHITE, BLUE}

    private static List<Color> dutchFlag(int pivotIndex, List<Color> array){
        Color pivot = array.get(pivotIndex);
        int smaller = 0;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).ordinal() < pivot.ordinal()) {
                Collections.swap(array, smaller++, i);
            }
        }

        int larger = array.size() - 1;
        for (int i = array.size() -1 ; i >= 0; i--) {
            if (array.get(i).ordinal() > pivot.ordinal()) {
                Collections.swap(array, larger--, i);
            }
        }
        return array;
    }

    private static List<Color> dutchFlagClassification(int pivoyIndex, List<Color> array){
        Color pivot = array.get(pivoyIndex);

        int smaller = 0, equal = 0, larger = array.size();

        while (equal < larger){
            if (array.get(equal).ordinal() < pivot.ordinal()) {
                Collections.swap(array, smaller++, equal++);
            } else if(array.get(equal).ordinal() == pivot.ordinal()){
                ++equal;
            } else {
                Collections.swap(array, equal, larger--);
            }
        }
        return array;
    }
}
