import java.util.Scanner;

public class IceMachineTestMain {

    /**
     *
     * @author Viren Gadkari
     *
     *         Simple java project to model the user interface of a water and
     *         ice machine in a refrigeration unit
     *
     *
     *
     *
     *
     *
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //create instance of class called cup to model the user
        IceMachineFunc cup = new IceMachineFunc();

        //instantiate variables

        //ice count and water amount to be zero until the user prompts
        cup.iceCount = 0;
        cup.waterAmt = 0;

        //both systems are off until the user prompts
        cup.iceDispenseRunning = false;
        cup.waterDispenseRunning = false;

        //Prompt user for an initial maximum ice cube amount for dispenser
        System.out.print("Enter an initial ice cube maximum: ");
        cup.maxIce = in.nextInt();

        System.out
                .println("You will add " + cup.maxIce + " cubes to the fridge");

        //Prompy user for their choice of Ice, Water, or Both
        System.out.print("Would you like ice, water or both?:[I,W,B] ");
        char choice = in.next().charAt(0);

        //call functions for each choice depending on the user
        //all return the state of the system being on (true, or false)

        cup.iceDispenseOn(choice);

        cup.waterDispenseOn(choice);

        cup.getWaterAndIce(choice);

        boolean loopBreaker = true;

        cup.iceChk = true;

        //loop while there is still ice in the dispenser
        while (cup.maxIce >= 0 && (loopBreaker == true)) {

            //check if the user requests for water
            if (cup.waterDispenseOn(choice) == true) {

                //dispense water for a specific duration
                System.out.print("Enter the amount of seconds: ");
                int seconds = in.nextInt();

                //dispense water to user until the time alloted time has finished
                int counter = 0;

                while (counter <= seconds) {

                    //get water
                    cup.getWater();
                    counter++;

                }

                //prompt user if they would like to have anything else
                System.out.print("Would you like anything else [Y/N]: ");
                char waterChoice = in.next().charAt(0);

                //if not, break out of the loop and display goodbye message
                if (waterChoice == 'N' || waterChoice == 'n') {

                    System.out.println("Goodbye!");
                    loopBreaker = false;

                } else { //otherwise reprompt for what the user wants

                    System.out.print(
                            "Would you like ice, water or both?:[I,W,B] ");
                    choice = in.next().charAt(0);

                }

            }

            //if the user wishes to have both water and ice
            else if (cup.getWaterAndIce(choice) == true) {

                //prompt for the number of seconds the water is dispensed
                System.out.print("Enter the amount of seconds: ");
                int seconds = in.nextInt();

                int counter = 0;

                //dispense water to user for alotted time
                while (counter <= seconds) {

                    cup.getWater();
                    counter++;

                }

                //prompt user for the amount of ice cubes they would like
                System.out.print(
                        "Enter the number of ice cubes you would like: ");
                int iceQuantTemp = in.nextInt();

                //if the user has asked for a number of cubes which is more than
                //what is available, prompt error message
                if (iceQuantTemp > cup.maxIce) {

                    //display how many ice cubes are left
                    System.out.println("Sorry can only dispense " + cup.maxIce
                            + " cubes left!");

                    //reprompt user for a number of ice cubes
                    System.out.print(
                            "Enter the number of ice cubes you would like: ");
                    iceQuantTemp = in.nextInt();

                }

                //if there are enough ice cubes left, dispense them to user
                if (cup.maxIce >= iceQuantTemp) {

                    //dispense ice cubes
                    cup.getIce(iceQuantTemp);

                    System.out.println("Here are your " + iceQuantTemp
                            + " cubes and water!");

                    //prompt user for if they would like anything else
                    System.out.print("Would you like anything else? [Y/N]: ");
                    char repromptAns = in.next().charAt(0);

                    //if the user declines, display goodbye message
                    if (repromptAns == 'N' || repromptAns == 'n') {

                        System.out.println("Goodbye!");
                        loopBreaker = false;

                    } else {
                        //otherwise reprompt user for ice, water or both

                        System.out.print(
                                "Would you like ice, water or both?:[I,W,B] ");
                        choice = in.next().charAt(0);
                    }

                }

                else {//if there are not enough ice cubes left

                    //prompt user to refill the ice dispenser
                    cup.promptToRefill();

                    System.out.print("Enter the number of ice cubes "
                            + "for refilling: ");
                    int refillQuant = in.nextInt();

                    cup.refillIce(refillQuant);
                    //updates the maxIce

                }

            }

            else { //the third case, if the user simply only wants ice

                //prompt user for ice
                System.out.print(
                        "Enter the number of ice cubes you would like: ");
                int iceQuant = in.nextInt();

                //if the user wants ice, check if there is enough left in
                //the ice dispenser
                if (iceQuant > cup.maxIce) {

                    //display the amount of ice left

                    //reprompt user for an amount of ice
                    System.out.println("Sorry can only dispense " + cup.maxIce
                            + " cubes left!");
                    System.out.print(
                            "Enter the number of ice cubes you would like: ");
                    iceQuant = in.nextInt();

                }

                //if there is enough ice left, dispense ice to the user
                if (cup.maxIce >= iceQuant) {

                    cup.getIce(iceQuant);

                    System.out.println("Here are your " + iceQuant + " cubes");

                    //ask user if they would like anything else
                    System.out.print("Would you like anything else? [Y/N]: ");
                    char repromptAnsDup = in.next().charAt(0);

                    //if they do not wish to have anything else, display goodbye
                    //message
                    if (repromptAnsDup == 'N' || repromptAnsDup == 'n') {

                        System.out.println("Goodbye!");
                        loopBreaker = false;
                    } else {

                        //otherwise, prompt user for if they want ice, water, or both
                        System.out.print(
                                "Would you like ice, water or both?:[I,W,B] ");
                        choice = in.next().charAt(0);

                    }

                }

                else {//the other case, if there is not enough ice left

                    //prompt user to refill the ice dispenser

                    cup.promptToRefill();

                    //prompt user for how many cubes, and refill and update
                    //the ice dispenser amount
                    System.out.print("Enter the number of ice cubes "
                            + "for refilling: ");
                    int refillQuant = in.nextInt();

                    cup.refillIce(refillQuant);
                }

            }
        }
    }
}
