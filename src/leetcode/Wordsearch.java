package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Wordsearch {
    public static boolean exist(char[][] board, String word) {
        boolean exists = false;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    char temp = board[i][j];
                    board[i][j] = ' ';
                    exists = existsInAdjacentSquares(board, word.substring(1), i, j);
                    if(exists){
                        return true;
                    } else {
                        board[i][j] = temp;
                    }
                }
            }
        }
        return exists;
    }

    public static boolean existsInAdjacentSquares(char[][] board, String word, int i, int j){
        boolean exists = false;
        if(word.isEmpty()){
            return true;
        }
        char targetChar = word.charAt(0);
        if(i>0){
            if(board[i-1][j] == targetChar){
                char temp = board[i-1][j];
                board[i-1][j] = ' ';
                exists = existsInAdjacentSquares(board, word.substring(1), i-1, j);
                if(exists){
                    return true;
                }
                board[i-1][j] = temp;
            }
        }
        if(i<board.length-1){
            if(board[i+1][j] == targetChar){
                char temp = board[i+1][j];
                board[i+1][j] = ' ';
                exists = existsInAdjacentSquares(board, word.substring(1), i+1, j);
                if(exists){
                    return true;
                }
                board[i+1][j] = temp;
            }
        }
        if(j<board[0].length-1){
            if(board[i][j+1] == targetChar){
                char temp = board[i][j+1];
                board[i][j+1] = ' ';
                exists = existsInAdjacentSquares(board, word.substring(1), i, j+1);
                if(exists){
                    return true;
                }
                board[i][j+1] = temp;
            }
        }

        if(j>0){
            if(board[i][j-1] == targetChar){
                char temp = board[i][j-1];
                board[i][j-1] = ' ';
                exists = existsInAdjacentSquares(board, word.substring(1), i, j-1);
                if(exists){
                    return true;
                }
                board[i][j-1] = temp;
            }
        }


        return exists;

    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCB";
        System.out.println(exist(board, word));
    }
}
