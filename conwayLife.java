import java.util.Arrays;

//*c preocupa
public class conwayLife {
    public static void main(String[] args){
        int[][] cells = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
                          { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
                          { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, 
                          { 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 }, 
                          { 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 },
                          { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 }, 
                          { 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 }, 
                          { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
                          { 0, 1, 0, 0, 1, 0, 0, 0, 1, 0 }, 
                          { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
        // int[][] cells2 = { { 1, 0, 0},
        //                    { 0, 1, 1},
        //                    { 1, 1, 0} };
        for(int i = 1; i < 41; i++){
            visualGrid(getGeneration(cells, i));
        }
    }

    public static void visualGrid(int[][] cells){
        String[][] grid = new String[cells.length][cells[0].length];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (cells[i][j] == 0) {
                    grid[i][j] = "░░";
                } else if (cells[i][j] == 1) {
                    grid[i][j] = "▓▓";
                }
            }
            System.out.println(Arrays.toString(grid[i]));

        }
    }

    public static int[][] getGeneration(int[][] cells, int generations) {
        while(generations > 0){
            int[][] after = new int[cells.length][cells[0].length];
            int dead = 0;
            for(int i = 0; i < cells.length; i++){
                for(int j = 0; j < cells[0].length; j++){
                    if(cells[i][j] == 0){
                        dead++;
                    }
                    int count = 0;
                    if(i > 0){
                        if(j > 0 && cells[i - 1][j - 1] == 1){
                            count++;
                        }
                        if(cells[i - 1][j] == 1){
                            count++;
                        }
                        if(j + 1 < cells[i].length && cells[i - 1][j + 1] == 1){
                            count++;
                        }
                    }
                    if(j > 0 && cells[i][j-1] == 1){
                        count++;
                    }
                    if(j + 1 < cells[i].length && cells[i][j + 1] == 1){
                        count++;
                    }
                    if(i + 1 < cells.length){
                        if(j > 0 && cells[i + 1][j - 1] == 1){
                            count++;
                        }
                        if(cells[i + 1][j] == 1){
                            count++;
                        }
                        if(j + 1 < cells[i].length && cells[i + 1][j + 1] == 1){
                            count++;
                        }
                    }
                    if(cells[i][j] == 1 && (count == 2 || count == 3)){
                        after[i][j] = 1;
                    }
                    else if(cells[i][j] == 0 && count == 3){
                        after[i][j] = 1;
                    }
                    else{
                        after[i][j] = 0;
                    }
                }
            }
            cells = after;
            generations --;
            if(dead == (cells.length * cells[0].length)){
                return new int[][]{{}};
            }
        }
        return cells;
    }
}
