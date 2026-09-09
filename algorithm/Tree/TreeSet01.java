package algorithm.Tree;

import java.util.TreeSet;

public class TreeSet01 {
    public static void main(String[] args) {
        TreeSet<Ex01> ts = new TreeSet<>(
                (a,b) -> a.getValue() - b.getValue()
        );

        for(int i = 5; i > 1; i--){
            Ex01 b = new Ex01(i);
            ts.add(b);
        }

        System.out.println(ts);
    }
}
