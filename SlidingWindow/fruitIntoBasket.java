// Question link -> https://leetcode.com/problems/fruit-into-baskets/description/
/*
You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.

You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.
*/

// Input: fruits = [1,2,3,2,2]
// Output: 4

class Solution {
  // Approach 2 - Sliding Window | TC - O(n)
  public int totalFruit(int[] fruits) {
      int i = 0;
      HashMap<Integer, Integer> map = new HashMap<>();
      int ans = 0;
      for(int j = 0; j < fruits.length; j++){
          map.put(fruits[j], map.getOrDefault(fruits[j],0)+1);
          while(map.size() > 2){
              map.put(fruits[i], map.get(fruits[i])-1);
              if(map.get(fruits[i]) == 0){
                  map.remove(fruits[i]);
              }
              i++;
          }
          ans = Math.max(ans, j-i+1);
      }
      return ans;
  }

  /* Approach 1 - Brute Force | TC - O(n^2)
  public int totalFruit(int[] fruits) {
      int maxPick = 0;
      for(int i = 0; i < fruits.length; i++){
          HashSet<Integer> basket = new HashSet<>();
          int j = i;
          while(j < fruits.length){
              if(!basket.contains(fruits[j]) && basket.size() == 2){
                  break;
              }
              basket.add(fruits[j]);
              j++;
          }
          maxPick = Math.max(maxPick, j-i);
      }
      return maxPick;
  }
  */
}
