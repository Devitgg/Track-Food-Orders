package lab02;

import java.util.Scanner;

class CheckOut {
    public static void menu(FoodItem[] menu){
        System.out.println("\n\n\n\n\n"
                + "=========================================\n"
                + "Here is your current order summary");
        displayOrderSummary(menu);
        calcAndDisplayTotals(menu);
        confirm();
        reset(menu);
    }

    private static void displayOrderSummary(FoodItem[] menu) {
        int orderNum = 1;
        for(int item = 0; item < 4; item++){
            if(menu[item].GetQuantity() != 0){
                System.out.println(orderNum + ". " +
                        menu[item].GetDescription() + " - " + 
                        menu[item].GetQuantity() + " means for $" + 
                        menu[item].GetExtendedCost());
            }
        }
    }

    private static void calcAndDisplayTotals(FoodItem[] menu) {
        double runningTotal = 0;
        double totalWithTax = 0;
        for(int item = 0; item < 4; item++){
            if(menu[item].GetQuantity() != 0){
                runningTotal = runningTotal + menu[item].GetExtendedCost();
            }
        }       
        totalWithTax = runningTotal * 0.08;
        
        System.out.println("=====================================\n"
                + "Tax: 8%\n"
                + "Subtotal: " + runningTotal + "\n"
                        + "Total: " + totalWithTax + "\n\n\n\n\n\n");
    }

    private static void confirm() {
        String userChoice;
        System.out.println("Please read order summary to customer, "
                + "confirm order and take payment");
        System.out.println("Hit any key to confirm ¯\\_(ツ)_/¯");
        Scanner sc = new Scanner(System.in);
        userChoice = sc.nextLine();
    }

    private static void reset(FoodItem[] menu) {
        for(int item = 0; item < 4; item++){
            menu[item].ResetQuantity();
        }
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}
