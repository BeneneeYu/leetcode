# Case

Store and retrieve keys in string dataset efficiently.

- Auto-Complete
- Spell Check

# Idea

Trie tree is a tree with root, every node of it contains

- a pointer array `children` which stores children nodes
- a boolean parameter `isEnd` to represent if the node is the end of a string

## Insert

Start from the root of trie tree, for the corresponding child node to a character

- If the child node exists, move to the child node and keep searching
- If the child node doesn't exist, create a new child node and record it, move to the new child node

Utill the last character is inserted, mark it as `isEnd = true`

## StartWith

Start from the root of trie tree and look for the prefix. For the child node corresponding to the current character, there are two cases:

- Child node exists. Move along the pointer to the child node and continue searching for the next character.
- Child node does not exist. Description the dictionary tree does not contain this prefix and returns a null pointer.

Repeat the above steps until a null pointer is returned or the last character of the prefix is searched.

If the search reaches the end of the prefix, it indicates that the prefix exists in the dictionary tree. In addition, if `isEnd` of the corresponding node at the end of the prefix is true, it indicates that the string exists in the dictionary tree.

# Template

```java
class Trie {
    private Trie[] children; // [null, ..., null]
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }
    
    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie searchPrefix(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}
```

