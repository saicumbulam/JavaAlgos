package Leetcode.Hash.Often;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class InsertDeleteGetRandom {
    static HashMap<Integer, Integer> map = new HashMap<>();
    static Random random = new Random();
    static List<Integer> list = new ArrayList<>();

    public InsertDeleteGetRandom() { }

    public boolean insert(int val)
    {
        if (map.containsKey(val))
        {
            return false;
        }
        map.put(val, list.size());
        list.add(list.size(), val);
        return true;
    }

    public boolean remove(int val)
    {
        if (!map.containsKey(val))
        {
            return false;
        }
        int index = map.get(val);
        int lastElement = list.get(list.size()-1);
        list.set(index, lastElement);
        list.remove(list.size()-1);
        map.remove(val);
        map.put(lastElement, index);
        return true;
    }

    public int getRandom()
    {
        int rand = random.nextInt(list.size());
        return list.get(rand);
    }
}
