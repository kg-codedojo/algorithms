package codedojo.algorithms;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static org.fest.assertions.Assertions.assertThat;

/**
 *  null / null
 *  [] / []
 *  [1] / [1]
 *  [2,1] / [1,2]
 *  [32851476] / [12345678]
 *  [32851473] / [12334578]
 *  [3185147] / [1134578]
 *
 * User ~ Date ~ Time: KonstantinG ~ 8/29/12 ~ 5:08 PM
 */
public class QuickSortTest {
    private static final InversionCounter inversionCounter = new InversionCounter();

    @Test public void testNull(){
        QuickSort qs = new QuickSort();

        assertThat(qs.sort(null)).isEqualTo(null);
    }

    @Test
    public void testEmpty(){
        QuickSort qs = new QuickSort();
        assertThat(qs.sort(new int[]{}).length ).isEqualTo(0);
    }

    @Test public void testOneElement(){
        QuickSort qs = new QuickSort();
        assertThat(qs.sort(new int[]{1}) ).isEqualTo(new int[]{1});
    }

    @Test public void testIn21Out12(){
        QuickSort qs = new QuickSort();
        assertThat(qs.sort(new int[]{2,1}) ).isEqualTo(new int[]{1,2});
    }

    @Test public void testIn32851476Out12345678(){
        QuickSort qs = new QuickSort();
        assertThat(qs.sort(new int[]{3,2,8,5,1,4,7,6}) ).isEqualTo(new int[]{1,2,3,4,5,6,7,8});
    }

    @Test public void testIn32851473Out12334578(){
        QuickSort qs = new QuickSort(QuickSort.TYPE.RANDOM);
        assertThat(qs.sort(new int[]{3,2,8,5,1,4,7,3}) ).isEqualTo(new int[]{1,2,3,3,4,5,7,8});
    }

    @Test public void testIn3185147Out1134578(){
        QuickSort qs = new QuickSort();
        assertThat(qs.sort(new int[]{3,1,8,5,1,4,7}) ).isEqualTo(new int[]{1,1,3,4,5,7,8});
    }

    @Test public void testIn213Out123(){
        QuickSort qs = new QuickSort();
        assertThat(qs.sort(new int[]{2,1,3}) ).isEqualTo(new int[]{1,2,3});
    }
    @Test public void testIn4231Out1234(){
        QuickSort qs = new QuickSort();
        assertThat(qs.sort(new int[]{4,2,3,1}) ).isEqualTo(new int[]{1,2,3,4});
    }

    @Test public void test(){
        int[] leftPart = Arrays.copyOfRange(new int[]{4,2,3,1}, 0, 2);
        assertThat(leftPart).isEqualTo(new int[]{4,2});
    }
    /**
     * Compute the total number of comparisons used to sort the given input file by QuickSort
     *
     * 1st case: always use the first element of the array as the pivot element
     */
    @Test public void testFirstElementOfTheArrayAsThePivotElement(){
        QuickSort qs = new QuickSort(QuickSort.TYPE.FIRST);
        qs.sort(new int[]{3,8,2,5,1,4,7,6});
        assertThat(qs.getComparisonCount()).isEqualTo(28);
    }

    @Test public void testRANDOMElementOfTheArrayAsThePivotElement(){
        QuickSort qs = new QuickSort(QuickSort.TYPE.RANDOM);
        qs.sort(new int[]{3,8,2,5,1,4,7,6});
        assertThat(qs.getComparisonCount()).isEqualTo(18);
    }

    @Test public void testParition(){
        QuickSort qs = new QuickSort(QuickSort.TYPE.FIRST);
        int[] array = {3, 8, 2, 5, 1, 4, 7, 6};
        qs.partition(array,0,0,8);
        assertThat(array).isEqualTo(new int[]{1, 2, 3, 5, 8, 4, 7, 6});
    }

    @Test public void testPerformance1M(){
        QuickSort qs = new QuickSort(QuickSort.TYPE.FIRST);
        int[] input = TestUtil.generateRandomArray(1000);
        Date start = new Date();
        int[] output = qs.sort(input);
        Date end = new Date();
        assertThat(inversionCounter.count(output)).isEqualTo(0);
        TestUtil.saveArray(output,"src/test/data/out/SortedIntegerArray1M.txt");
        System.out.println("QuickSort=> Performance in mils: " + (end.getTime() - start.getTime()));
    }
}
