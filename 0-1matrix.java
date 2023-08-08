// dp problem; 
// finding the minimum distance of a 2d array element to a 0. 
// approach: run through aray 2n^2 time: update distance of adjacent nodes 
// top left, then update min distance from bottom right 
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int inf = mat.length + mat[0].length;
        for (int i = 0; i < mat.length; i++)
        {
            for (int j = 0; j < mat[0].length; j++)
            {
                // case 1: mat[i][j] == 0 -> still
                if (mat[i][j] == 0) continue;
                else // case 2: mat[i][j] = 1
                {
                    int top = inf, left = inf;
                    // 2.1: 
                    if (i - 1 >= 0) top = mat[i - 1][j];
                    if (j - 1 >= 0) left = mat[i][j-1];
                    mat[i][j] = Math.min(top, left) + 1;
                    
                }
            }
        }
        for (int i = mat.length - 1; i >= 0; i--)
        {
            for (int j = mat[0].length - 1; j >= 0; j--)
            {
                // case 1: mat[i][j] == 0 -> still
                if (mat[i][j] == 0) continue;
                else // case 2: mat[i][j] = 1
                {
                    int bot = inf, right = inf;
                    // 2.1: 
                    if (i + 1 < mat.length) bot = mat[i + 1][j];
                    if (j + 1 < mat[i].length) right = mat[i][j+1];
                    mat[i][j] = Math.min(mat[i][j], Math.min(bot, right) + 1);
                    
                }
            }
        }
        return mat;
    }
}