package model;
public class Customer {
    private int id;
    private String name;
    private String address;
    private String phone;
    private String email;

    public Customer(int id, String name, String address, String phone, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void displayDetails() {
        System.out.println("Customer #" + this.id);
        System.out.println("Customer Name: " + this.name);
        System.out.println("Customer Address: " + this.address);
        System.out.println("Customer Phone: " + this.phone);
        System.out.println("=======================");

    }
}
