package com.inventory;

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        ProductDAO dao = new ProductDAO();

        while(true) {
            System.out.println("\n1.Add Product");
            System.out.println("2.View Products");
            System.out.println("3.Update Product");
            System.out.println("4.Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();

            switch(ch) {
                case 1:
                    Product p = new Product();
                    System.out.print("Product ID: ");
                    p.productId = sc.nextInt();
                    System.out.print("Name: ");
                    p.productName = sc.next();
                    System.out.print("Quantity: ");
                    p.quantity = sc.nextInt();
                    System.out.print("Price: ");
                    p.price = sc.nextDouble();
                    dao.addProduct(p);
                    break;

                case 2:
                    dao.viewProducts();
                    break;

                    
                case 3:
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter New Quantity: ");
                    int qty = sc.nextInt();
                    dao.updateProduct(id, qty);
                    break;

                case 4:
                    System.exit(0);
            }
        }
    }
}

