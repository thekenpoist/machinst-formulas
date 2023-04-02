import java.util.Scanner;


public class MachinistFormulas {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        boolean quit = true;

        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        System.out.println("Welcome to the Machinist Formula Calculator!\n");

        while(quit) {

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

        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
        
        System.out.println("Material Removal Rate Calculation\n");
        System.out.println("Enter the depth of cut(DOC):");
        String dOC = checkValue(scan);

        System.out.println("Enter the surface feet per minute(SFM):");
        String sFM = checkValue(scan);

        System.out.println("Enter the inches per revolution(IPR):");
        String iPR = checkValue(scan);
        
        double result = (Double.parseDouble(sFM) * 12 * Double.parseDouble(iPR) * Double.parseDouble(dOC));
    
        return "The Material Removal Rate is: " + (double)Math.round(result * 1000d) / 1000d + " cubic inches/min";

    }


    public static String sinePlate(Scanner scan){

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

        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
        
        System.out.println("Millimeters to Inches Conversion\n");
        System.out.println("Enter the millimeters");
        String millimeters = checkValue(scan);
        
        double inches = Double.parseDouble(millimeters) / 25.4;
    
        return "The inch conversion is: " + (double)Math.round(inches * 10000d) / 10000d;

    }


    public static String inchesToMillimeters(Scanner scan){

        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
        
        System.out.println("Inches to Millimeters Conversion\n");
        System.out.println("Enter the inches");
        String inches = checkValue(scan);
        
        double millimeters = Double.parseDouble(inches) * 25.4;
    
        return "The millimeter conversion is: " + (double)Math.round(millimeters * 100d) / 100d;

    }


    public static void menuCheck(Scanner scan) {

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
