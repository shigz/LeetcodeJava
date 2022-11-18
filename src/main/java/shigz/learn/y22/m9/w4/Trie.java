package shigz.learn.y22.m9.w4;

/**
 * Created by 大史 on 2022/9/27
 */
public class Trie {

    Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node currentNode = root;
        int index = 0;
        while (index < word.length()) {
            int current = word.charAt(index) - 97;
            if (currentNode.nextNodeArr == null) {
                currentNode.nextNodeArr = new Node[26];
            }
            if (currentNode.nextNodeArr[current] == null) {
                currentNode.nextNodeArr[current] = new Node();
            }
            currentNode = currentNode.nextNodeArr[current];
            index++;
        }
        currentNode.isFinished = true;
    }

    public boolean search(String word) {
        Node currentNode = root;
        int index = 0;
        while (index < word.length()) {
            int current = word.charAt(index) - 97;
            if (currentNode.nextNodeArr == null || currentNode.nextNodeArr[current] == null) {
                return false;
            }
            currentNode = currentNode.nextNodeArr[current];
            index++;
        }
        return currentNode.isFinished;
    }

    public boolean startsWith(String prefix) {
        Node currentNode = root;
        int index = 0;
        while (index < prefix.length()) {
            int current = prefix.charAt(index) - 97;
            if (currentNode.nextNodeArr == null || currentNode.nextNodeArr[current] == null) {
                return false;
            }
            currentNode = currentNode.nextNodeArr[current];
            index++;
        }
        return true;
    }

    static class Node {
        public boolean isFinished = false;
        public Node[] nextNodeArr = null;
    }

}
