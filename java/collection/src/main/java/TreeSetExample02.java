import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample02 {
  public static void main(String[] args) {
    TreeSet set = new TreeSet();
    int[] score = { 80, 95, 50, 35, 45, 65, 10, 100 };
    for (int i = 0; i < score.length; i++) {
      set.add(new Integer(score[i]));
    }

    // target 보다 큰 값
    System.out.println(set.headSet(new Integer(50)));
    // target 보다 작은 값
    System.out.println(set.tailSet(new Integer(50)));
  }
}
