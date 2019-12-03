import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TreeSetExample03 {
  public static void main(String[] args) {
    HashMap map = new HashMap();
    map.put("martin", new Integer(90));
    map.put("irene", new Integer(85));

    Set set = map.entrySet();
    Iterator it = set.iterator();

    while (it.hasNext()) {
      Map.Entry e = (Map.Entry)it.next();
      System.out.println("이름 : " + e.getKey() + ", 점수 : " + e.getValue());
    }
    set = map.keySet();
    System.out.println(set);
  }
}
