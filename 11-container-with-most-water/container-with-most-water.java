class Solution {
    public int maxArea(int[] height) {
     int n = height.length;
     int left = 0;
     int right = n - 1;
     int water = 0;
     int max_water = 0;

     while(left < right){
        water = (right - left) * Math.min(height[left],height[right]);
        if(height[left] > height[right]){
            right--;
        }
        else{
            left++;
        }
        max_water = Math.max(max_water,water);
     }   
     return max_water;
    }
}