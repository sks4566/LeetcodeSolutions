package Strings.StringManipulation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReplaceWords_648 {
    public static void main(String[] args) {
        System.out.println();
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> set = new HashSet<>(dictionary);

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            result.append(findRoot(word, set)).append(" ");
        }

        return result.toString().trim();
    }

    private String findRoot(String word, Set<String> set) {
        StringBuilder prefix = new StringBuilder();

        for (char c : word.toCharArray()) {
            prefix.append(c);

            if (set.contains(prefix.toString())) {
                return prefix.toString(); // shortest root found
            }
        }

        return word; // no root found
    }

    // Trie Solution will come back later
    class Solution {

        class TrieNode {
            TrieNode[] children = new TrieNode[26];
            boolean isEnd = false;
        }

        TrieNode root = new TrieNode();

        // Insert word into trie
        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.isEnd = true;
        }

        // Find shortest root
        public String search(String word) {
            TrieNode node = root;
            StringBuilder prefix = new StringBuilder();

            for (char c : word.toCharArray()) {
                int index = c - 'a';

                if (node.children[index] == null) {
                    return word; // no root found
                }

                prefix.append(c);
                node = node.children[index];

                if (node.isEnd) {
                    return prefix.toString(); // shortest root found
                }
            }

            return word;
        }

        public String replaceWords(
                List<String> dictionary, String sentence) {

            // build trie
            for (String word : dictionary) {
                insert(word);
            }

            String[] words = sentence.split(" ");
            StringBuilder result = new StringBuilder();

            for (String word : words) {
                result.append(search(word)).append(" ");
            }

            return result.toString().trim();
        }
    }
}
