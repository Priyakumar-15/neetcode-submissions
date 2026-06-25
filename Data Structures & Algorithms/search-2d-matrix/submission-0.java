class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length;
        int col=matrix[0].length;
        int l=0;
        int r=row*col-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            int currow=mid/col;
            int curcol=mid%col;
            if(matrix[currow][curcol] == target){
                return true;
            }else if(matrix[currow][curcol] < target){
                l++;
            }else{
                r--;
            }
        }
        return false;
    }
}
