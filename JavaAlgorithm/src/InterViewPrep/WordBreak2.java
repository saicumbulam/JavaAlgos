package InterViewPrep;

import java.util.*;

public class WordBreak2 {
    public static void main(String[] args) {
        String s = "catsanddog";
        String[] wordDict = {"cat", "cats", "and", "sand", "dog"};
        List<String> list = new ArrayList<>();

        for (String word: wordDict
             ) {
            list.add(word);
        }
        System.out.println(wordBreak(s,list));
    }


    private static TrieNode root;
    private static List<String> result;
    private static char[] input;
    private static Set<Character> lookup;

    public static List<String> wordBreak(String s, List<String> wordDict) {
        result = new ArrayList<>();
        if(s.length() == 0)
            return result;

        lookup = new HashSet<>();
        root = new TrieNode();
        input = s.toCharArray();

        for(String word : wordDict) {
            addWord(word.toCharArray());
        }
        if(isValid())
            splitWord(new StringBuilder(), 0, root);
        return result;
    }

    private static boolean isValid() {
        for(int i = 0; i < input.length; i++) {
            if(lookup.contains(input[i])) continue;
            return false;
        }
        return true;
    }

    private static void splitWord(StringBuilder sb, int i, TrieNode cur) {
        if(i == input.length) {
            result.add(sb.toString());
            return;
        }

        if(sb.length() > 0) sb.append(" ");

        while(i < input.length && cur != null) {
            cur = cur.children[getIndex(input[i])];
            sb.append(input[i]);
            if(cur != null && cur.isEndWord) {
                splitWord(new StringBuilder(sb), i + 1, root);
            }
            i++;
        }
    }

    static class TrieNode {
        TrieNode[] children;
        boolean isEndWord;
        public TrieNode() {
            children = new TrieNode[26];
            isEndWord = false;
        }

        public void MarkAsLeaf(){isEndWord = true; };
        public void UnMarkAsLeaf(){isEndWord = false; };
    }

    private static int getIndex(char c) { return c - 'a';}

    private static void addWord(char[] s) {
        TrieNode cur = root;
        for(int i = 0; i < s.length; i++) {
            lookup.add(s[i]);
            int index = getIndex(s[i]);
            if(cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.isEndWord = true;
    }


}
