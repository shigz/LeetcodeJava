package shigz.learn.y22.m9.w4;

/**
 * Created by 大史 on 2022/9/28
 */
public class WordDictionary {

    private final Node root;

    public WordDictionary() {
        this.root = new Node();
    }

    public void addWord(String word) {
        Node currentNode = root;
        int index = 0;
        while (index < word.length()) {
            int currentChar = word.charAt(index) - 97;
            if (currentNode.nodes == null) currentNode.nodes = new Node[26];
            if (currentNode.nodes[currentChar] == null) currentNode.nodes[currentChar] = new Node();
            currentNode = currentNode.nodes[currentChar];
            index++;
        }
        currentNode.isFinished = true;
    }

    public boolean search(String word) {
        return isMatchFrom(word, root, 0);
    }

    private boolean isMatchFrom(String word, Node node, int index) {
        if (index < word.length()) {
            if (node.nodes != null) {
                if (word.charAt(index) == '.') {
                    for (Node subNode : node.nodes) {
                        if (subNode != null && isMatchFrom(word, subNode, index + 1)) return true;
                    }
                    return false;
                } else {
                    int currentChar = word.charAt(index) - 97;
                    if (node.nodes[currentChar] != null) {
                        return isMatchFrom(word, node.nodes[currentChar], index + 1);
                    } else return false;
                }
            } else return false;

        } else return node.isFinished;
    }

    static class Node {
        boolean isFinished = false;
        Node[] nodes = null;
    }

}
