package codedojo.algorithms;

import org.junit.Test;
import org.omg.CORBA.ExceptionList;

import java.util.Date;

import static org.fest.assertions.Assertions.assertThat;
import static org.fest.assertions.Fail.fail;

/**
 * Test scenarios:
 * null / RuntimeException("Input array cannot be null")
 * [] / 0
 * [1] / 0
 * [1,1] / 0
 * [1,2] / 0
 * [2,1] / 1
 * [3,2,1] / 3
 * [3,3,1] / 2
 * [1,2,3,4,5,6,7] / 0
 * [1,3,5,2,4,6] / 3
 * input file 100K / ?
 * User ~ Date ~ Time: KonstantinG ~ 9/2/12 ~ 4:30 PM
 */
public class InversionCounterTest {
    private static final InversionCounter inversionCounter = new InversionCounter();
    @Test public void testCountInputNull(){
        try{
            inversionCounter.count(null);
            fail("Method doesn't throw exception for null argument");
        }catch (RuntimeException re){
            assertThat(re.getMessage()).isEqualTo("Input array cannot be null");
        }
    }

    @Test public void testInputEmptyOutZero(){
        assertThat(inversionCounter.count(new int[]{})).isEqualTo(0);
    }
    @Test public void testInput1Out0(){
        assertThat(inversionCounter.count(new int[]{1})).isEqualTo(0);
    }
    @Test public void testInput11Out0(){
        assertThat(inversionCounter.count(new int[]{1,1})).isEqualTo(0);
    }
    @Test public void testInput11111Out0(){
        assertThat(inversionCounter.count(new int[]{1,1,1,1,1})).isEqualTo(0);
    }
    @Test public void testInput12Out0(){
        assertThat(inversionCounter.count(new int[]{1,2})).isEqualTo(0);
    }
    @Test public void testInput21Out1(){
        assertThat(inversionCounter.count(new int[]{2,1})).isEqualTo(1);
    }
    @Test public void testInput321Out3(){
        assertThat(inversionCounter.count(new int[]{3,2,1})).isEqualTo(3);
    }
    @Test public void testInput331Out2(){
        assertThat(inversionCounter.count(new int[]{3,3,1})).isEqualTo(2);
    }
    @Test public void testInput1234567Out0(){
        assertThat(inversionCounter.count(new int[]{1,2,3,4,5,6,7})).isEqualTo(0);
    }
    @Test public void testInput135246Out3(){
        assertThat(inversionCounter.count(new int[]{1,3,5,2,4,6})).isEqualTo(3);
    }
    @Test public void testPerformance100K(){
        int[] input = TestUtil.generateRandomArray(100000);//TestUtil.loadArray("src/test/data/IntegerArray.txt");
        Date start = new Date();
        Date end = new Date();
        int inversions = inversionCounter.count(input);
        assertThat(inversions).isGreaterThan(0);//exact figure cannot be tested due to random input data
        assertThat(end.getTime() - start.getTime()).isLessThan(1000);
    }
    @Test public void testPerformanceSortedArray100KSorted(){
        int[] inputArray = TestUtil.generateRandomArray(100000);
        int[] sortedArray = new MergeSort().sort(inputArray);
        Date start = new Date();
        int inversions = inversionCounter.count(sortedArray);
        Date end = new Date();
        assertThat(inversions).isEqualTo(0);
        assertThat(end.getTime() - start.getTime()).isLessThan(1000);
    }
    @Test public void testPerformanceSortedArray1MUnsorted(){
        int[] inputArray = TestUtil.generateRandomArray(1000000);
        int[] sortedArray = new MergeSort().sort(inputArray);
        sortedArray[sortedArray.length-1]=0;
        Date start = new Date();
        int inversions = inversionCounter.count(sortedArray);
        Date end = new Date();
        assertThat(inversions).isGreaterThan(999990);
        assertThat(inversions).isLessThan(1000000);
        assertThat(end.getTime() - start.getTime()).isLessThan(1000);
    }
}
