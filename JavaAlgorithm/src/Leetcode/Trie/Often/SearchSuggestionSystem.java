package Leetcode.Trie.Often;

import java.util.ArrayList;
import java.util.List;

public class SearchSuggestionSystem {
    static class TrieNode
    {
        public TrieNode[] children;
        public boolean isEndWord;
        String word = null;

        public TrieNode()
        {
            children = new TrieNode[26];
            isEndWord = false;
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

    static class Trie
    {
        TrieNode root;

        public Trie()
        {
            root = new TrieNode();
        }

        public int getIndex (int x)
        {
            return x - 'a';
        }

        public void insert(String str)
        {
            TrieNode currentNode = root;
            str = str.toLowerCase();
            for (int i = 0; i < str.length(); i++)
            {
                int index = getIndex(str.charAt(i));
                if (currentNode.children[index] == null)
                {
                    currentNode.children[index] = new TrieNode();
                }
                currentNode = currentNode.children[index];
            }

            currentNode.MarkAsLeaf();
            currentNode.word = str;
        }
    }

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();

        Trie trie = new Trie();

        for(String item : products)
        {
            trie.insert(item);
        }

        TrieNode root = trie.root;
        List<TrieNode> roots = new ArrayList<>();

        // O(L): where L == searchWord length
        // Space O(L)
        for (int i=0; i< searchWord.length(); i++) {
            root = root.children[searchWord.charAt(i) - 'a'];
            if (root == null) break;
            roots.add(root);
        }

        // O(L * m * l): where L == searchWord length
        //             : m == products array length
        //             : l == max length of products
        // Space O(m * l)
        for (TrieNode child: roots) {
            List<String> subList = new ArrayList<>();
            search(child, subList);
            result.add(subList);
        }

        // O(L): where L == searchWord length
        while (result.size() < searchWord.length())
        {
            result.add(new ArrayList<>());
        }
        return result;
    }

    private static void search(TrieNode root, List<String> curr) {
        if (curr.size() >= 3) return;

        if (root.isEndWord)
        {
            curr.add(root.word);
        }

        for (TrieNode child: root.children) {
            if (child != null) {
                search (child, curr);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(suggestedProducts(new String[]{"mobile","mouse","moneypot","monitor","mousepad"},
                "mouse"));
    }
}
