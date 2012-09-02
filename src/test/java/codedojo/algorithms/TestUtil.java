package codedojo.algorithms;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created By: KonstantinG
 * Date,time: 9/2/12, 5:41 PM
 */
public class TestUtil {
    public static int[] generateRandomArray(int N){
        int output[] = new int[N];
        for(int i=0;i<N;i++){
            output[i] = (int) Math.round(Math.random() * N);
        }
        return output;
    }

    public static int[] loadArray(String filename) {
        try {
            List<Integer> input = new ArrayList<Integer>();

            File file = new File(filename);

            BufferedReader bufRdr = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufRdr.readLine()) != null) {
                input.add(new Integer(line.trim()));
            }
            int[] result = new int[input.size()];
            for (int i = 0; i < result.length; i++) {
                result[i] = input.get(i);
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void saveArray(int[] output, String filename) {
        try {
            List<Integer> input = new ArrayList<Integer>();

            File file = new File(filename);

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            String line = null;
            //read each line of text file
            for (int i = 0; i < output.length; i++) {
                writer.write(""+output[i]+"\n");
            }
            writer.flush();
            writer.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
