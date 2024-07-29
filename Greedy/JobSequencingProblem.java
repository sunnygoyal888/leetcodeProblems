// Question link -> https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1

// Solution link -> https://takeuforward.org/data-structure/job-sequencing-problem/

class Solution
{
    int[] JobScheduling(Job arr[], int n)
    {
        Arrays.sort(arr, (a,b) -> b.profit - a.profit);
        
        int maxi = 0;
        for(Job job: arr){
            if(job.deadline > maxi){
                maxi = job.deadline;
            }
        }
        
        int[] res = new int[maxi+1];
        
        int countJobs = 0;
        int maxProfit = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = arr[i].deadline; j > 0; j--){
                if(res[j] == 0){
                    res[j] = arr[i].id;
                    countJobs++;
                    maxProfit += arr[i].profit;
                    break;
                }
            }
        }
        
        return new int[]{countJobs, maxProfit};
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/
