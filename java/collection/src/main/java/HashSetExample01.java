import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample01 {
  public static void main(String[] args) {
    HashSet<Integer> hashSet = new HashSet();
    hashSet.add(1);
    hashSet.add(2);
    hashSet.add(3);
    hashSet.add(3); // 중복은 허용하지 않는다.

    ArrayList<Integer> arrayList = new ArrayList<Integer>();
    arrayList.add(1);
    arrayList.add(2);
    arrayList.add(3);
    arrayList.add(3);

    Iterator hi = hashSet.iterator();
    while (hi.hasNext()) {
      System.out.println(hi.next());
    }
    System.out.println(" ================== ");
    Iterator there = arrayList.iterator();
    while (there.hasNext()) {
      System.out.println(there.next());
    }
  }
}
