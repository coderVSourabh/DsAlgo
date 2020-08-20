package sourabhs.datastructures.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AverageStudentMark {

  private static void maxAverageMark(String [][] list) {

    if(list == null || list.length == 0) return;

    Map<String, List<Float>> studentMark = new HashMap<>();
    for(String[] mark : list) {
      if(mark.length != 2) continue;
      List<Float> marks = studentMark.getOrDefault(mark[0], new ArrayList<>());
      marks.add(Float.parseFloat(mark[1]));
      studentMark.put(mark[0], marks);
    }

    float maxMark = -1;
    String name = "";
    for(String key : studentMark.keySet()) {
      float temp = 0;
      for(float i : studentMark.get(key)) {
        temp += i;
      }

      if(studentMark.get(key).size() != 0)
        temp /= studentMark.get(key).size();

      if(temp > maxMark) {
        maxMark = temp;
        name = key;
      }
    }

    System.out.println(name + " has highest mark: " + maxMark);
  }
  
  public static void main(String arg[]) {
    String arr[][] = {
      {"Test", "10"},
      {"Test1", "40"},
      {"Test2", "50"},
      {"Test", "95"},
    };
    maxAverageMark(arr);

  }
}