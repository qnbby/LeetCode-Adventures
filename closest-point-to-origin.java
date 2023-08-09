// intro to prio queue
// add sort values in descending order
// then remove biggest element using poll(FIFO) so that final list fits within size k
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] * b[0] + b[1] * b[1] - a[0] * a[0] - a[1] * a[1]);

        for (int[] p : points)
        {
            queue.offer(p);
            if (queue.size() > k)
                queue.poll();
        }

        int[][] fin = new int[k][2];
        for (int i = 0; i < fin.length; i++)
        {
            fin[i] = queue.poll();
        }

        return fin;
    }
}