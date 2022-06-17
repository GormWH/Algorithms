package org.suhong.leetcode.problems.p36;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/valid-sudoku/
class Solution {
    //brute force
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> horizontal = new HashSet<>();
            Set<Character> vertical = new HashSet<>();
            Set<Character> square = new HashSet<>();
            int startRow = (i / 3) * 3;
            int startCol = (i % 3) * 3;
            for (int j = 0; j < 9; j++) {
                char horizontalElement = board[i][j];
                if (isDigit(horizontalElement) && !horizontal.add(horizontalElement)) return false;
                char verticalElement = board[j][i];
                if (isDigit(verticalElement) && !vertical.add(verticalElement)) return false;
                char squareElement = board[startRow + (j / 3)][startCol + j % 3];
                if (isDigit(squareElement) && !square.add(squareElement)) return false;
            }
        }
        return true;
    }

    private boolean isDigit(char c) {
        return 49 <= c && c <=57; // '1' <= c <= '9'
    }

    private boolean checkBoxes(char[][] board) {

        return true;
    }
    /*
    i = 0 => 0,0
    i = 1 => 0,3
    i = 2 => 0,6

    i = 3 => 3,0
    i = 4 => 3,3
    i = 5 => 3,6

    i = 6 => 6,0
    i = 7 => 6,3
    i = 8 => 6,6
     */

    public static void main(String[] args) {
        Solution s = new Solution();

        char[][] board1 = {
                {'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}
        };
        char[][] board2 = {
                {'8','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println(s.isValidSudoku(board1)); // true
        System.out.println(s.isValidSudoku(board2)); // false
    }
}
