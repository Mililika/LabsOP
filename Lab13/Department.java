
import java.util.HashSet;
import java.util.Objects;
import java.util.TreeSet;

public class Department implements Comparable<Department> {
    String DepName;
    Worker DepBoss;
    HashSet<Worker> RabList = new HashSet<>();
    protected Department(String depName, Worker depBoss) {
        this.DepName = depName;
        this.DepBoss = depBoss;
    }
    public void Add(Worker worker){
        RabList.add(worker);
    }

//    @Override
//    public int compare(Department o1, Department o2) {
//        return o1.DepName.compareTo(o2.DepName);
//    }

    @Override
    public int compareTo(Department o) {
        return this.DepName.compareTo(o.DepName);
    }
}
