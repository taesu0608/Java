package algorithm.Hash;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class HashSetWithCC {
    public static void main(String[] args) {
        Set<String> synchronizedSet = Collections.synchronizedSet(new HashSet<String>());
    }
}
