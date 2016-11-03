/**
 * Created by Julie on 06-10-2016.
 */
public class Test {
    public static void main(String[] args) {
        HashIntSet hash = new HashIntSet();
        hash.add(8);    // 8
        hash.add(9);    // 9
        hash.add(23);   // 3
        hash.add(12);   // 2
        hash.add(33);   // 3
      //  hash.add(99);

        HashIntSet hash2 = new HashIntSet();
        hash2.add(8);
        hash2.add(9);
        hash2.add(23);


    //    hash.addAll(hash2);

        System.out.println(hash.toString());
    }
}
