package InterViewPrep;

import java.util.ArrayList;
import java.util.List;

public class LetterTilePossibilities {
    public static void main(String[] args) {
        String tiles = "AAB";
        System.out.println(Calculate(tiles));
    }

    private static int Calculate(String tiles) {
        List<List<Character>> result = new ArrayList<>();
        char[] arr = tiles.toCharArray();

        result.add(new ArrayList<>());

        int startIdx = 0;
        int endIdx = 0;

        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            startIdx = 0;
            if (i > 0 && arr[i] == arr[i-1])
            {
                startIdx = endIdx+1;
            }
            endIdx = result.size()-1;
            for (int j = startIdx; j <= endIdx; j++) {
                List<Character> newList = new ArrayList<>(result.get(j));
                newList.add(ch);
                result.add(newList);
            }
        }
        System.out.println(result);
        return result.size()-1;
    }


}
