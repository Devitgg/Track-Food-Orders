package lab02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab02 {
    
    private static boolean menuState = false;
    
    public static void main(String[] args) throws FileNotFoundException {
        FoodItem[] menu = new FoodItem[4];
        loadMenu(menu);
        
        while(!menuState){
            int userChoice;
            displayCurrentOrder(menu);
            userChoice = menu();
            switch(userChoice){
                case 1: 
                    AddToOrder.menu(menu);
                    break;
                case 2:
                    RemoveOrder.menu(menu);
                    break;
                case 3:
                    CheckOut.menu(menu);
                    break;
                case 4:
                    menuState = true;
                    break;
            }
        }
        System.exit(0);
    }

    private static int menu() {
        int userChoice;
        System.out.println("\n\n\n=====================================\n");
        System.out.println("What would you like to do?\n\n"
                + "1. Add Order\n"
                + "2. Remove Order\n"
                + "3. Checkout\n"
                + "4. Shutdown");
        System.out.println("=====================================\n");
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a order number!");
        userChoice = sc.nextInt();
        
        return userChoice;
    }

    private static void loadMenu(FoodItem[] menu) 
            throws FileNotFoundException {
        File file = new File("foodItems.txt");
        Scanner input = new Scanner(file);
        
        for(int x = 0; x < 4; x++){
           menu[x] = new FoodItem();
           menu[x].Loadnfo(input);
        }
    }  

    private static void displayCurrentOrder(FoodItem[] menu) {
        boolean noOrders = false;
        for(int item = 0; item < 4; item++){
            if(menu[item].GetQuantity() != 0){
                noOrders = true;
            }
        }
        if(noOrders == false){
            System.out.println("================================\n"
                    + "You have no orders\n"
                    + "================================");
        }else{
            System.out.println("================================\n"
                    + "Your current orders\n"
                    + "================================");
            for(int item = 0; item < 4; item++){
                if(menu[item].GetQuantity() != 0){
                    System.out.println(item + ". " + 
                            menu[item].GetDescription() + " - " + 
                            menu[item].GetQuantity() + " meals for $" + 
                            menu[item].GetExtendedCost());
                }    
            }
            System.out.println("================================");
        }     
    }
}