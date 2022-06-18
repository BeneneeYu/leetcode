package dataStructure.trie.question745;

/**
 * @program: Leetcode
 * @description: Design a special dictionary with some words that searchs the words in it by a prefix and a suffix.
 * @author: Shen Zhengyu
 * @create: 2022-06-18 09:58
 **/

class WordFilter {
    Trie trie; // root

    //  Initializes the object with the words in the dictionary.
    public WordFilter(String[] words) {
        trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String post = "{" + word;
            for (int j = 0; j < word.length(); j++) {
                Trie cur = trie;
                cur.weight = i;
                for (int k = j; k < word.length(); k++) {
                    int childPos = word.charAt(k) - 'a';
                    if (cur.children[childPos] == null) {
                        cur.children[childPos] = new Trie();
                    }
                    cur = cur.children[childPos];
                    cur.weight = i;
                }
                for (int m = 0; m < post.length(); m++) {
                    int childPos = post.charAt(m) - 'a';
                    if (cur.children[childPos] == null) {
                        cur.children[childPos] = new Trie();
                    }
                    cur = cur.children[childPos];
                    cur.weight = i;
                }
            }
        }
    }

    /*
    Returns the index of the word in the dictionary, which has the prefix prefix and the suffix suffix.
    If there is more than one valid index, return the largest of them. If there is no such word in the dictionary, return -1.
     */
    public int f(String prefix, String suffix) {
        Trie cur = trie;
        for (char letter : (suffix + '{' + prefix).toCharArray()) {
            if (cur.children[letter - 'a'] == null) return -1;
            cur = cur.children[letter - 'a'];
        }
        return cur.weight;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
