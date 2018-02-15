package lab02;

import java.util.Scanner;

public class RemoveOrder {

    public static void menu(FoodItem[] menu) {
        int userChoice;
        String choice;
        
        userChoice = getUserChoice(menu);
        switch(userChoice){
            case 1:
                choice = menu[0].GetDescription();
                performAction(menu, choice);
                break;
            case 2:
                choice = menu[1].GetDescription();
                performAction(menu, choice);
                break;
            case 3: 
                choice = menu[2].GetDescription();
                performAction(menu, choice);
                break;
            case 4:
                choice = menu[3].GetDescription();
                performAction(menu, choice);
                break;
        }      
    }

    private static int getUserChoice(FoodItem[] menu) {
        int userChoice;
        System.out.println("\n\n=====================================");
        System.out.println("Please select an menu item:\n");
        for(int item = 0; item < 4; item++){
            System.out.println((item + 1) + ". " + menu[item].GetDescription()
                    + " | $" + menu[item].GetPrice());
        }
        System.out.println("=====================================\n");    
        Scanner sc = new Scanner(System.in);
        userChoice = sc.nextInt();
               
        return userChoice;
    }

    private static void performAction(FoodItem[] menu, String choice) {
        for(int x = 0; x < 4; x++){
            if(choice.equals(menu[x].GetDescription())){
                menu[x].DecreaseQuantity(1);
            }     
        }
    }
}
