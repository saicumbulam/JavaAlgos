import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {
    public static void main(String[] args) {
        System.out.println(sequentialDigits(100, 300));
    }

    public static List<Integer> sequentialDigits(int low, int high) {
        String lowValue = String.valueOf(low);
        String highValue = String.valueOf(high);

        int lowLen = lowValue.length();
        int upperLen = highValue.length();

        String sample = "123456789";
        List<Integer> result = new ArrayList<>();

        for(int length = lowLen; length <= upperLen; length++)
        {
            int i = 0;
            StringBuilder str = new StringBuilder();

            for(int j = 0; j < sample.length(); j++)
            {
                str.append(sample.charAt(j));

                if(j - i + 1 > length)
                {
                    str.deleteCharAt(0);
                    i++;
                }

                if(j - i + 1 == length)
                {
                    int value = Integer.parseInt(str.toString());
                    if(value >= low && value <= high)
                    {
                        result.add(value);
                    }
                }
            }
        }
        return result;
    }
}
