import java.util.*;

public class MatrixDet {
    public static void main(String[] args){
        int[][] matrix = { { 1, -2, -1, 3 }, { -1, 3, -2, -2 }, { 2, 0, 1, 1 }, { 1, -2, 2, 3 } };
        int[][] test = { { 3, 1, 3, 0 }, { 1, 2, 3, 4 }, { 2, 1, 3, -1 }, { 1, 2, 0, 1 } };
        determinant(test);
    }

    //utilizar el método de gauss-jordan para triangular la matriz
    //y solo tener que multiplicar los valores de la diagonal
    public static int determinant(int[][] matrix){
        int det = 0;

        //utilizar while (variable definida como true, se cambia a false cuando inicia el loop) 
        //y siempre que se encuentre un elemento matrix[i][j] != 0, volverlo a cambiar a true
        boolean temp = true;
        int holder = 0;
        while(temp){
            temp = false;
            for (int i = 0; i < matrix.length; i++) {
                double x = 0.0;
                for (int j = 0; j < matrix.length; j++) {
                    if (matrix[i][j] != 0 && j < i && x == 0.0) {
                        System.out.println(matrix[i][j]);
                        System.out.println(matrix[j][j]);
                        x = (float)-matrix[i][j] / matrix[j][j];
                        System.out.println("x:" + x);
                    }
                    if (x != 0.0) {
                        System.out.println("multiplo: " + x);

                        System.out.println("pre:" + matrix[i][j]);
                        System.out.println("suma:" + matrix[holder][j]);
                        matrix[i][j] = (int) Math.floor((x * matrix[i][j] + matrix[holder][j]));
                        System.out.println("post:" + matrix[i][j]);
                    }
                    if(matrix[matrix.length - 1][matrix.length-1] == 0){
                        for(int y = 0; y < matrix.length; y++){
                            int asdf = matrix[y][3];
                            matrix[y][3] = matrix[y][2];
                            matrix[y][2] = asdf;
                        }
                    }
                }
                System.out.println( "\n" + Arrays.toString(matrix[i]) + "\n");
                // hacer qu opere sobre todo el matrix[i] pero solo si el j < i es == 0

            }
            for(int k = 0; k < matrix.length; k++){
                for(int h = 0; h < matrix[k].length; h++){
                    if(h < k && matrix[k][h] != 0 && matrix[k][k] != 0){
                        temp = true;
                    }
                }
            }
            for (int k = 0; k < matrix.length; k++) {
                System.out.println(Arrays.toString(matrix[k]));
            }
            holder++;
        }
        return det;
    }
}
