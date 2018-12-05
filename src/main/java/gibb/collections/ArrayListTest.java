package gibb.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Daniel Senften <daniel@senften.org>
 * Date: 05.12.18, 22:11
 */
public class ArrayListTest {

    public static void main(String[] args) {

        List<Integer> myList = new ArrayList<>(3);

        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);

        for (Integer number : myList) {
            System.out.println(number);
        }
    }
}
