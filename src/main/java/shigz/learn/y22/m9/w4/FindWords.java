package shigz.learn.y22.m9.w4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 大史 on 2022/9/28
 */
public class FindWords {

    Node rootNode = new Node();

    public List<String> findWords(char[][] board, String[] words) {
        List<String> resultList = new ArrayList<>();
        addWords(words);
        List<Integer> usedIndex = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                findFrom(i, j, board, resultList, rootNode, usedIndex);
            }
        }
        return resultList;
    }

    private void findFrom(int x, int y, char[][] board, List<String> resultList, Node currentNode, List<Integer> usedIndex) {
        int index = x * board[0].length + y;
        if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && !usedIndex.contains(index)) {
            int currentChar = board[x][y] - 97;
            if (currentNode.nextNodes[currentChar] != null) {
                usedIndex.add(index);
                if (currentNode.nextNodes[currentChar].word != null) {
                    if (!resultList.contains(currentNode.nextNodes[currentChar].word)) {
                        resultList.add(currentNode.nextNodes[currentChar].word);
                    }
                }
                findFrom(x - 1, y, board, resultList, currentNode.nextNodes[currentChar], usedIndex);
                findFrom(x + 1, y, board, resultList, currentNode.nextNodes[currentChar], usedIndex);
                findFrom(x, y - 1, board, resultList, currentNode.nextNodes[currentChar], usedIndex);
                findFrom(x, y + 1, board, resultList, currentNode.nextNodes[currentChar], usedIndex);
                usedIndex.remove(usedIndex.size() - 1);
            }
        }
    }

    private void addWords(String[] words) {
        for (String word : words) {
            Node currentNode = rootNode;
            int index = 0;
            while (index < word.length()) {
                int currentChar = word.charAt(index) - 97;
                if (currentNode.nextNodes[currentChar] == null) {
                    currentNode.nextNodes[currentChar] = new Node();
                }
                currentNode = currentNode.nextNodes[currentChar];
                index++;
            }
            currentNode.word = word;
        }
    }

    static class Node {
        String word = null;
        Node[] nextNodes = new Node[26];
    }

}
