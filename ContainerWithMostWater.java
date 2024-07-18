public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        
        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            int currentArea = (right - left) * minHeight;
            maxArea = Math.max(maxArea, currentArea);
            
            // Move the pointer pointing to the smaller height inward
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }
    
    public static void main(String[] args) {
        ContainerWithMostWater container = new ContainerWithMostWater();
        
        // Example usage:
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Max area: " + container.maxArea(heights));
    }
}
