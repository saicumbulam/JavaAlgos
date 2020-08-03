package Leetcode.Trie;

public class Trie {
    public class TrieNode
    {
        public TrieNode[] children;
        public boolean isEndWord;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.isEndWord = false;
        }

        public void MarkAsLeaf()
        {
            this.isEndWord = true;
        }
        public void UnMarkAsLeaf()
        {
            this.isEndWord = false;
        }
    }

    public TrieNode root = null;

    public Trie() {
        root = new TrieNode();
    }

    public int getIndex(int x)
    {
        return x - 'a';
    }

    public void insert(String str)
    {
        TrieNode currentNode = root;
        int index = 0;
        // convert all string to lowercase
        str = str.toLowerCase();
        for (int level = 0; level < str.length(); level++) {
            index = getIndex(str.charAt(level));
            if (currentNode.children[index] == null)
            {
                currentNode.children[index] = new TrieNode();
            }
            currentNode = currentNode.children[index];
        }

        //Mark the current Node as the Leaf. Its children are all
        // null currently
        currentNode.MarkAsLeaf();
    }


    public void Delete(String str)
    {
        if(str == null || str.length() == 0)
        {
            System.out.println("Key does not exist");
            return;
        }

        Deleter(str,root, str.length(), 0);
    }

    private boolean hasNoChildren(TrieNode currentNode)
    {
        for (int i = 0; i < currentNode.children.length; i++) {
            if (currentNode.children[i] != null)
            {
                return false;
            }
        }
        return true;
    }

    private boolean Deleter(String str, TrieNode currentNode, int length, int level)
    {
        boolean deleteSelf = false;

        if (currentNode == null)
        {
            System.out.println("Key does not exist");
            return deleteSelf;
        }

        if (level == length)
        {
            // if its a leaf node. just delete it
            if (hasNoChildren(currentNode))
            {
                currentNode = null;
                deleteSelf = true;
            }
            else
            {
                currentNode.UnMarkAsLeaf();
                deleteSelf = false;
            }
        }
        else
        {
            TrieNode child = currentNode.children[getIndex(str.charAt(level))];
            boolean childDeleted = Deleter(str, child, length, level+1);

            if (childDeleted)
            {
                currentNode.children[getIndex(str.charAt(level))] = null;

                // part of another word. dont do anything
                if (currentNode.isEndWord)
                {
                    deleteSelf = false;
                }
                else if (hasNoChildren(currentNode))
                {
                    currentNode = null;
                    deleteSelf = true;
                }
                else
                {
                    deleteSelf = false;
                }
            }
            else
            {
                deleteSelf = false;
            }
        }

        return deleteSelf;
    }

    public boolean Search(String str)
    {
        TrieNode currentNode = root;

        for (int level = 0; level < str.length(); level++) {
            int index = getIndex(str.charAt(level));
            if (currentNode.children[index] == null)
            {
                return false;
            }
            currentNode = currentNode.children[index];
        }

        if (currentNode.isEndWord)
        {
            return true;
        }
        return false;
    }
}
