// Question link -> https://leetcode.com/problems/task-scheduler/

// Solution link -> https://leetcode.com/problems/task-scheduler/solutions/104511/java-solution-priorityqueue-and-hashmap/

class Solution {
    // Approach - Using Priority Queue & HashMap | TC - O(nlogn)
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> tasksCount = new HashMap<>();
        for(char ch: tasks){
            tasksCount.put(ch, tasksCount.getOrDefault(ch,0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(Integer val: tasksCount.values()){
            pq.offer(val);
        }

        int currTime = 0;
        HashMap<Integer,Integer> coolDown = new HashMap<>();
        while(!pq.isEmpty() || !coolDown.isEmpty()){
            // If there's task which cool-down expired, put it into the queue and wait to be processed.
            if(coolDown.containsKey(currTime - n - 1)){
                pq.offer(coolDown.remove(currTime - n - 1));
            }
            if(!pq.isEmpty()){
                int left = pq.poll() - 1;
                if(left != 0){
                    coolDown.put(currTime, left);
                }
            }
            currTime++;
        }
        return currTime;
    }
}

// O(n) Silution -> https://leetcode.com/problems/task-scheduler/solutions/104500/java-o-n-time-o-1-space-1-pass-no-sorting-solution-with-detailed-explanation/
