
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Firma{//} implements Comparable<Firma> {
    String FirmName;
    Worker BigBoss;
    HashSet<Department> DepList = new HashSet<>();
    HashSet<Worker> AllWorkers = new HashSet<>();
    HashMap<String, String> PhoneNumbers = new HashMap<>();
     protected Firma(String firmName,Worker bigBoss) {
        this.FirmName = firmName;
        this.BigBoss = bigBoss;
    }
    public void Add(Department dept){
        AllWorkers.addAll(dept.RabList);
        DepList.add(dept);
        for (Worker person: dept.RabList){
            PhoneNumbers.put(person.Surname, person.phoneNumber);
        }
    }

    public String GetPhoneNumber(String surname) {
        String phoneNumber = PhoneNumbers.get(surname);
        return phoneNumber;
    }
    //    @Override
//    public int compareTo(Firma o) {
//        return 0;
//    }

//    @Override
//    public int compare(Firma o1, Firma o2) {
//        return o1.FirmName.compareTo(o2.FirmName);
//    }
}

