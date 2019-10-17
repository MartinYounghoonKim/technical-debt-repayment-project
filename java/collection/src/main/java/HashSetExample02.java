import java.util.HashSet;

public class HashSetExample02 {
  public static void main(String[] args) {
    HashSet hashSet1 = new HashSet();
    HashSet hashSet2 = new HashSet();
    HashSet hashSet3 = new HashSet();

    hashSet1.add(1);
    hashSet1.add(2);
    hashSet1.add(3);
    hashSet1.add(4);

    hashSet2.add(4);
    hashSet2.add(5);
    hashSet2.add(6);

    hashSet3.add(1);
    hashSet3.add(2);

    System.out.println(hashSet1.containsAll(hashSet2));
    System.out.println(hashSet1.containsAll(hashSet3));
  }
}
