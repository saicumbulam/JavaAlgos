package InterViewPrep;

public class WordDictionary {
    public static void main(String[] args) {
        Trie wordDictionary = new Trie();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True
    }

    static class TrieNode
    {
        TrieNode[] children;
        boolean isEndWord;

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


    static class Trie
    {
        TrieNode root;

        public Trie()
        {
            root = new TrieNode();
        }

        public int getIndex(char c)
        {
            return c - 'a';
        }

        public void addWord(String str)
        {
            TrieNode currentNode = root;

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

        public boolean search(String str)
        {
            return inSearch(str, root);
        }

        public boolean inSearch(String str, TrieNode currentNode)
        {
            for (int i = 0; i < str.length(); i++) {
                int index = getIndex(str.charAt(i));
                if (index < 0 || index > 26 || currentNode.children[index] == null)
                {
                    if (str.charAt(i) == '.')
                    {
                        for (int j = 0; j < currentNode.children.length; j++) {
                            if (currentNode.children[j] != null)
                            {
                                if (inSearch(str.substring(i+1), currentNode.children[j]))
                                {
                                    return true;
                                }
                            }
                        }
                    }

                    return false;
                }
                else
                {
                    currentNode = currentNode.children[index];
                }
            }

            return currentNode.isEndWord;
        }

    }
}
