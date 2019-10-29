import java.util.Arrays;

public class VectorExample01 {
  Object[] objArr;
  int size;
  VectorExample01(int capacity) {
    if (capacity < 0) {
      throw new IllegalArgumentException("유효하지 않은 값입니다.");
    }

    objArr = new Object[capacity];
  }
  VectorExample01 () {
    this(10);
  }
  int size() { return size; }
  int capacity() { return objArr.length; }
  boolean imEmpty() { return size ==0; }
  void clear () {
    for (int i=0; i < objArr.length; i++) {
      objArr[i] = null;
    }
    size = 0;
  }
  Object get(int index) {
    if (index <0 || index >= size) {
      throw new IndexOutOfBoundsException("범위를 벗어났습니다.");
    }
    return objArr[index];
  }
  int indexOf(Object obj) {
    for(int i = 0; i < size; i++) {
      if (objArr[i].equals(obj)) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public String toString() {
    return "VectorExample01{" +
      "objArr=" + Arrays.toString(objArr) +
      ", size=" + size +
      '}';
  }
}
