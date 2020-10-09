package InterViewPrep;

import java.util.List;

public class ValidateSubsequence {
    public static void main(String[] args) {

    }

    private static boolean Calculate(List<Integer> array, List<Integer> sequence)
    {
        int seqIdx = 0;

        for (int val: array
             ) {
            if(seqIdx == sequence.size())
            {
                break;
            }
            if(sequence.get(seqIdx).equals(val))
            {
                seqIdx++;
            }
        }

        return seqIdx == sequence.size();
    }
}
