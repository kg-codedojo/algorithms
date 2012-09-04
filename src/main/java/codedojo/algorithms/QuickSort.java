package codedojo.algorithms;

import java.util.Arrays;

/**
 * User ~ Date ~ Time: KonstantinG ~ 8/29/12 ~ 5:08 PM
 */
public class QuickSort {
    public static enum TYPE {
        FIRST, LAST, MEDIAN, RANDOM
    }

    private TYPE quickSortType = TYPE.RANDOM;
    private int comparisonCount;

    public QuickSort() {
    }

    public QuickSort(TYPE quickSortType) {
        this.quickSortType = quickSortType;
    }


    public int[] sort(int[] input) {
        if (input == null) return null;
        return sort(input, 0,input.length);
    }

    public int[] sort(int[] input, int start, int end) {
        if (end-start == 0) return input;
        int p = choosePivot(start, end);
        partition(input,p,start,end);
        sort(input,start,p);
        sort(input,p+1,end);
        return input;
    }

    public void partition(int[] input, int p, int start, int end) {
        int pElement = input[p];
        input[p] = input[start];
        p = start;
        input[start] = pElement;
        int i=start+1;
        int j=start+1;
        while(j<end){
            comparisonCount++;
            if(input[p]<=input[j]){
                j++;
            } else {
                int swapElement = input[j];
                input[j] = input[i];
                input[i] = swapElement;
                i++;
                j++;
            }
        }
        pElement = input[p];
        input[p] = input[i-1];
        input[i-1] = pElement;
    }

    public int choosePivot(int start, int end) {
        int result;
        switch (quickSortType){
            case FIRST:
                result = start;
                break;
            case LAST:
                result = end;
                break;
            case MEDIAN:
                result = (end - start) / 2;
                break;
            case RANDOM:
            default:
                result = (int) (Math.random()*(end-start))+start;
                break;
        }
        return result;
    }

    public int[] sortOld(int[] input) {
        if (input == null) return null;
        if (input.length < 2) return input;

        int output[] = new int[input.length];
        int p = choosePivot(input.length, 0);
        int end = input.length - 1;
        for (int i = 1; i < input.length; i++) {
            if (input[0] > input[i]) {
                output[p++] = input[i];
            } else {
                output[end--] = input[i];
            }
        }
        output[p] = input[0];
        if (output.length > 3) {
            int[] leftPart = Arrays.copyOfRange(output, 0, p);
            int[] rightPart = Arrays.copyOfRange(output, p + 1, output.length);
            leftPart = sort(leftPart);
            rightPart = sort(rightPart);
            for (int i = 0; i < leftPart.length; i++) {
                output[i] = leftPart[i];
            }
            for (int i = 0; i < rightPart.length; i++) {
                output[i + p + 1] = rightPart[i];
            }
        }
        return output;
    }

    public void resetComparisonCount() {
        comparisonCount = 0;
    }

    public int getComparisonCount() {
        return comparisonCount;
    }

}
