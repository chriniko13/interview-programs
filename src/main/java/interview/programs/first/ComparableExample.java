package interview.programs.first;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class ComparableExample {

    public static void main(String[] args) {

        // 1st example...
        TreeSet<Dog> dset = new TreeSet<>();
        dset.add(new Dog(2));
        dset.add(new Dog(1));
        dset.add(new Dog(3));
        dset.add(new Dog(4));
        dset.add(new Dog(5));

        Iterator<Dog> iterator = dset.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }


        // 2nd example...
        System.out.println();
        HashSet<Dog> hset = new HashSet<>();
        hset.add(new Dog(2));
        hset.add(new Dog(1));
        hset.add(new Dog(3));
        hset.add(new Dog(5));
        hset.add(new Dog(4));

        Iterator<Dog> hsetIterator = hset.iterator();
        while (hsetIterator.hasNext()) {
            System.out.print(hsetIterator.next() + " ");
        }


        // 3rd example...
        System.out.println();
        LinkedHashSet<Dog> lhset = new LinkedHashSet<>();
        lhset.add(new Dog(2));
        lhset.add(new Dog(1));
        lhset.add(new Dog(3));
        lhset.add(new Dog(5));
        lhset.add(new Dog(4));

        Iterator<Dog> lhsetIterator = lhset.iterator();
        while (lhsetIterator.hasNext()) {
            System.out.print(lhsetIterator.next() + " ");
        }
    }

}

class Dog implements Comparable<Dog> {
    int size;

    public Dog(int s) {
        size = s;
    }

    public String toString() {
        return size + "";
    }

    @Override
    public int compareTo(Dog o) {

        if (this.size == o.size) return 0;

        return this.size > o.size ? 1 : -1;
    }
}