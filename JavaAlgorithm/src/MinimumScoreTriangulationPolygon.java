import java.util.ArrayList;
import java.util.List;

public class MinimumScoreTriangulationPolygon {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<Integer> list = new ArrayList<>();
        for (int item: arr
             ) {
            list.add(item);
        }
        System.out.println(Calculate(list, 1 , arr.length-1, new ArrayList<>()));
    }

    private static List<Integer> Calculate(List<Integer> list, int start, int end, List<Integer> result)
    {
        if (start == end)
        {
            result.add(list.get(start));
            return new ArrayList<>(result);
        }

        for (int i = start; i <= end ; i++) {
            List<Integer> lefts = Calculate(list, start, i-1, result);
            List<Integer> rights = Calculate(list, i+1, end, result);
            for (int left: lefts
                 ) {
                for (int right: rights
                     ) {
                    result.add(left * right * list.get(i));
                }
            }
        }

        return new ArrayList<>(result);
    }
}
