package model;

import java.util.ArrayList;
import java.util.List;

public class CleaningService {
    private List<Worker> workers;
    private List<Customer> customers;
    private List<Product> products;
    private List<Order> orders;

    public CleaningService() {
        this.workers = new ArrayList<Worker>();
        this.customers = new ArrayList<Customer>();
        this.products = new ArrayList<Product>();
        this.orders = new ArrayList<Order>();
    }

    public List<Worker> getWorkers() {
		return workers;
	}

	public void setWorkers(List<Worker> workers) {
		this.workers = workers;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public void addWorker(Worker worker) {
        this.workers.add(worker);
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void placeOrder(Order order) {
        this.orders.add(order);
    }

    public List<Order> getOrders() {
        return this.orders;
    }

    public List<Order> getIncompleteOrders() {
        List<Order> incompleteOrders = new ArrayList<Order>();
        for (Order order : this.orders) {
            if (!order.isComplete()) {
                incompleteOrders.add(order);
            }
        }
        return incompleteOrders;
    }

    public List<Worker> getAvailableWorkers() {
        List<Worker> availableWorkers = new ArrayList<Worker>();
        for (Worker worker : this.workers) {
            if (worker.getStatus() == WorkerStatus.AVAILABLE) {
                availableWorkers.add(worker);
            }
        }
        return availableWorkers;
    }

    public void assignOrderToWorker(Order order, Worker worker) {
        order.setAssignedWorker(worker);
        worker.setStatus(WorkerStatus.BUSY);
    }

    public void completeOrder(Order order) {
        order.setComplete(true);
        Worker worker = order.getAssignedWorker();
        worker.setStatus(WorkerStatus.AVAILABLE);
    }
}
