package Leetcode.Trie.Medium;

import Leetcode.Trie.Trie;

public class TotalWordsTrie {
    public static void main(String[] args) {
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their","abc"};

        Trie trie = new Trie();

        for (int i = 0; i < keys.length; i++) {
            trie.insert(keys[i]);
        }


        System.out.println(Calculate(trie.root));
    }

    private static int Calculate(Trie.TrieNode root)
    {
        int result = 0;

        if (root.isEndWord)
        {
            result++;
        }

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null)
            {
                result += Calculate(root.children[i]);
            }
        }

        return result;
    }
}
