package codedojo.algorithms;

import java.util.Arrays;

/**
 * Formal Problem:
 * - Input: array A containing the numbers 1,2,..,n in some arbitary order
 * - Output: number of inversions = number of pairs (i,j) of array indeces with i<j and A[i]>A[j]
 *
 * Motivation: numerical similarity between two ranked lists
 *
 * Example: ranking movies and friends for "collaborative filtering"
 *
 * Created by: KonstantinG
 * Date,time: 9/2/12, 4:29 PM
 */
public class InversionCounter {

    public int count(int[] input) {
        if(input == null){
            throw new RuntimeException("Input array cannot be null");
        }
        if(input.length <= 1){
            return 0;
        }
        return sortAndCount(input).inversions;

    }

    public InversionCounterResult sortAndCount(int[] input){
        if(input == null || input.length == 0){
            throw new RuntimeException("Input array cannot be empty or null");
        }
        if(input.length == 1){
            return new InversionCounterResult(0,input);
        }
        int mid = input.length/2;
        InversionCounterResult A = sortAndCount(Arrays.copyOfRange(input,0,mid));
        InversionCounterResult B = sortAndCount(Arrays.copyOfRange(input,mid,input.length));
        InversionCounterResult Z = mergeAndCount(A,B);
        return Z;
    }

    private InversionCounterResult mergeAndCount(InversionCounterResult A, InversionCounterResult B) {
        int N=A.sortedArray.length + B.sortedArray.length;
        InversionCounterResult result = new InversionCounterResult(A.inversions+B.inversions,new int[N]);
        int i=0;
        int j=0;
        for(int k=0;k<N;k++){
            if(j==B.sortedArray.length || i<A.sortedArray.length && A.sortedArray[i] <= B.sortedArray[j]){
                result.sortedArray[k] = A.sortedArray[i];
                i++;
                result.inversions+=j;
            } else {
                result.sortedArray[k] = B.sortedArray[j];
                j++;
            }
        }
        return result;
    }

    public static class InversionCounterResult{
        public int inversions;
        public int[] sortedArray;

        public InversionCounterResult(int inversions, int[] sortedArray) {
            this.inversions = inversions;
            this.sortedArray = sortedArray;
        }
    }
}
