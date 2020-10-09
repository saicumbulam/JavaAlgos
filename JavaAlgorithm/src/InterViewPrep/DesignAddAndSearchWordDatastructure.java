package InterViewPrep;

import Leetcode.Trie.Often.SearchSuggestionSystem;

import java.util.ArrayList;
import java.util.List;

public class DesignAddAndSearchWordDatastructure {
    static class TrieNode
    {
        public TrieNode[] children;
        public boolean isEndWord;

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

    static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public int getIndex(int x) {
            return x - 'a';
        }

        public void insert(String str) {
            TrieNode currentNode = root;
            str = str.toLowerCase();
            for (int i = 0; i < str.length(); i++) {
                int index = getIndex(str.charAt(i));
                if (currentNode.children[index] == null) {
                    currentNode.children[index] = new TrieNode();
                }
                currentNode = currentNode.children[index];
            }

            currentNode.MarkAsLeaf();
        }


        private boolean search(String str) {
            TrieNode currentNode = root;
            return Calculate(str, currentNode);
        }

        private boolean Calculate(String str, TrieNode root)
        {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                int index = getIndex(c);
                if (c == '.' || root.children[index] == null)
                {
                    if (c == '.')
                    {
                        for (TrieNode child: root.children) {
                            if (child != null && Calculate(str.substring(i+1), child))
                            {
                                return true;
                            }
                        }
                    }
                    return false;
                }
                else
                {
                    root = root.children[index];
                }
            }

            return root.isEndWord;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("a");
        trie.insert("a");
        System.out.println(trie.search(".a"));
        System.out.println(trie.search("a."));
    }
}
