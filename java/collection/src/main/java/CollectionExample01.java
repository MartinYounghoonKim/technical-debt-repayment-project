// https://www.opentutorials.org/course/1223/6446 참고

import java.util.ArrayList;

public class CollectionExample01 {
  public static void main(String[] args) {
    String[] arrayObj = new String[2];
    arrayObj[0] = "one";
    arrayObj[1] = "two";
//    arrayObj[2] = "two"; // Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 2
    System.out.println(arrayObj);
    ArrayList<String> arrayList = new ArrayList();
    arrayList.add("test01"); // Object 데이터 타입으로 저장된다.
    arrayList.add("test02");

    for (int i = 0; i < arrayList.size(); i++) {
      String value = arrayList.get(i);
      System.out.println(value);
    }
  }
}
