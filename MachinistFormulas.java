/*  Steve Hull
    Sophia Pathways
    Introduction to Java Programming (CS1101)
    04/02/2023

    The purpose of this program is to be able to easily compute machining formulas for the
    purpose of writing G-code programs and for ease of quality control inspection.
 
 
 */

import java.util.Scanner;


public class MachinistFormulas {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        boolean quit = true;

        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("Welcome to the Machinist Formula Calculator!\n");

        while(quit) {
            //This is the main menu for selecting which formula the user wants to calculate
            //It runs in a whie loop that can be broken out of when the user wants to quit the program
            System.out.println("Please make a selection from the following formulas:");
            System.out.println("1. Surface Feet Per Minute(SFM)");
            System.out.println("2. Inches Per Minute(IPM) Feed Rate");
            System.out.println("3. Revolutions Per Minute(RPM)");
            System.out.println("4. Inches Per Revolution(IPR) Feed Rate");
            System.out.println("5. Material Removal Rate");
            System.out.println("6. Sine Plate/Bar Setting");
            System.out.println("7. Thread Measurement Over Wires");
            System.out.println("8. Tool Nose Radius Compensation");
            System.out.println("9. Millimeters To Inches Conversion");
            System.out.println("10. Inches to Millimeters Conversion");
            System.out.println("11. exit");
            System.out.println("Enter 1-11");

            String selection = inputCheck(scan);
                
            switch(Integer.parseInt(selection)){
                case 1: 
                    System.out.println(surfaceFeetPerMinute(scan));
                    menuCheck(scan);
                    break;
                case 2: 
                    System.out.println(inchesPerMinute(scan));
                    menuCheck(scan);
                    break;
                case 3: 
                    System.out.println(revolutionsPerMinute(scan));
                    menuCheck(scan);
                    break;
                case 4: 
                    System.out.println(inchesPerRevolution(scan));
                    menuCheck(scan);
                    break;
                case 5: 
                    System.out.println(materialRemovelRate(scan));
                    menuCheck(scan);
                    break;
                case 6: 
                    System.out.println(sinePlate(scan));
                    menuCheck(scan);
                    break;
                case 7: 
                    System.out.println(threadMeasurementOverWires(scan));
                    menuCheck(scan);
                    break;
                case 8: 
                    System.out.println(toolNoseRadiusCompensation(scan));
                    menuCheck(scan);
                    break;
                case 9: 
                    System.out.println(millimetersToInches(scan));
                    menuCheck(scan);
                    break;
                case 10: 
                    System.out.println(inchesToMillimeters(scan));
                    menuCheck(scan);
                    break;
                case 11: 
                    System.exit(0);
            }
    }
            scan.close();


    }


    public static String surfaceFeetPerMinute(Scanner scan){
        /* Surface feet per minute (SFM) is the combination of a physical quantity (surface speed) 
        and an imperial and American customary unit (feet per minute or FPM). It is defined as the 
        number of linear feet that a location on a rotating component travels in one minute.
        The applicable formula is: S.F.M. = R.P.M. X (CUTTER OR TOOL Ø)/3.82 */

        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
        
        System.out.println("Surface Feet Per Minute(SFM) Calculation\n");
        System.out.println("Enter the revolutions per minute(RPM):");
        String rPM = checkValue(scan);

        System.out.println("Enter the tool or material diameter:");
        String diameter = checkValue(scan);
        
        double result = (Double.parseDouble(rPM) * Double.parseDouble(diameter))/3.82;
    
        return "The Surface Feet Per Minute is: " + (double)Math.round(result * 10d) / 10d;

    }


    public static String inchesPerMinute(Scanner scan){
        /*Inches per minute (IPM) is the measure of speed, or how fast something is moving in a given time.
        This type of feed rate usually applies to vertical machining centers, also called mills.
        The applicable formula is: I.P.M. = I.P.R. X R.P.M */

        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
        
        System.out.println("Inches Per Minute(IPM) Feed Calculation\n");
        System.out.println("Enter the revolutions per minute(RPM):");
        String rPM = checkValue(scan);

        System.out.println("Enter the inches per revolution(IPR):");
        String iPR = checkValue(scan);
        
        double result = (Double.parseDouble(rPM) * Double.parseDouble(iPR));
    
        return "The Inches Per Minute Feed is: " + (double)Math.round(result * 1000d) / 1000d;

    }


    public static String revolutionsPerMinute(Scanner scan){
        /*Revolutions per minute (RPM) is used as a measure of how fast any machine is operating at a given time.
        In the Aerospace machining industry the term is typically used in relation to the speed at which a motor
        is turning either a cutting tool (mill) or material that is being cut (lathe).
        The applicable formula is: R.P.M. = S.F.M. / (CUTTER OR TOOL Ø) / 0.262 */

        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
        
        System.out.println("Revolutions Per Minute(RPM) Calculation\n");
        System.out.println("Enter the surface feet per minute(SFM):");
        String sFM = checkValue(scan);

        System.out.println("Enter the tool or material diameter:");
        String diameter = checkValue(scan);
        
        double result = (Double.parseDouble(sFM) / Double.parseDouble(diameter))/.262;
    
        return "The Revolutions Per Minute are: " + (double)Math.round(result * 1d) / 1d;

    }


    public static String inchesPerRevolution(Scanner scan){
        /*Inches per revolution is the distance that a cutting tool travels during one revolution of a spindle,
        typically as it applies to a horizontal maching center, also called lathes.
        The applicable formula is: I.P.R. = I.P.M. / R.P.M */

        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
        
        System.out.println("Inches Per Revolution(IPR) Calculation\n");
        System.out.println("Enter the inches per minute(IPM):");
        String iPM = checkValue(scan);

        System.out.println("Enter the revolutions per minute(RPM):");
        String rPM = checkValue(scan);
        
        double result = (Double.parseDouble(iPM) / Double.parseDouble(rPM));
    
        return "The Inches Per Revolution are: " + (double)Math.round(result * 1000d) / 1000d;

    }


    public static String materialRemovelRate(Scanner scan){
        /*Material removal rate (MRR) is the amount of material removed per time unit (usually per minute) when performing 
        machining operations such as using a lathe or milling machine, typically measured in cubic inches per minute.
        The applicable formula is: IN3/MIN = D.O.C. X FEED/REV. X S.F.M. X 12 */

        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
        
        System.out.println("Material Removal Rate (MRR) Calculation\n");
        System.out.println("Enter the depth of cut(DOC):");
        String dOC = checkValue(scan);

        System.out.println("Enter the surface feet per minute(SFM):");
        String sFM = checkValue(scan);

        System.out.println("Enter the inches per revolution(IPR):");
        String iPR = checkValue(scan);
        
        double mRR = (Double.parseDouble(sFM) * 12 * Double.parseDouble(iPR) * Double.parseDouble(dOC));
    
        return "The Material Removal Rate is: " + (double)Math.round(mRR * 1000d) / 1000d + " cubic inches/min";

    }


    public static String sinePlate(Scanner scan){
        /*Sine plates hold workpieces or fixtures at a calculated specific angle to guide accurate measuring of angles. Also called 
        sine tables, they have a top plate that tilts out from the surface plate to set up an exact angle. The formula is used to
        to determine what blocks to set under the sine bar to achieve the desired angle for inspection.
        The applicable formula is: BC = AB * sin(ϴ), where BC is the needed height, AB is the sine bar length, and ϴ is the known angle. */

        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
        
        System.out.println("Sine Plate/Bar Calculation\n");
        System.out.println("Enter the plate or bar length:");
        String plate = checkValue(scan);

        System.out.println("Enter the angle:");
        String angle = checkValue(scan);
        
        double result = Double.parseDouble(plate) * Math.sin(Math.toRadians(Double.parseDouble(angle)));
    
        return "The Sine Plate/Bar Height is: " + (double)Math.round(result * 10000d) / 10000d;

    }


    public static String threadMeasurementOverWires(Scanner scan){
        /* Thread measurement over wires is a method of measuring the pitch diameter of threads. Three wires with the same known precise 
        diameter are placed between the threads and the anvils of the micrometer. The value of diameter measured “over the wire” is used 
        to calculate the pitch diameter of the thread. The formulas are used to calculate the acceptable high and low values of measurement.
        The applicable formula for the maximum measurement is: max_measurement = max_pitch - (.86603 * pitch) + (3 * wire_size)
        The applicable formual for the minimum measurement is: min_measurement = min_pitch - (.86603 * pitch) + (3 * wire_size) */

        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
        
        System.out.println("Thread Measurement Over Wires\n");
        System.out.println("Enter the threads per inch(TPI):");
        String tPI = checkValue(scan);

        System.out.println("Enter the Wire Size:");
        String wireSize = checkValue(scan);

        System.out.println("Enter the maximum pitch diameter:");
        String maxPitch = checkValue(scan);

        System.out.println("Enter the minimum pitch diameter:");
        String minPitch = checkValue(scan);

        
        
        double maxMeasurement = Double.parseDouble(maxPitch) - (.86603 * (1 / Double.parseDouble(tPI))) + (3 * Double.parseDouble(wireSize));
        double minMeasurement = Double.parseDouble(minPitch) - (.86603 * (1 / Double.parseDouble(tPI))) + (3 * Double.parseDouble(wireSize));
    
        return "The Thread Measurement over wires is: " + (double)Math.round(maxMeasurement * 10000d) / 10000d + "/" + (double)Math.round(minMeasurement * 10000d) / 10000d + " using wire size: " + wireSize;

    }


    public static String toolNoseRadiusCompensation(Scanner scan){
        /*Tool nose radius compensation is a value that is used to determine the distance a cutting tool path must travel in both X axis and
        Z axis when cutting an angle in order to achieve the desired dimension required to meet blue print specifications. This formula is used
        primarily when programming in G-code for CNC horizontal machining centers, also called lathes.
        The applicable formula for X axis compensation is: X axis compensation value = 2(nose radius - (nose radius x tan (45-(angle [divided by] 2)))
        The applicable formula for Z axis compensation is: Z axis compensation value = (nose radius - [nose radius x tan (angle [divided by] 2)) */

        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
        
        System.out.println("Angular Tool Nose Radius Compensation Calculation\n");
        System.out.println("Enter the tool nose radius:");
        String tNR = checkValue(scan);

        System.out.println("Enter the angle:");
        String angle = checkValue(scan);
        
        double zComp = Double.parseDouble(tNR) - (Double.parseDouble(tNR) * (Math.tan(Math.toRadians(Double.parseDouble(angle) / 2))));
        double xComp = 2 * (Double.parseDouble(tNR) - (Double.parseDouble(tNR) * (Math.tan(Math.toRadians(Double.parseDouble(angle) / 2)))));
    
        return "X axis compensation is: " + (double)Math.round(xComp * 10000d) / 10000d + "\n" + "Z axis compensation is: " + (double)Math.round(zComp * 10000d) / 10000d;

    }


    public static String millimetersToInches(Scanner scan){
        /*Just a simple and useful metric to imperial conversion method
        The applicable formula is: IN = MM/25.4 */

        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
        
        System.out.println("Millimeters to Inches Conversion\n");
        System.out.println("Enter the millimeters");
        String millimeters = checkValue(scan);
        
        double inches = Double.parseDouble(millimeters) / 25.4;
    
        return "The inch conversion is: " + (double)Math.round(inches * 10000d) / 10000d;

    }


    public static String inchesToMillimeters(Scanner scan){
        /*Just a simple and useful imperial to metric conversion method
        The applicable formula is: MM = IN X 25.4 */

        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
        
        System.out.println("Inches to Millimeters Conversion\n");
        System.out.println("Enter the inches");
        String inches = checkValue(scan);
        
        double millimeters = Double.parseDouble(inches) * 25.4;
    
        return "The millimeter conversion is: " + (double)Math.round(millimeters * 100d) / 100d;

    }


    public static void menuCheck(Scanner scan) {
        //This method is error checking only.  It allows the user to quit from the main menu by selecting 'n'

        System.out.println("\nDo you care to make another calculation? 'n' to exit");
        String selection = scan.nextLine();
        if (selection.equalsIgnoreCase("n")) {
            System.exit(0);
        }
        else {
            System.out.print("\033[H\033[2J");  
            System.out.flush(); 
        }

    }


    public static String checkValue(Scanner scan) {
        //This method is error checking only.  It insures that the user enters a valid positive number

        boolean choice = true;
        String value = "";

        while(choice) {
            value = scan.nextLine();
            try { 
			    Double.parseDouble(value);
                if (Double.parseDouble(value) > 0) {
                    choice = false;
                }
                else {
                    System.out.println("Invalid selection. Enter a positive value:");
                }
            }
            catch (NumberFormatException e) {
                    System.out.println("Invalid selection. Enter a number:");
            }

        }
        
        return value;

    }


    public static String inputCheck(Scanner scan) {
        //This method is for error checking on the main menu to insure the user only enters
        //a valid number from 1 to 11

        boolean choice = true;
        String selection = "0";

        while (choice) {

            selection = scan.nextLine();
            try { 
			    Integer.parseInt(selection);
            }
            catch (NumberFormatException e) {
                selection = "0";
            }

            if (Integer.parseInt(selection) < 1 || Integer.parseInt(selection) > 11) {
                System.out.println("Invalid selection. Enter 1-11:");
            }
            else {
                choice = false;
            }
        }


        return selection;


    }

    
}
