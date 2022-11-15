//1.1480.EASY. RUNNING SUM OF AN ARRAY
// Daily practice
//time complexity:O(n);
//Space complexity:O(1);
//Any doubts:NA;

class Solution {
    public int[] runningSum(int[] nums) {
        int n=nums.length;
        int[] runningsum=new int[n];
        runningsum[0]=nums[0];
        for(int i=1;i<n;i++)
        {
            runningsum[i]=runningsum[i-1]+nums[i];
        }
        return runningsum;
    }
}



2.724.EASY. FIND PIVOT INDEX
//Time complexity:0(n)+0(n)=0(2n)=>0(n);
//Space Complexity:O(n); space of the rsum array
//Any doubts;NA;
class Solution {
    public int pivotIndex(int[] nums) {
        int result=-1;
        
        //Getting the size for building the new sum array
        int n=nums.length;
        
        //Declare a array
        int[] rsum=new int[n];
        
        rsum[0]=nums[0];
        //Getting the running sum going towards right
        for(int i=0;i<n;i++)
        {
            if(i>0)
            {
                rsum[i]=rsum[i-1]+nums[i];
            }
        }
        
        if(rsum[n-1]==nums[n-1])
        {
            //return n-1 index
            result= n-1;
        }
        else
        {
            rsum[n-1]=nums[n-1];
        }
        //Getting the running sum going towards left
        for(int i=n-2;i>=0;i--)
        {
            int temp =rsum[i+1]+nums[i];
            //If we get the sum equal, return the index
            if(temp==rsum[i])
            {
                result=i;
            }
            else
            {
                rsum[i]=temp;
            }
        }
        return result;
    }
}
