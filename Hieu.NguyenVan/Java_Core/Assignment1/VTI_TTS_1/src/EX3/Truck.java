/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EX3;

/**
 *
 * @author van hieu
 */
public class Truck extends Car{
     private int  weigth;

    public Truck() {
    }

    public Truck(int weigth) {
        super();
        this.weigth = weigth;
    }
    
  
    
    @Override
    public double getSalePrice(){
        if (weigth>=2000){
            return this.getRegularPrice()-this.getRegularPrice()/10;
        }
        return this.getRegularPrice()-this.getRegularPrice()/5;
        
    }
     
    
}
