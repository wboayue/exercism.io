import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class School {

  private Map<Integer, List<String>> db = new HashMap<>(); 

  public School add(String student, int grade) {
    this.db.putIfAbsent(grade, new ArrayList<String>());
    this.db.get(grade).add(student);
    return this;
  }

  public Map<Integer, List<String>> db() {
    return Collections.unmodifiableMap(this.db);
  }

  public Map<Integer, List<String>> sort() {
    Map<Integer, List<String>> sorted = new HashMap<>();
    for (Map.Entry<Integer, List<String>> entry : this.db.entrySet()) {
      List<String> students = new ArrayList(entry.getValue());
      Collections.sort(students);
      sorted.put(entry.getKey(), students); 
    }
    return sorted;
  }

  public List<String> grade(int number) {
    return this.db.getOrDefault(number, Collections.EMPTY_LIST);
  }

}