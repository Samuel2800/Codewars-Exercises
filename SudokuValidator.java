import java.util.HashSet;
import java.util.Arrays;

public class SudokuValidator {
    public static void main(String[] args){
        int[][] test = new int[][]{ { 5, 3, 4, 6, 7, 8, 9, 1, 2 },
                                    { 6, 7, 2, 1, 9, 5, 3, 4, 8 },
                                    { 1, 9, 8, 3, 4, 2, 5, 6, 7 },
                                    { 8, 5, 9, 7, 6, 1, 4, 2, 3 },
                                    { 4, 2, 6, 8, 5, 3, 7, 9, 1 },
                                    { 7, 1, 3, 9, 2, 4, 8, 5, 6 },
                                    { 9, 6, 1, 5, 3, 7, 2, 8, 4 },
                                    { 2, 8, 7, 4, 1, 9, 6, 3, 5 },
                                    { 3, 4, 5, 2, 8, 6, 1, 7, 9 } };
        System.out.println(check(test));
    }

    public static boolean check(int[][] sudoku){
        HashSet<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        HashSet<Integer> sub1 = new HashSet<Integer>();
        HashSet<Integer> sub2 = new HashSet<Integer>();
        HashSet<Integer> sub3 = new HashSet<Integer>();
        HashSet<Integer> sub4 = new HashSet<Integer>();
        HashSet<Integer> sub5 = new HashSet<Integer>();
        HashSet<Integer> sub6 = new HashSet<Integer>();
        HashSet<Integer> sub7 = new HashSet<Integer>();
        HashSet<Integer> sub8 = new HashSet<Integer>();
        HashSet<Integer> sub9 = new HashSet<Integer>();
        for(int i = 0; i < sudoku.length; i++){
            int sumHorizontal = 0;
            int sumVertical = 0;
            HashSet<Integer> HorizontalSet = new HashSet<Integer>();
            HashSet<Integer> VerticalSet = new HashSet<Integer>();
            for(int j = 0; j < sudoku[i].length; j++){
                if(!set.contains(sudoku[i][j])){
                    return false;
                }
                HorizontalSet.add(sudoku[i][j]);
                VerticalSet.add(sudoku[j][i]);
                sumHorizontal += sudoku[i][j];
                sumVertical += sudoku[j][i];
            }
            if(sumHorizontal != 45 || sumVertical != 45 || HorizontalSet.size() != 9 || VerticalSet.size() != 9){
                return false;
            }
        }
        for(int k = 0; k < sudoku.length; k++){
            for(int n = 0; n < sudoku[k].length; n++){
                if(k < 3 && k >= 0 && n < 3 && n >= 0){
                    sub1.add(sudoku[k][n]);
                }
                else if(k < 6 && k >= 3 && n < 3 && n >= 0){
                    sub2.add(sudoku[k][n]);
                }
                else if(k < sudoku.length && k >= 6 && n < 3 && n >= 0){
                    sub3.add(sudoku[k][n]);
                }

                else if (k < 3 && k >= 0 && n < 6 && n >= 3) {
                    sub4.add(sudoku[k][n]);
                }
                else if (k < 6 && k >= 3 && n < 6 && n >= 3) {
                    sub5.add(sudoku[k][n]);
                } 
                else if (k < sudoku.length && k >= 6 && n < 6 && n >= 3) {
                    sub6.add(sudoku[k][n]);
                }

                else if (k < 3 && k >= 0 && n < 9 && n >= 6) {
                    sub7.add(sudoku[k][n]);
                } 
                else if (k < 6 && k >= 3 && n < 9 && n >= 6) {
                    sub8.add(sudoku[k][n]);
                } 
                else if (k < sudoku.length && k >= 6 && n < 9 && n >= 6) {
                    sub9.add(sudoku[k][n]);
                }
            }
        }

        return ((sub1.size() == 9) && (sub2.size() == 9) && 
                (sub3.size() == 9) && (sub4.size() == 9) && 
                (sub5.size() == 9) && (sub6.size() == 9) && 
                (sub7.size() == 9) && (sub8.size() == 9) &&
                (sub9.size() == 9));
    }
}
