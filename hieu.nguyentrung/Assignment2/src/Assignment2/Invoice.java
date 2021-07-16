/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;

/**
 *
 * @author hieu.nguyentrung2
 */
public class Invoice implements Payable{
    String partNumber;
    String partDescription;
    int quantity;
    double pricePerItem;
    @Override
    public double getPaymentAmount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
