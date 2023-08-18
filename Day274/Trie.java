package Day274;

public class Trie {

    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    class TrieNode {
        private TrieNode[] children;
        private boolean isWord;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }

    public void insertWord(String word) {
        if (word == null || word.isEmpty()) throw new IllegalArgumentException("Invalid input!");
        TrieNode cur = root;
        for (char c : word.toLowerCase().toCharArray()) {
            int index = c - 'a';
            if (cur.children[index] == null) {
                TrieNode node = new TrieNode();
                cur.children[index] = node;
                cur = node;
            } else {
                cur = cur.children[index];
            }
        }
        cur.isWord = true;
    }

    public boolean searchWord(String word) {
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insertWord("cat");
        trie.insertWord("cab");
        trie.insertWord("son");
        trie.insertWord("so");
    }
}
