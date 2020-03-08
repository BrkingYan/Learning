package Mr.Left.T25.divide_list;

public class Solution {
    private static class Node{
        Node next;
        int val;
        Node(int val){
            this.val = val;
        }
    }


    /*
    *  9->0->4->5->1 pivot = 3  得到 0->1->9->5->4，保证元素间相对位置不变
    *
    * */
    public void divide(Node head,int pivot){

    }

    public static void main(String[] args) {
        Node[] arr = new Node[]{new Node(5),new Node(3),new Node(1),new Node(2),new Node(4)};
        quickSort(arr,0,arr.length-1);
    }

    private static void quickSort(Node[] arr,int start,int end){
        if (start >= end){
            return;
        }
        int mid = partition(arr,start,end);
        quickSort(arr,start,mid-1);
        quickSort(arr,mid+1,end);
    }

    private static int partition(Node[] arr,int start,int end){
        Node key = arr[start];
        int leftP = start + 1;
        int rightP = end;
        while (true){
            while (arr[leftP].val <= key.val){
                if (leftP == end){
                    break;
                }
                leftP++;
            }
            while (arr[rightP].val >= key.val){
                if (rightP == start){
                    break;
                }
                rightP--;
            }
            if (leftP >= rightP){
                Node temp = arr[start];
                arr[start] = arr[rightP];
                arr[rightP] = temp;
                break;
            }
            Node temp = arr[leftP];
            arr[leftP] = arr[rightP];
            arr[rightP] = temp;
        }
        return rightP;
    }
}
