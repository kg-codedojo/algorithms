package codedojo.algorithms;

import java.util.Arrays;

/**
 * Sorting algorithm with Time complexity O(n*logn), space complexity is O(n*logn)
 *
 * MergeSort pseudocode:
 * 1. Split array into two sub-arrays
 * 2. Recursively sort 1st half
 * 3. Recursively sort 2nd half
 * 4. Merge two sorted sub-arrays into one
 *
 * Created By: KonstantinG
 * Date,time: 9/2/12, 4:59 PM
 */
public class MergeSort {
    public int[] sort(int[] input) {
        if(input == null || input.length <= 1){
            return input;
        }
        int mid = input.length/2;
        int[] A = sort(Arrays.copyOfRange(input,0,mid));
        int[] B = sort(Arrays.copyOfRange(input,mid,input.length));
        return merge(A,B);
    }

    protected int[] merge(int[] A, int[] B) {
        int N=A.length+B.length;
        int[] result = new int[N];
        int i=0;
        int j=0;
        for(int k=0;k<N;k++){
            if( j==B.length || i<A.length && A[i]<B[j] ){
                result[k]=A[i];
                i++;
            }else{
                result[k]=B[j];
                j++;
            }
        }
        return result;
    }
}
