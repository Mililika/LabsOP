

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        try {
            Worker bigboss = new Worker("Geogre", "Kimon", 100000.0, "+3801111111111");
            Worker depboss1 = new Worker("Kirill", "Nemov", 50000.0, "+3806432115665");
            Worker depboss2 = new Worker("Dima", "Dikiy", 60000.0);
            Department vid1 = new Department("Prodaji", depboss1);
            Department vid2 = new Department("Rozrabotki", depboss2);
            Firma firma = new Firma("Brigada", bigboss);
            Firma firmatest = null;
            vid1.Add(new Worker("", "Lenon", 1500.0));
            vid1.Add(new Worker("Piter", "Parker", 70000.0));
            vid2.Add(new Worker("Martin", "Borulya", 10000.0));
            vid1.Add(depboss1);
            vid2.Add(depboss2);
            firma.Add(vid1);
            firma.Add(vid2);

            for (Worker w : vid1.RabList) {
                System.out.println(w.Name + w.Surname);
            }
            System.out.println();
            for (Worker w : vid2.RabList) {
                System.out.println(w.Name + w.Surname);
            }
            System.out.println();
            for (Department d : firma.DepList) {
                System.out.println(d.DepName);
            }
            try{
                FoundTheLowestSalary(firmatest);
            }
            catch (NullPointerException ex){
                System.out.println("NullPointerExeption");
            }
            FoundTheLowestSalary(firma);
            CheckWorkerHighSalary(vid1);
            CheckWorkerHighSalary(vid2);
            WorkersList(firma);
            GetWorkerPhoneNumber(firma);
        }
        catch (EmptyNameExeption ex){
            System.out.println(ex.getMessage());
        }
        finally {
            System.out.println("Program is end");
        }
    }

    public static void FoundTheLowestSalary(Firma firma){
        double zp = 0;
        for(Iterator i = firma.DepList.iterator(); i.hasNext();){
            Object o = i.next();
            if (o instanceof Department) {
                Department dept = (Department) o;
                for (Iterator j = dept.RabList.iterator(); j.hasNext(); ) {
                    Object o1 = j.next();
                    if (o1 instanceof Worker) {
                        Worker worker = (Worker) o1;
                        if (zp < worker.Salary) {
                            zp = worker.Salary;
                        }
                    }
                }
            }
        }
        if (zp < firma.BigBoss.Salary) {
            zp = firma.BigBoss.Salary;
        }
        System.out.println("Найбільша зарплата на підприємтві - "+zp);
    }

    public static void CheckWorkerHighSalary(Department dept){
        for(Iterator<Worker> i = dept.RabList.iterator();i.hasNext();){
            Worker worker = i.next();
            if(worker.Salary > dept.DepBoss.Salary){
                System.out.println("Зарплата, більша, ніж у начальника є у відділі "+dept.DepName+ " у працівника " +worker.Name+" "+worker.Surname);
            }
        }
    }

    public static void WorkersList(Firma firma) throws EmptyNameExeption {
        ArrayList<String> list = new ArrayList<>();
        String combined = firma.BigBoss.Name+" "+firma.BigBoss.Surname;
        list.add(combined);
        for (Department dept : firma.DepList) {
            for (Worker worker : dept.RabList) {
                if(worker.Name.equals("")){
                    throw new EmptyNameExeption(worker.Surname);
                }
                combined = worker.Name+" "+worker.Surname;
                list.add(combined);
            }
        }
        System.out.println("Список усіх співробітників фірми - "+list);
    }
    public static void GetWorkerPhoneNumber(Firma firma) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(firma.GetPhoneNumber(s));

    }

}

