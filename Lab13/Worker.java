public class Worker {
    String Name;
    String Surname;
    double Salary;
    String phoneNumber;
    protected Worker(String name,String surname,double salary) {
        this.Name = name;
        this.Surname = surname;
        this.Salary = salary;
    }
    protected Worker(String name,String surname,double salary,String phoneNumber) {
        this.Name = name;
        this.Surname = surname;
        this.Salary = salary;
        this.phoneNumber = phoneNumber;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Worker worker = (Worker) o;

        if (Double.compare(worker.Salary, Salary) != 0) return false;
        if (!Name.equals(worker.Name)) return false;
        return Surname.equals(worker.Surname);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = Name.hashCode();
        result = 31 * result + Surname.hashCode();
        temp = Double.doubleToLongBits(Salary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
