package codedojo.algorithms;

/**
 * User ~ Date ~ Time: KonstantinG ~ 8/29/12 ~ 3:09 PM
 */
public interface UF {
    boolean connected(int p, int q);
    void union(int p, int q);
}
