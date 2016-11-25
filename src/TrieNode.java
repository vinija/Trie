class TrieNode {
    // Initialize your data structure here.
    TrieNode[] nodes;
    char chr;
    boolean isWordEnd;


    public TrieNode() {
        nodes = new TrieNode[26];
        chr='\n';
    }

    public TrieNode(char c){
        this.chr = c;
        isWordEnd=false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if(word == null || word.length()==0){
            return;
        }

        TrieNode node = root;
        for(Character character: word.toCharArray()){
            if(node.nodes[character-'a']==null){
                node.nodes[character-'a']= new TrieNode(character);
            }
            node = node.nodes[character-'a'];
        }
        node.isWordEnd=true;

    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if(word == null || word.length()== 0){
            return false;
        }
        TrieNode node = root;
        for(Character character: word.toCharArray()){
            if(node.nodes[character-'a']==null) {
                node = node.nodes[character - 'a'];
            }
        }
        return  node.isWordEnd;

    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if(prefix== null || prefix.length()==0){
            return false;
        }
        TrieNode node = root;
        for(Character chr : prefix.toCharArray()){
            if(node.nodes[chr-'a']==null){
                return false;
            }
            node = node.nodes[chr-'a'];
        }
        return true;

    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");