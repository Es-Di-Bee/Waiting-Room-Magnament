import java.util.Scanner;

public class Tester {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "";

        System.out.println("\033[0;34m" + "\033[4;34m" +"Please enter number of patients:");
        input = sc.nextLine();
        int patientNo = 0;
        try {
             patientNo = Integer.parseInt(input);
        } catch (Exception e) {
            System.err.printf("\nInvalid Input\nSystem exited\n\n");
            return;
        }
        WRM d1 = new WRM(patientNo);

        while (true) {
            System.out.printf("\033[0;34m" + "Press 1 for Registering patient\n" +
                    "Press 2 for Serving the patient\n" +
                    "Press 3 for Showing all patient Info\n" +
                    "Press 4 for to Check if Doc can Go Home\n" +
                    "Press 5 to Cancel all appointments\n" +
                    "Press 0 to Quit the Application\n" + "\u001B[0m");
            String command = sc.nextLine();
            if (command.equals("1")) {
                System.out.println("\033[0;34m" + "\033[4;34m" + "Please enter the patient ID first:");
                input = sc.nextLine();
                int id = 0, age = 0;
                String name = "", bg = "";
                try {
                    id = Integer.parseInt(input);
                } catch (Exception e) {
                    System.err.printf("\nInvalid Input\nTry again\n\n");
                    continue;
                }
                System.out.println("Please enter NAME of the patient:");
                name = sc.nextLine();
                System.out.println("Please enter the AGE of the patient:");
                input = sc.nextLine();
                try {
                    age = Integer.parseInt(input);
                } catch (Exception e) {
                    System.err.printf("\nInvalid Input\nTry again\n\n");
                    continue;
                }
                System.out.println("Please enter the BLOOD GROUP of the patient:");
                bg = sc.nextLine();
                d1.registerPatient(id, name, age, bg); // register patient method
            } else if (command.equals("2")) {
                d1.servePatient(); // serving patient method
            } else if (command.equals("3")) {
                d1.showAllPatient();
            } else if (command.equals("4")) {
                d1.canDoctorGoHome();
            } else if (command.equals("5")) {
                d1.cancelAll();
            } else if (command.equals("0")) {
                break;
            } else {
                System.err.printf("\nPlease enter a Valid Command\n\n");
            }
        }
    }

}
