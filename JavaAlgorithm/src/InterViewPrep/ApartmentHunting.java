package InterViewPrep;

import java.util.Map;
import java.util.List;


public class ApartmentHunting {

    // time: o(br) | space: o(br) - where b is the number of buildings and r is the
    // number of requirements
    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
        int[][] minDistanceFromBlock = new int[reqs.length][];

        for(int i = 0; i < reqs.length; i++)
        {
            minDistanceFromBlock[i] = getMinDistances(blocks, reqs[i]);
        }

        int[] maxDistanceAtBlocks = getMaxDistanceAtBlocks(blocks,minDistanceFromBlock);
        return getIdxAtMinValue(maxDistanceAtBlocks);
    }


    public static int[] getMinDistances(List<Map<String, Boolean>> blocks, String req)
    {
        int[] minDistances = new int[blocks.size()];
        int closestReqIdx = Integer.MAX_VALUE;
        for(int i = 0; i < blocks.size(); i++)
        {
            if (blocks.get(i).get(req))
            {
                closestReqIdx = i;
            }
            minDistances[i] = Math.abs(i - closestReqIdx);
        }

        for(int i = blocks.size()-1; i >= 0; i--)
        {
            if (blocks.get(i).get(req))
            {
                closestReqIdx = i;
            }
            minDistances[i] = Math.min(minDistances[i], Math.abs(i - closestReqIdx));
        }

        return minDistances;
    }

    private static int[] getMaxDistanceAtBlocks(List<Map<String, Boolean>> blocks,
                                                int[][] minDistanceFromBlock)
    {
        int[] maxDistanceAtBlocks = new int[blocks.size()];

        for(int i = 0; i < blocks.size(); i++)
        {
            int[] minDistanceAtBlock = new int[minDistanceFromBlock.length];

            for(int j = 0; j < minDistanceFromBlock.length; j++)
            {
                minDistanceAtBlock[j] = minDistanceFromBlock[j][i];
            }
            maxDistanceAtBlocks[i] = arrayMax(minDistanceAtBlock);
        }

        return maxDistanceAtBlocks;
    }

    private static int arrayMax(int[] array)
    {
        int max = array[0];
        for(int a : array)
        {
            if(a > max) max = a;
        }
        return max;
    }

    private static int getIdxAtMinValue(int[] array)
    {
        int idxAtMinValue = 0;

        int minValue = Integer.MAX_VALUE;

        for(int i = 0; i < array.length; i++)
        {
            int currentValue = array[i];
            if(currentValue < minValue)
            {
                minValue = currentValue;
                idxAtMinValue = i;
            }
        }

        return idxAtMinValue;
    }
}
