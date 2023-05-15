package model;

import java.util.ArrayList;
import java.util.Scanner;

public class MainController {

	static ArrayList<Admin> admins = new ArrayList<Admin>();
	static Scanner keyboard = new Scanner (System.in);
	static int index = 0;
	static CleaningService cleaningService = new CleaningService();
	
	public MainController() {
		Admin a = new Admin();
		a.setUsername("admin");
		a.setPassword("admin");

		Admin a2 = new Admin();
		a2.setUsername("admin2");
		a2.setPassword("admin2");

		Admin a3 = new Admin();
		a3.setUsername("admin3");
		a3.setPassword("admin3");

		admins.add(a);
		admins.add(a2);
		admins.add(a3);


	}


	public static void main(String[] args) {
		MainController controller = new MainController();
		System.out.println("Enter username : ");
		String name = keyboard.nextLine();
		System.out.println("Enter password : ");
		String password = keyboard.nextLine();

		while(!isAdmin(name, password)) {
			System.out.println("Invalid username/password, please try again");
			System.out.println("Enter username : ");
			name = keyboard.nextLine();
			System.out.println("Enter password : ");
			password = keyboard.nextLine();
		}

		System.out.print("Welcome Back " + name + " to the Cleaning Service!");

		while (true) {
			printMenu();
			int choice = getChoiceFromUser();
			switch (choice) {
			case 1:
				addCustomer();
				break;
			case 2:
				addProduct();
				break;
			case 3:
				addWorker();
				break;
			case 4:
				createOrder();
				break;
			case 5:
				viewCustomers();
				break;
			case 6:
				viewWorkers();
				break;
			case 7:
				viewOrders();
				break;
			case 8:
				viewProducts();
				break;
			case 9:
				assignWorker();
				break;
			case 10:
				printInvoice();
				break;
			case 11:
				System.out.println("Exiting program...");
				return;
			default:
				System.out.println("Invalid choice. Please try again.");
			}

		}

	}


	private static void viewWorkers() {
        System.out.println("Viewing all workers...");

        for (Worker worker : cleaningService.getWorkers()) {
        	worker.displayWorkerDetails();
        }
	}


	private static void viewCustomers() {
        System.out.println("Viewing all customer...");

        for (Customer customer : cleaningService.getCustomers()) {
        	customer.displayDetails();
        }
		
	}

	private static void viewProducts() {
        System.out.println("Viewing all products...");

        for (Product product : cleaningService.getProducts()) {
        	product.displayProductDetails();
        }
		
	}

	private static boolean isAdmin(String name, String password) {
		boolean found = false;
		boolean valid = false;
		for (Admin admin : admins) {
			if (admin.getUsername().equals(name)) {
				found = true; 
				if (admin.getPassword().equals(password)) {
					valid = true; 
				}
			}
			if (found && valid) {
				break;
			}
		}
		return found && valid;
	}

	private static void printMenu() {
		System.out.println("===== Cleaning Service Menu =====");
		System.out.println("1. Add a new customer");
		System.out.println("2. Add a new product");
		System.out.println("3. Add a new worker");
		System.out.println("4. Create a new order");
		System.out.println("5. View customers");
		System.out.println("6. View workers");
		System.out.println("7. View orders");
		System.out.println("8. View products");
		System.out.println("9. Assign a task to a worker");
		System.out.println("10. Print an invoice");
		System.out.println("11. Exit");
	}

	private static int getChoiceFromUser() {
		System.out.print("Enter your choice: ");
		int choice = keyboard.nextInt();
		keyboard.nextLine(); // consume newline character
		return choice;
	}

	private static void addCustomer() {
		// prompt user for customer details and create a new Customer object
		System.out.print("Enter customer name: ");
		String name = keyboard.nextLine();
		boolean found = false;
        for (Customer customer : cleaningService.getCustomers()) {
			if (name.equals(customer.getName())) {
				found = true;
				break;
			}
		}
        if (found) {
        	System.out.println("There is an existing customer with this name");
        } else {
        	System.out.print("Enter customer address: ");
    		String address = keyboard.nextLine();
    		System.out.print("Enter customer phone number: ");
    		String phone = keyboard.nextLine();
    		System.out.print("Enter customer email: ");
    		String email = keyboard.nextLine();
    		Customer customer = new Customer(index++, name, address, phone, email);

    		cleaningService.addCustomer(customer);
    		System.out.println("New customer added successfully!");
        }
	}

	private static void addProduct() {
		System.out.print("Enter product name: ");
		String name = keyboard.nextLine();
		System.out.print("Enter product price: ");
		double price = keyboard.nextDouble();
		keyboard.nextLine(); 
		Product product = new Product(index++, name, price);

		cleaningService.addProduct(product);
		System.out.println("New product added successfully!");
	}

	private static void addWorker() {
		System.out.print("Enter worker name: ");
		String name = keyboard.nextLine();
		System.out.print("Enter worker address: ");
		String address = keyboard.nextLine();
		System.out.print("Enter worker phone number: ");
		String phone = keyboard.nextLine();
		System.out.print("Enter worker status (busy/available): ");
		String statusString = keyboard.nextLine();
		WorkerStatus status = statusString.equals("busy") ? WorkerStatus.BUSY : WorkerStatus.AVAILABLE;
		Worker worker = new Worker(index++, name, address, phone, status);

		cleaningService.addWorker(worker);
		System.out.println("New worker added");
	}
	
	private static void createOrder() {
        System.out.println("Creating new order...");
        System.out.println("Enter customer name:");
        String customerName = keyboard.next();
        boolean found = false;
        Customer selectedCustomer = null;
        for (Customer customer : cleaningService.getCustomers()) {
			if (customerName.equals(customer.getName())) {
				found = true;
				selectedCustomer = customer;
				break;
			}
		}
        if (found) {
        	System.out.println("There is an existing customer with this name");
        } else {
        	System.out.println("No customer found with this name, please insert the rest of the details:");

        	System.out.println("Enter customer address:");
            String customerAddress = keyboard.next();
            
            System.out.println("Enter customer phone number:");
            String customerPhone = keyboard.next();
            
            System.out.println("Enter customer email:");
            String customerEmail = keyboard.next();
            selectedCustomer = new Customer(index++, customerName, customerAddress, customerPhone, customerEmail);
            
        }
        
        System.out.println("Enter product name:");
        String productName = keyboard.next();
        
        boolean productFound = false;
        Product selectedProduct = null;
        for (Product product : cleaningService.getProducts()) {
			if (productName.equals(product.getName())) {
				productFound = true;
				selectedProduct = product;
				break;
			}
		}
        if (productFound) {
        	System.out.println("There is an existing product with this name");
        } else {
        	 System.out.println("Enter product price:");
             double productPrice = keyboard.nextDouble();
             selectedProduct = new Product(index++, productName, productPrice);
        }
        
        ArrayList<Product> products  = new ArrayList<Product>();
        products.add(selectedProduct);
        Order order = new Order(index++, selectedCustomer, products);
        
        cleaningService.placeOrder(order);
        
        System.out.println("Order created successfully.");
    }
    
    private static void viewOrders() {
        System.out.println("Viewing all orders...");
        
        for (Order order : cleaningService.getOrders()) {
        	order.displayOrderDetails();
        }
    }
    
    private static void assignWorker() {
        System.out.println("Assigning worker to order...");
        
        System.out.println("Enter order ID:");
        int orderId = keyboard.nextInt();
        
        boolean found = false;
        Order order = null;
        for (Order order2 : cleaningService.getOrders()) {
			if (orderId == order2.getId()) {
				found = true;
				order = order2;
				break;
			}
		}
        if (!found) {
        	System.out.println("Invalid order id!");
        } else {
        	 System.out.println("Enter worker Name:");
             String workerName = keyboard.next();
             
             boolean workerFound = false;
             Worker workers = null;
             for (Worker worker : cleaningService.getWorkers()) {
     			if (workerName.equals(worker.getName())) {
     				workerFound = true;
     				workers = worker;
     				break;
     			}
     		}
            
             if (workerFound) {
            	 boolean avalable = false;
            	 for (Worker worker : cleaningService.getAvailableWorkers()) {
          			if (workerName.equals(worker.getName())) {
          				cleaningService.assignOrderToWorker(order, workers);
                        System.out.println("Worker assigned successfully.");
                        avalable = true;
          				break;
          			}
          		}
            	 
            	 if (!avalable) {
                     System.out.println("This worker is already assigned to a different task");
            	 }
                 
             } else {
            	 System.out.println("No worker found with this name!");
             }
        }
        
    }
	

    private static void printInvoice() {
    	System.out.println("Enter order ID:");
    	int orderId = keyboard.nextInt();

    	boolean found = false;
    	Order order = null;
    	for (Order order2 : cleaningService.getOrders()) {
    		if (orderId == order2.getId()) {
    			found = true;
    			order = order2;
    			break;
    		}
    	}
    	if (!found) {
    		System.out.println("Invalid order id!");
    	} else {
    		Invoice invoice = new Invoice(index++, order);
    		invoice.displayDetails();
    		
    	}

    }

}
