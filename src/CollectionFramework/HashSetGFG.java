package CollectionFramework;
// https://www.javatpoint.com/java-hashset

import java.util.HashSet;
import java.util.Iterator;
// Hashset only store the unique value in the set
// Hashset also work with the objects

public class HashSetGFG {
    public static void main(String[] args) {
        HashSet <Integer> hash = new HashSet<>();

        hash.add(1);
        hash.add(2);
        hash.add(3);
        hash.add(4);

        Iterator<Integer> iterator = hash.iterator();

        System.out.println(hash.contains(5)); // true or false

        // iterator the set
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //size of the set
        System.out.println("size " + hash.size());

        // isempty
        System.out.println(hash.isEmpty());

    }
}
