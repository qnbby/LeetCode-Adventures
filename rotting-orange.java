// crazy pseudocode i made while procrastinating on this problem for 3 days
// approach: O(2 m*n) 
// 1st m*n iteration: go through whole array, if spot a 2, add index to queue, if spot a 1, onecount++
// 2nd m*n iteration: queue traversal: dequeue Coords and save it, then look for elements within 1 4-directional to each other. 
// If spot a 1, add it to queue and change grid[row][col] to 2, marking that we've gone through this element. Also, --onecount
// After going through 1 round of queue(dont consider all the elements that added to the queue hence have a 4loop that goes to the size of queue before adding) finalcount++
// at the end, the total one count should be 0 proving that all oranges are accessed and rotted. If yes -> return count else -1
class Solution {
    private class Coords {
        int row;
        int col;
        public Coords(int a, int b)
        {
            this.row = a;
            this.col = b;
        }
    }

    public int orangesRotting(int[][] grid) {
        // go through array look for rotting oranges & put in queue
        // while queue not empty, go through each adjacent 
        int finalCount = 0;
        int n = grid.length;
        int m = grid[0].length;
        int onecount = 0;

        Queue<Coords> queue = new LinkedList<>();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 2)
                    queue.add(new Coords(i, j));
                else if (grid[i][j] == 1)
                    onecount++;
            }
        }
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for (int i = 0; i < size; i++)
            {
                Coords holder = queue.poll();
                int row = holder.row, col = holder.col;
                if (row - 1 >= 0 && grid[row - 1][col] == 1)
                {
                    grid[row - 1][col] = 2; onecount--;
                    queue.add(new Coords(row - 1, col));
                }
                if (row + 1 < n && grid[row + 1][col] == 1)
                {
                    grid[row + 1][col] = 2; onecount--;
                    queue.add(new Coords(row + 1, col));
                }
                if (col - 1 >= 0 && grid[row][col - 1] == 1)
                {
                    grid[row][col - 1] = 2; onecount--;
                    queue.add(new Coords(row, col - 1));
                }
                if (col + 1 < m && grid[row][col + 1] == 1)
                {
                    grid[row][col + 1] = 2; onecount--;
                    queue.add(new Coords(row, col + 1));
                }
            }
            if(queue.isEmpty()) break;
            finalCount++;
        }
            


        return (onecount == 0 ? finalCount : -1);
    }
}