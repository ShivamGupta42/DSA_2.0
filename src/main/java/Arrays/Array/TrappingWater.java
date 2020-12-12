package Arrays.Array;

public class TrappingWater {

	public int trap(int[] height) {
        if(height==null||height.length==0){
            return 0;
        }
        int[] leftHigh= new int[height.length];
        int[] rightHigh= new int[height.length];
        
        leftHigh[0]=height[0];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<height.length;i++){
            if(max<height[i]){
                max=height[i];
            }
            leftHigh[i]=max;
        }
        
        rightHigh[height.length-1]=height[height.length-1];
        max=Integer.MIN_VALUE;
        for(int i=height.length-1;i>=0;i--){
            if(max<height[i]){
                max=height[i];
            }
            rightHigh[i]=max;
        }
        
        int maxRain=0;
        for(int i=0;i<height.length;i++){
            maxRain+=Math.min(leftHigh[i],rightHigh[i])-height[i];
            
        }
        
        return maxRain;
        
    }
}
