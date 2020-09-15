public class IceMachineFunc {

    /**
     *
     * @author Viren Gadkari
     *
     *         Simple java project to model the user interface of a water and
     *         ice machine in a refrigeration unit
     *
     *
     *         This class consists of the functions that will be used in the
     *         functionality of the program
     *
     *
     *
     */

    //Initialize global variables
    static int iceCount;
    static int maxIce;
    static int waterAmt;
    static boolean iceChk;
    static boolean waterChk;
    static boolean iceDispenseRunning;
    static boolean waterDispenseRunning;
    static boolean bothRunning;

    //No argument constructor
    public IceMachineFunc() {

        this.iceCount = iceCount;
        this.waterAmt = waterAmt;
        this.iceChk = iceChk;
        this.waterChk = waterChk;
        this.maxIce = maxIce;
        this.iceDispenseRunning = iceDispenseRunning;
        this.waterDispenseRunning = waterDispenseRunning;
        this.bothRunning = bothRunning;

    }

    /**
     *
     * Checks the state of the ice dispenser based on whether the user has
     * chosen to get ice or not
     *
     *
     * @param char
     *            the choice of the user if they want ice, determined by 'i' or
     *            'I'
     *
     *
     * @return boolean returns a boolean which resembles the state of the ice
     *         dispenser being in use and running, or off as a result of the
     *         user's choice
     *
     *
     *
     *
     */
    public static boolean iceDispenseOn(char choice) {

        //ice dispenser is off when the user does not ask for ice
        iceDispenseRunning = false;

        //if the user prompts the unit for ice, then the ice dispenser turns on
        if (choice == 'I' || choice == 'i') {

            System.out.println("Contacting ice dispenser...");
            iceDispenseRunning = true;

        }

        return iceDispenseRunning;
    }

    /**
     *
     * "Dispenses" ice to the user when prompted, and allows for the user to
     * specify an amount of cubes they would like to dispense
     *
     * Keeps track of the predetermined total amount of ice that is in dispenser
     * and subtract the quantity of ice dispensed from the total
     *
     *
     * @param int
     *            iceQuant - the specific quantity of ice cubes the user desired
     *
     **/

    public static void getIce(int iceQuant) {

        System.out.println("Dispensing ice...");

        //increase the ice cube dispensed to user
        iceCount++;

        //Simultaneously keeps track of total by taking difference of the
        //total amount of ice in the dispenser and the quantity desired by user
        maxIce = maxIce - iceQuant;

    }

    /**
     * Checks the state of the water dispenser based on what the user has chosen
     *
     *
     *
     * @param char
     *            choice - the user's desire for either "Ice", "Water" or Both
     *
     *
     * @return boolean waterDispenseRunning - the state of the water dispenser
     *         depending on what the user chooses
     *
     **/

    public static boolean waterDispenseOn(char choice) {

        //water dispenser is off
        waterDispenseRunning = false;

        //if user chooses water, the water dispenser will turn on
        if (choice == 'W' || choice == 'w') {

            System.out.println("Contacting water filter...");
            waterDispenseRunning = true;

        }

        //return the status of the water filter being on or off
        return waterDispenseRunning;

    }

    /**
     *
     * Checks the state of both, the water and ice dispenser depending on if the
     * user decided to have both
     *
     *
     *
     * @param char
     *            choice - the user's desire for either "Ice", "Water" or Both
     *
     *
     * @return boolean bothRunning - the state of both the water dispenser and
     *         the ice dispenser, depending on if the user selected both
     **/
    public static boolean getWaterAndIce(char choice) {

        //both are off when the systems are not in use
        bothRunning = false;

        //if the user chooses to have both ice and water turn both systems on
        if ((choice == 'B' || choice == 'b')) {

            bothRunning = true;
        }

        //return the status of both the water dispenser and the ice dispenser
        return bothRunning;

    }

    /**
     *
     * Dispenses water to the user
     *
     *
     *
     **/
    public static void getWater() {

        //Display message to user that water is being dispensed
        System.out.println("Dispensing water...");
        waterAmt++;

    }

    /**
     *
     * Displays message to user when ice needs to be refilled
     *
     *
     *
     **/
    public static void promptToRefill() {

        System.out.println("Ice needs to be refilled");

    }

    /**
     *
     * Refills a custom amount of ice back into the ice dispenser, updates the
     * maximum amount of ice remaining
     *
     * @param int
     *            refillQuant - amount of ice cubes the user wants to add to the
     *            ice dispenser
     *
     * @updates maxIce
     *
     *
     **/
    public static void refillIce(int refillQuant) {

        //display to user when ice is being refilled
        System.out.println("Refilling ice....");

        //updates the total ice amount with the custom ice quantity
        maxIce = maxIce + refillQuant;

    }

}
