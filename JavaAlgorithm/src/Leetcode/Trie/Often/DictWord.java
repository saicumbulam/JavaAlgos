package Leetcode.Trie.Often;

public class DictWord {
    public static void main(String[] args) {
        String[] dict = {"the" ,"hello", "there", "answer", "any", "Dragon",
                "world", "their", "inc"};

        String word = "helloworld";

        System.out.println(Calculate(dict, word));
    }

    private static boolean Calculate(String[] dict, String word)
    {
        Trie trie = new Trie();

        for (int i = 0; i < dict.length; i++) {
            trie.insert(dict[i]);
        }

        for (int i = 0; i < word.length(); i++) {
            String first = word.substring(0, i);
            // no i+1 . Its just i
            String second = word.substring(i);

            if (trie.Search(first) && trie.Search(second))
            {
                return true;
            }
        }
        return false;
    }
}
