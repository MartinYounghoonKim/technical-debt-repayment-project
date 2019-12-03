import java.util.HashMap;
import java.util.Scanner;

public class HashMapExample01 {
  public static void main(String[] args) {
    HashMap map = new HashMap();
    map.put("a", 1);
    map.put("b", "1");
    map.put("c", new Integer(1));

    Scanner s = new Scanner(System.in);

    while (true) {
      System.out.println("ID 와 Password를 입력해주세요.");
      System.out.print("ID :");
      String id = s.nextLine().trim();

      System.out.print("Password: ");
      String pw = s.nextLine().trim();
      System.out.println();

      if (!map.containsKey(id)) {
        System.out.println("Wrond ID !");
      } else {
        if (!map.get(id).equals(pw)) {
          System.out.println("Wrong Password !");
        } else {
          System.out.println("Great !!!");
          break;
        }
      }
    }
  }
}
