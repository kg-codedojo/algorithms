package codedojo.algorithms;

/**
 * O(N) initialize
 * O(N) union
 * O(C) find
 *
 * O(N^2) alg for processing sequence for N elements of N objects
 *
 * User ~ Date ~ Time: KonstantinG ~ 8/29/12 ~ 2:27 PM
 */
public class QuickFindUF implements UF{
    private int[] id;

    public QuickFindUF(int N) {
        this.id = new int[N];
        for(int i=0;i<N;i++){
            id[i] = i;
        }
    }

    public boolean connected(int p, int q){
        return id[p] == id[q];
    }

    public void union(int p, int q){
        int pid = id[p];
        int qid = id[q];
        for(int i=0;i<id.length;i++){
            if(pid == id[i]){
                id[i] = qid;
            }
        }
    }
}
