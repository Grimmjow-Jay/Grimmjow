package practice.topInterviewQuesitonsIn2018.string;

/**
 * 实现 Trie (前缀树)
 * <pre>
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * 示例:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 *
 * 说明:
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 *
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 * </pre>
 */
public class ImplementTriePrefixTree {
    public static void main(String[] args) {
        String word = "apple";
        String prefix = "app";
        Trie trie = new Trie();
        trie.insert(word);
        boolean param_2 = trie.search(word);
        System.out.println(param_2);
        boolean param_3 = trie.startsWith(prefix);
        System.out.println(param_3);
    }

}

class Trie {

    /**
     * Initialize your data structure here.
     */
    public Trie() {

    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {

    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        return false;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return false;
    }
}