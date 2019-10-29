import java.util.ArrayList;

public class ArrayListExample {
  public static void main(String[] args) {
    ArrayList list = new ArrayList();
    list.add("111");
    list.add("222");
    list.add("333");
    list.add("222");
    list.add(222);

    System.out.println(list);

    list.add(0, "000");
    System.out.println(list);

    System.out.println("index=" + list.indexOf("333"));
    System.out.println(list.remove("222")); // 앞에꺼 1개만 삭제
    System.out.println(list);
    list.remove(222);

    System.out.println("{");
    for(int i=0;i<list.size();i++){
      System.out.println(list.get(i)+", ");
    }
    System.out.println("}");

    for (int i= 0;i < list.size();i++) {
      list.set(i, i+"");
    }
  }
}
