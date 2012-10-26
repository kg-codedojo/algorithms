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
public class QuickSortSDOTest {
    @Test public void testPerformance1M(){
        int[] input = TestUtil.generateRandomArray(1000000);
        ArrayList<Integer> list = new ArrayList<Integer>(1000000);
        for (int i = 0; i < input.length; i++) {
            list.add(input[i]);

        }
        Date start = new Date();
        new QuickSortSDO().sort(list, QuickSortSDO.PivotRule.MEDIAN);
        Date end = new Date();
//        TestUtil.saveArray(list.toArray(),"src/test/data/out/SortedIntegerArray1M.txt");
        System.out.println("QuickSortSDO => Performance in mils: " + (end.getTime() - start.getTime()));
    }
}
