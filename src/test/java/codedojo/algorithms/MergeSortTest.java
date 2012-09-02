package codedojo.algorithms;

import org.junit.Test;

import java.net.URL;
import java.util.Arrays;
import java.util.Date;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Test Cases: Input / Output
 *
 *  null / null
 *  [] / []
 *  [1] / [1]
 *  [2,1] / [1,2]
 *  [32851476] / [12345678]
 *  [32851473] / [12334578]
 *  [3185147] / [1134578]
 *
 * Created By: KonstantinG
 * Date,time: 9/2/12, 4:59 PM
 */
public class MergeSortTest {
    static final MergeSort ms = new MergeSort();
    @Test public void testInNullOutNull(){
        assertThat(ms.sort(null)).isNull();
    }
    @Test
    public void testEmpty(){
        assertThat(ms.sort(new int[]{}).length ).isEqualTo(0);
    }

    @Test public void testOneElement(){
        assertThat(ms.sort(new int[]{1}) ).isEqualTo(new int[]{1});
    }

    @Test public void testIn21Out12(){
        assertThat(ms.sort(new int[]{2, 1}) ).isEqualTo(new int[]{1, 2});
    }

    @Test public void test21SubArrays2and1(){
        int[] input = new int[]{2,1};
        assertThat(Arrays.copyOfRange(input,0,input.length/2)).isEqualTo(new int[]{2});
        assertThat(Arrays.copyOfRange(input, input.length / 2, input.length)).isEqualTo(new int[]{1});
    }

    @Test public void testMerge(){
        assertThat(ms.merge(new int[]{2}, new int[]{1})).isEqualTo(new int[]{1,2});
    }

    @Test public void testIn32851476Out12345678(){
        assertThat(ms.sort(new int[]{3,2,8,5,1,4,7,6}) ).isEqualTo(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
    }

    @Test public void testIn32851473Out12334578(){
        assertThat(ms.sort(new int[]{3,2,8,5,1,4,7,3}) ).isEqualTo(new int[]{1, 2, 3, 3, 4, 5, 7, 8});
    }

    @Test public void testIn3185147Out1134578(){
        assertThat(ms.sort(new int[]{3, 1, 8, 5, 1, 4, 7}) ).isEqualTo(new int[]{1, 1, 3, 4, 5, 7, 8});
    }

    @Test public void testIn213Out123(){
        assertThat(ms.sort(new int[]{2,1,3}) ).isEqualTo(new int[]{1, 2, 3});
    }
    @Test public void testIn4231Out1234(){
        assertThat(ms.sort(new int[]{4,2,3,1}) ).isEqualTo(new int[]{1, 2, 3, 4});
    }

    @Test public void testPerformance100K(){
        int[] input = TestUtil.generateRandomArray(100000);//TestUtil.loadArray("src/test/data/IntegerArray.txt");
        Date start = new Date();
        int[] output = ms.sort(input);
        Date end = new Date();
        TestUtil.saveArray(output,"src/test/data/out/SortedIntegerArray.txt");
        System.out.println("MergeSort=> Performance in mils: " + (end.getTime() - start.getTime()));
    }

    @Test public void testPerformance1M(){
        int[] input = TestUtil.generateRandomArray(1000000);
        Date start = new Date();
        int[] output = ms.sort(input);
        Date end = new Date();
        TestUtil.saveArray(output,"src/test/data/out/SortedIntegerArray1M.txt");
        System.out.println("MergeSort=> Performance in mils: " + (end.getTime() - start.getTime()));
    }
}
