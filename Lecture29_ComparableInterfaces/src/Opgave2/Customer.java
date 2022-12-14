package Opgave2;

public class Customer implements Comparable<Customer> {
    private String firstName;
    private String lastName;
    private int age;

    public Customer(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Customer compareTo(Customer customer) {
        Customer lastCustomer;
        if (this.lastName.compareTo(customer.getLastName()) < 0) {
            lastCustomer = customer;
        } else if (this.lastName.compareTo(customer.getLastName()) > 0) {
            lastCustomer = this;
        } else {
            if (this.firstName.compareTo(customer.getFirstName()) < 0) {
                lastCustomer = customer;
            } else if (this.firstName.compareTo(customer.getFirstName()) > 0) {
                lastCustomer = this;
            } else {
                if (this.age <= customer.getAge()) {
                    lastCustomer = customer;
                } else {
                    lastCustomer = this;
                }

            }
        }

        return lastCustomer;

    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName + " " + this.age;
    }

}
