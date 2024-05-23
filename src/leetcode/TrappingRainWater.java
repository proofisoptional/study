package leetcode;

public class TrappingRainWater {

    public static int helper(int[] height, int from, int to){
        int blocked = 0;
        for(int i = from+1; i<to; i++){
            blocked = blocked + height[i];
        }
        int minheight = height[from] < height[to] ? height[from] : height[to];
        int res = minheight * (to - from - 1) - blocked;
        return res;
    }
    public static int trap(int[] height) {
        int l = 0, r = height.length - 1, sum = 0, lMax = 0, rMax = 0;
        while(l <= r){
            lMax = Math.max(height[l], lMax);
            rMax = Math.max(height[r], rMax);
            if(lMax < rMax){
                sum += lMax - height[l++];
            }else{
                sum += rMax - height[r--];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        //System.out.println(trap(new int[]{4,2,0,3,2,5}));
        //System.out.println(trap(new int[]{4,2,3}));
    }
}
