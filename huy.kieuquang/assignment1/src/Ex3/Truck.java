/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex3;

/**
 *
 * @author kieuq
 */
public class Truck extends Car{
    public int weight;

    
    public Truck(int weight){
        super();
        this.weight = weight;
    }
    
    
    
    @Override
    public double getSalePrice(){
        if(weight>2000){
            this.setRegularPrice(this.getRegularPrice() * 0.9);
            return this.getRegularPrice();
        }
        
        this.setRegularPrice(this.getRegularPrice() * 0.8);
        return this.getRegularPrice();
    }
}
