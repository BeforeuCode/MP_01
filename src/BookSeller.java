import java.io.Serializable;

public class BookSeller extends ObjectPlus implements Serializable, Person {
    private String name;
    //atrybut klasowy
    private double salary;

    public BookSeller(String name) {
        super();

        this.name = name;
        this.salary = 1500;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    private void setSalary(double salary) {
        this.salary = salary;
    }

    //Metodda klasowa
    public static void changeSalary(double newSalary) throws ClassNotFoundException {
        ObjectPlus.getExtent(BookSeller.class).forEach(e -> {
            e.setSalary(newSalary);
        });
    }

    //Przysłonięcie
    @Override
    public void changeName(String newName) {
        setName(newName);
    }

    //Przeciążenie
    public void changeName(String newName, String title) {
        //title i.e Mr, Mrs
        setName(title + " " + newName);
    }
}
