package SwordToOffer.NK23.VerifySquenceOfBST___________;

class Solution2 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        return isBST(sequence,0,sequence.length-1);
    }

    private boolean isBST(int[] arr,int start,int end){
        if(start >= end){
            return true;
        }
        int root = arr[end];
        int fence = start;

        for(int i = start;i<end;i++){
            if(arr[i] < root){
                fence++;
            }
        }


        for(int i = fence;i<end;i++){
            if(arr[i] < root && end-fence > 1){
                return false;
            }
        }

        if(fence == start){
            return isBST(arr,fence,end-1);
        }else if(fence == end-1){
            return isBST(arr,start,fence-1);
        }else{
            return isBST(arr,start,fence-1) && isBST(arr,fence,end-1);
        }
    }
}
