package com.tarktech.training.beverage;

import java.util.Scanner;

import static com.tarktech.training.beverage.BeverageType.valueOf;

public class Main {

    public static void main(String[] args) {
        BeverageMachine beverageMachine = new BeverageMachine();
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWhat beverage do you want (to refresh your morning)?");
        System.out.println("Please type Tea, Latte, Mocha, Cappuccino or BlackTea. Enter Done, if you feel refreshed!");

        String userInput = scanner.nextLine();

        while (!userInput.equals("Done")) {

            try
            {
                BeverageType beverageType = valueOf(userInput);

                String beverage = beverageMachine.dispenseBeverage(beverageType);
                System.out.println(beverage);

                int totalBeveragesDrunkByUser = beverageMachine.getDispensedBeverageCount(beverageType);
                System.out.println("You have drunk " + totalBeveragesDrunkByUser + " " + beverageType + " this morning!");

                int availableBeverageCount = beverageMachine.getAvailableBeverageCount(beverageType);
                System.out.println("There are " + availableBeverageCount + " more " + beverageType + " available.");

                System.out.println("\nWhat beverage do you want (to refresh your morning)?");
                System.out.println("Please type Tea, Latte, Mocha, Cappuccino or BlackTea. Enter Done, if you feel refreshed!");
            }
            catch (RuntimeException ex){
                System.out.println("Error: " + ex.getMessage());
            }

            System.out.println("Your favorite beverage is " + beverageMachine.getMostFavoriteBeverage());
            userInput = scanner.nextLine();
        }

        System.out.println("Thank you! Visit again!");
    }
}
