package Opgave1;

public class Customer implements Comparable<Customer> {
    private int age;
    private String firstName;
    private String lastName;

    public Customer(int age, String firstName, String lastName) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String toString() {
        return this.firstName + " " + this.lastName;
    }

    @Override
    public int compareTo(Customer customer) {
        int comp = lastName.compareTo(customer.getLastName());
        if (comp == 0) {
            comp = firstName.compareTo(customer.getFirstName());
            if (comp == 0) {
                comp = age-customer.getAge();
            }
        }
        return comp;
    }
}