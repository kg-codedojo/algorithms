package codedojo.algorithms;

/**
 * O(N) initialize
 * O(N) union
 * O(N) find (at worst if tree is N objects tall)
 *
 * O(N^2) alg for processing sequence for N elements of N objects
 *
 * User ~ Date ~ Time: KonstantinG ~ 8/29/12 ~ 2:27 PM
 */
public class QuickUnionUF implements UF{
    private int[] id;

    public QuickUnionUF(int N) {
        this.id = new int[N];
        for(int i=0;i<N;i++){
            id[i] = i;
        }
    }

    public boolean connected(int p, int q){
        return root(p) == root(q);
    }

    public void union(int p, int q){
        int ridq = root(id[p]);
        int ridp = root(id[q]);
        id[ridq] = id[ridp];
    }

    private int root(int i) {
        while(i!=id[i]){
            i=id[id[i]];
        }
        return i;
    }
}
