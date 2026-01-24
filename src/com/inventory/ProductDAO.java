package com.inventory;

import java.sql.*;

public class ProductDAO {

    public void addProduct(Product p) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps =
            con.prepareStatement("INSERT INTO inventory VALUES(?,?,?,?)");

        ps.setInt(1, p.productId);
        ps.setString(2, p.productName);
        ps.setInt(3, p.quantity);
        ps.setDouble(4, p.price);

        ps.executeUpdate();
        con.close();
        System.out.println("Product Added Successfully");
    }

    public void viewProducts() throws Exception {
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM inventory");

        System.out.println("\nID  NAME  QTY  PRICE");
        while(rs.next()) {
            System.out.println(
                rs.getInt(1) + "  " +
                rs.getString(2) + "  " +
                rs.getInt(3) + "  " +
                rs.getDouble(4)
            );
        }
        con.close();
    }

public void updateProduct(int id, int qty) throws Exception {
    Connection con = DBConnection.getConnection();
    PreparedStatement ps =
        con.prepareStatement(
            "UPDATE inventory SET quantity=? WHERE product_id=?");

    ps.setInt(1, qty);
    ps.setInt(2, id);

    int rows = ps.executeUpdate();
    if(rows > 0)
        System.out.println("Product Updated Successfully");
    else
        System.out.println("Product Not Found");

    con.close();
}
}
