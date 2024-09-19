
import java.util.HashSet;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aman
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Set<Integer> set = new HashSet<Integer>(10);
        set.add(53);
        set.add(21);
        set.add(82);
        set.add(55);
        set.add(92);
        set.add(66);
        set.add(10);
        set.add(86);
        set.add(55);
        set.remove(21);
        set.remove(66);
        set.add(22);
        set.add(75);
        System.out.println(set.size());
    }

}
