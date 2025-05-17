class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        Stack<Integer> s = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=m-1;i>=0;i--){
          int num = nums2[i];
          while(!s.isEmpty() && s.peek() <= num){
            s.pop();
          } 
          if(s.isEmpty()){
            map.put(num,-1);
          }
          else{
            map.put(num,s.peek());
          }
          s.push(num);
        }
        for(int i=0;i<n;i++){
            if(map.containsKey(nums1[i])){
                nums1[i] = map.get(nums1[i]);
            }
            else{
                nums1[i] = -1;
            }
        }
        return nums1;
    }
}