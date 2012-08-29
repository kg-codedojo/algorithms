package codedojo.framework;

import java.math.BigDecimal;

/**
 * Algorithm Framework is a set of tools Scientific Approach for algorithms analysis which include steps:
 * - Observe
 * - Hypothesize
 * - Predict
 * - Verify
 * - Validate
 *
 * Following principles should be used for algorithm analysis:
 * - Experiments must be reproducible
 * - Hypotheses must be falsifiable
 *
 * User ~ Date ~ Time: KonstantinG ~ 8/29/12 ~ 2:42 PM
 */
public class AlgorithmFramework {

    /**
     * Is used for analysis of running time on a given subset of data
     *
     * When data is big enough running time must be a*N^b, where:
     * - a is relation between amount of data and actual running time
     * - b is a relation between running time growth and data growth.
     *
     * @param algorithm
     * @param data
     * @return
     */
    public AlgorithmAnalysisResults profileAlgorithm(Object algorithm, Object dataManager, Object data){
        throw new RuntimeException("Unimplemented method");
    }

    public static class AlgorithmAnalysisResults{
        public BigDecimal a;
        public BigDecimal b;
        public BigDecimal runningTime;
    }
}
