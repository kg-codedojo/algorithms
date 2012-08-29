package codedojo.algorithms;

import java.util.Arrays;

/**
 * User ~ Date ~ Time: KonstantinG ~ 8/29/12 ~ 5:08 PM
 */
public class QuickSort {
    public int[] sort(int[] input) {
        if(input == null) return null;
        if(input.length < 2) return input;

        int output[] = new int[input.length];
        int pivotPosition = 0;
        int end = input.length - 1;
        for(int i = 1; i < input.length;i++){
            if(input[0] > input[i]){
                output[pivotPosition++] = input[i];
            }else{
                output[end--] = input[i];
            }
        }
        output[pivotPosition] = input[0];
        if(output.length > 3 ){
            int[] leftPart = Arrays.copyOfRange(output,0,pivotPosition);
            int[] rightPart = Arrays.copyOfRange(output,pivotPosition+1,output.length);
            leftPart = sort(leftPart);
            rightPart = sort(rightPart);
            for (int i = 0; i < leftPart.length; i++) {
                output[i] = leftPart[i];
            }
            for (int i = 0; i < rightPart.length; i++) {
                output[i+pivotPosition+1] = rightPart[i];
            }
        }
        return output;
    }
}
