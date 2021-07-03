public class WRM {

    Patient[] p = null;
    int size = 0, rear = 0, front = 0;

    public WRM(int patientNo) {
        p = new Patient[patientNo];
        size = 0;
        rear = -1;
        front = -1;
    }

    public void registerPatient(int i, String n, int a, String b) {
        if (size == p.length) {
            System.err.println("\n\033[1;92m" + "Maximum number of patients reached\nREGISTRATION FAILED\n");
            return;
        } else if (size == 0) {
            rear = 0;
            front = 0;
        }
        p[rear] = new Patient(i, n, a, b);
        rear = (rear+1) % p.length;
        ++size;
        sortByID();
        System.out.println("\033[0m" + "\n\033[1;92m" + "ADDED SUCCESSFULLY\n");
    }

    public void servePatient() {
        if (size == 0) {
            System.err.println("\nNo Patients in the Queue\n");
            return;
        }
        System.out.printf("\n\u001B[0m" + "\033[1;36m" + p[front].name.toUpperCase() + " is being Served.\n\n");
        p[front] = null;
        front = (front+1)%p.length;
        --size;
    }

    public void cancelAll() {
        if (size == 0) {
            System.out.println("\n\u001B[0m" + "\033[0;36m" + "There are no Pending Appointments, you can go to have Lunch\n");
        } else {
            for (int i = 0; i < p.length; ++i) {
                p[i] = null;
            }
            System.err.println("\nALL Appointments Cancelled\n");
            size = 0;
        }
    }

    public void canDoctorGoHome() {
        if (size == 0) {
            System.out.println("\n\033[0m" + "\033[1;37m" + "YES, The Doc can go home now\n");
        } else {
            System.err.println("\n\033[0m" + "NO, There are more Patients waiting\n");
        }
    }

    public void showAllPatient() {
        if (size == 0) {
            System.err.println("\nThere are no patients in the Queue\n");
            return;
        }
        Patient[] data = sortByName(p);
        for (int i = front, c = 0; c < size; ++c, i = (i+1)%data.length) {
            System.out.println("\n\033[4;31m" + "PATIENT INFO:");
            System.out.printf("\033[0m" + "\033[1;35m" + "Name      : " + data[i].name.toUpperCase());
            System.out.printf("\n\033[0m" + "\033[1;35m" + "Age       : " + data[i].age);
            System.out.printf("\n\033[0m" + "\033[1;35m" + "BloodGroup: " + data[i].bloodGroup.toUpperCase());
        }
        System.out.println("\n");
    }

    public Patient[] sortByName(Patient[] p) {
        Patient[] newArray = copy(p);
        for (int i = front, c1 = 0; c1 < size; i = (i+1)%newArray.length, ++c1) {
            for (int j = (i+1)%newArray.length, c2 = c1+1; c2 < size; j = (j+1)%newArray.length, ++c2) {
                if (newArray[i].name.compareToIgnoreCase(newArray[j].name) > 0) {
                    Patient temp = newArray[i];
                    newArray[i] = newArray[j];
                    newArray[j] = temp;
                }
            }
        }
        return newArray;
    }

    public void sortByID() {
        for (int i = front, c1 = 0; c1 < size; i = (i+1)%p.length, ++c1) {
            for (int j = (i+1)%p.length, c2 = c1+1; c2 < size; j = (j+1)%p.length, ++c2) {
                if (p[i].id > p[j].id) {
                    Patient temp = p[i];
                    p[i] = p[j];
                    p[j] = temp;
                }
            }
        }
    }

    public Patient[] copy(Patient[] oldArray) {
        Patient[] newArray = new Patient[oldArray.length];
        for (int i = 0; i < oldArray.length; ++i) {
            newArray[i] = oldArray[i];
        }
        return newArray;
    }

}
