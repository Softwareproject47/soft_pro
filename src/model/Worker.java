package model;

public class Worker {
    private int id;
    private String name;
    private String address;
    private String phone;
    private WorkerStatus status;

    public Worker(int id, String name, String address, String phone, WorkerStatus status) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.status = status;
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

    public WorkerStatus getStatus() {
        return status;
    }

    public void setStatus(WorkerStatus status) {
        this.status = status;
    }
    
    public void displayWorkerDetails() {
        System.out.println("Worker #" + this.id);
        System.out.println("Worker Name: " + this.name);
        System.out.println("Worker Address: " + this.address);
        System.out.println("Worker Status: " + this.status);
        System.out.println("=======================");
    }
}
