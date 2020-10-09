package InterViewPrep;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MultiStringSearch {

    static class TrieNode
    {
        TrieNode[] children;
        boolean isEndWord;
        String word;

        public TrieNode()
        {
            children = new TrieNode[26];
        }

        public void MarkAsLeaf()
        {
            isEndWord = true;
        }

        public void UnMarkAsLeaf()
        {
            isEndWord = false;
        }
    }


    static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public int getIndex(char c) {
            return c - 'a';
        }

        public void addWord(String str) {
            TrieNode currentNode = root;

            for (int i = 0; i < str.length(); i++) {
                int index = getIndex(str.charAt(i));
                if (currentNode.children[index] == null) {
                    currentNode.children[index] = new TrieNode();
                }
                currentNode = currentNode.children[index];
            }

            currentNode.MarkAsLeaf();
            currentNode.word = str;
        }
    }

    public static void main(String[] args) {
        String big = "this is a big string";
        String[] smallString = {"this", "yo", "is", "a", "bigger", "string", "kappa"};
        System.out.println(multiStringSearch(big, smallString));
    }

    //time: o(ns+bs) | space: o(ns)
    private static List<Boolean> multiStringSearch(String bigString, String[] smallStrings)
    {
        Trie trie = new Trie();
        for (String small: smallStrings) {
            trie.addWord(small);
        }

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < bigString.length(); i++) {
            find(bigString, i, trie, set);
        }

        List<Boolean> result = new ArrayList<>();
        for (String item: smallStrings
             ) {
            result.add(set.contains(item));
        }

        return result;
     }

    private static void find(String str, int startIdx,
                             Trie trie,
                             HashSet<String> set)
    {
        TrieNode curr = trie.root;

        for (int i = startIdx; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if(Character.isLetter(currentChar))
            {
                if(curr.children[trie.getIndex(currentChar)] == null)
                {
                    break;
                }
                curr = curr.children[trie.getIndex(currentChar)];
                if(curr.isEndWord)
                {
                    set.add(curr.word);
                }
            }
        }
    }

}
