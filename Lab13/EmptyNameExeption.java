public class EmptyNameExeption extends Exception{
    public EmptyNameExeption() {
        super("Empty name!!!");
    }
    public EmptyNameExeption(String surname) {
        super("Empty name for " + surname);
    }
}
