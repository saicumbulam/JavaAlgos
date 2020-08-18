package Leetcode.Trie.After;

import Leetcode.Trie.Often.Trie;

import java.util.ArrayList;
import java.util.List;

public class FindAllWordsTrie {
    public static void main(String[] args) {
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their","abc"};

        Trie trie = new Trie();

        for (int i = 0; i < keys.length; i++) {
            trie.insert(keys[i]);
        }

        List<String> result = new ArrayList<>();
        char[] chars = new char[26];
        Calculate(trie.root, chars,result, 0);
        System.out.println(result);
    }

    // The fucntion works like a depth first search.
    private static void Calculate(Trie.TrieNode root,
                                  char[] chars,
                                  List<String> result,
                                  int level)
    {
        if (root.isEndWord)
        {
            StringBuilder tmp = new StringBuilder();

            for (int x = 0; x < level; x++) {
                tmp.append(chars[x]);
            }

            result.add(tmp.toString());
        }

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null)
            {
                chars[level] = (char) (i + 'a');
                Calculate(root.children[i], chars, result, level+1);
            }
        }
    }
}
