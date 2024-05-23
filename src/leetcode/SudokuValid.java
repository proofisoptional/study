package leetcode;

//https://leetcode.com/problems/valid-sudoku/

import java.util.*;

public class SudokuValid {
    public static boolean isValidSudoku(char[][] board) {
        Map<Integer, StringBuilder> rows = new HashMap<>();
        Map<Integer, StringBuilder> cols = new HashMap<>();
        Map<Integer, StringBuilder> squares = new HashMap<>();
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[i].length; j++){
                if(board[i][j] != '.'){
                    char character = board[i][j];
                    StringBuilder r = rows.get(i);
                    if(r==null){
                        r = new StringBuilder();
                    } else {
                        if(r.toString().indexOf(character)!=-1){
                            return false;
                        }
                    }
                    StringBuilder c = cols.get(j);
                    if(c==null){
                        c = new StringBuilder();
                    } else {
                        if(c.toString().indexOf(character)!=-1){
                            return false;
                        }
                    }
                    int temp = j/3;
                    int sqindex = (temp) * 3 + (i/3);
                    StringBuilder sq = squares.get(sqindex);
                    if(sq==null){
                        sq = new StringBuilder();
                    } else {
                        if(sq.toString().indexOf(character)!=-1){
                            return false;
                        }
                    }
                    r.append(character);
                    c.append(character);
                    sq.append(character);

                    rows.put(i, r);
                    cols.put(j, c);
                    squares.put(sqindex, sq);
                }
            }
        }
        return true;
    }
}
