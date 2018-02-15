package lab02;

import java.util.Scanner;

public class FoodItem {
    private String  itemDescription;
    private int     quantity = 0;
    private double  price;
    
    public void Loadnfo(Scanner input){
        itemDescription = input.nextLine();
        price           = Double.parseDouble(input.nextLine());
    }
    
    public void ResetQuantity(){
        quantity = 0;
    }
    
    public int GetQuantity(){
        return quantity;
    }
    
    public String GetDescription(){
        return itemDescription;
    }
    
    public double GetPrice(){
        return price;
    }
    
    public void IncreaseQuantity(int addedQuantity){
        quantity = quantity + addedQuantity;
    }
    
    public void DecreaseQuantity(int decreasedQuantity){
        quantity = quantity - decreasedQuantity;
    }
    
    public double GetExtendedCost(){
        double cost = quantity * price;
        return cost;
    }
    
    public void DisplayFoodItemSummary(){
        System.out.println(GetQuantity() + "  " + GetPrice() + "  " + GetExtendedCost() + "  " + GetDescription());
        
    }
}
