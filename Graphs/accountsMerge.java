// Question link -> https://leetcode.com/problems/accounts-merge/description/

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        Map<String, Integer> emailNodeMap = new HashMap<>();

        for(int i = 0; i < accounts.size(); i++){
            for(int j = 1; j < accounts.get(i).size(); j++){
                String email = accounts.get(i).get(j);
                if(!emailNodeMap.containsKey(email)){
                    emailNodeMap.put(email, i);
                }else{
                    ds.unionBySize(i, emailNodeMap.get(email));
                }
            }
        }

        List<String>[] mergedMails = new ArrayList[n];
        for(int i = 0; i < n; i++){
            mergedMails[i] = new ArrayList<>();
        }

        for(String email: emailNodeMap.keySet()){
            int ulp = ds.findUPar(emailNodeMap.get(email));
            mergedMails[ulp].add(email);
        }

        List<List<String>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(mergedMails[i].size() == 0)  continue;

            Collections.sort(mergedMails[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String email: mergedMails[i]){
                temp.add(email);
            }
            ans.add(temp);
        }

        return ans;
    }
}

class DisjointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    DisjointSet(int V){
        for(int i = 0; i < V; i++){
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node){
        if(node == parent.get(node)){
            return node;
        }

        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionBySize(int u, int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if(ulp_u == ulp_v){
            return;
        }

        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        }else{
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

// Solution video -> https://www.youtube.com/watch?v=FMwpt_aQOGw
