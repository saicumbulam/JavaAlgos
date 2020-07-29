package Leetcode.Medium;

import java.util.ArrayList;
import java.util.List;

public class SearchSuggestionSystem {
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
        }

        public List<String> getList(String str)
        {
            List<String> result = new ArrayList<>();
            char[] chars = new char[26];
            StringBuilder prefix = new StringBuilder();
            TrieNode mod = Searcher(str, root, prefix);
            GetWords(prefix.toString(), result, chars, 0, mod);
            return result;
        }

        private TrieNode Searcher (String str, TrieNode root, StringBuilder prefix)
        {
            TrieNode currentNode = root;
            str = str.toLowerCase();

            for (int i = 0; i < str.length(); i++)
            {
                int index = getIndex(str.charAt(i));
                if (currentNode.children[index] == null)
                {
                    break;
                }
                currentNode = currentNode.children[index];
                prefix.append(str.charAt(i));
            }

            return currentNode;
        }

        private void GetWords(String str, List<String> result, char[] chars, int level, TrieNode root)
        {
            if (root.isEndWord)
            {
                StringBuilder temp = new StringBuilder();
                for (int x = 0; x < level; x++)
                {
                    temp.append(String.valueOf(chars[x]));
                }
                result.add(str + temp.toString());
            }

            for (int i = 0; i< 26; i++)
            {
                if (root.children[i] != null)
                {
                    chars[level] = (char)(i + 'a');
                    GetWords(str, result, chars, level+1, root.children[i]);
                }
            }
        }
    }

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();

        Trie trie = new Trie();

        for(String item : products)
        {
            trie.insert(item);
        }

        for (int i = 0; i< searchWord.length(); i++)
        {
            List<String> subList = trie.getList(searchWord.substring(0, i+1));
            if (subList.size() > 3)
            {
                result.add(subList.subList(0,3));
            }
            else
            {
                result.add(subList);
            }

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(suggestedProducts(new String[]{"mobile","mouse","moneypot","monitor","mousepad"},
                "mouse"));
    }
}
