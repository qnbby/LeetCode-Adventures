// topological sort for graphs
// copied solution online because my solution (hash map add to detect cycle) doesn't work
// I still don't fully understand why simply detecting cycles won't suffice, but allas. I copied online. This is not my work. I simply understand how it worked but i'm ashamed to admit that this 
// is not my solution. In conclusion, :(

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) return true;

        List<Integer>[] adjList = new List[numCourses];
        int [] indegree = new int[numCourses];
        int n = 0;

        for (int [] i : prerequisites)
        {
            int course = i[0];
            int prereq = i[1];
            if (adjList[prereq] == null) adjList[prereq] = new ArrayList<>();
            adjList[prereq].add(course);
            indegree[course]++;
        }

        Queue <Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0) queue.offer(i);
        while (!queue.isEmpty())
        {
            int current = queue.poll();
            n++;
            if (adjList[current] != null)
            {
                for (int i : adjList[current])
                {
                    indegree[i]--;
                    if (indegree[i] == 0) queue.offer(i);
                }
            }


        }

        return n == numCourses;
    }
}