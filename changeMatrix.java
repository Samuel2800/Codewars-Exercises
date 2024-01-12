import java.util.*;

public class changeMatrix {

    public static void main(String[] args){
        int[][] matrix = { {2, 1, 1, 1},
                           {1, 3, 1, 1},
                           {1, 1, 4, 1},
                           {1, 1, 1, 5}};
        change(matrix);
        for(int i = 0; i < matrix.length; i++){
            System.out.println(Arrays.toString(matrix[i]));
        }

    }

    public static void change(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < i; j++){
                matrix[i][j] = matrix[j][j];
            }
        }
    }
    
}
