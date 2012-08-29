package codedojo.algorithms;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * User ~ Date ~ Time: KonstantinG ~ 8/29/12 ~ 2:34 PM
 */
public class UFTest {
    @Test public void testAlgorithm(){
        checkUFAlgorithm(new QuickFindUF(10));
    }


    @Test public void testQuickUnion(){
        checkUFAlgorithm(new QuickUnionUF(10));
    }

    //TODO reimplement suing generic approach with random objects and size
    public void checkUFAlgorithm(UF uf){
        uf.union(0,1);
        uf.union(1,6);
        uf.union(0,5);

        uf.union(2,3);
        uf.union(3,9);

        uf.union(7,8);

        assertThat(uf.connected(0,1)).isTrue();
        assertThat(uf.connected(0,5)).isTrue();
        assertThat(uf.connected(0,6)).isTrue();

        assertThat(uf.connected(2,3)).isTrue();
        assertThat(uf.connected(9,3)).isTrue();

        assertThat(uf.connected(7,8)).isTrue();

        assertThat(uf.connected(0,9)).isFalse();
        assertThat(uf.connected(0,8)).isFalse();
        assertThat(uf.connected(0,4)).isFalse();

        assertThat(uf.connected(1,2)).isFalse();

        assertThat(uf.connected(1,7)).isFalse();

        assertThat(uf.connected(4,1)).isFalse();

        assertThat(uf.connected(4,2)).isFalse();

        assertThat(uf.connected(4,8)).isFalse();
    }
}
