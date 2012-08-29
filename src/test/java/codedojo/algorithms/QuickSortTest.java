package codedojo.algorithms;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import sun.font.CoreMetrics;

import java.util.Arrays;

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
        QuickSort qs = new QuickSort();
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
}
