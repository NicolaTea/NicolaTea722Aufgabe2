package View;

import Controller.Controller;
import Model.Medicament;
import Model.Patient;

import java.util.List;
import java.util.Scanner;

public class View {
    private final Controller controller;
    private final Scanner scanner;

    public View(Controller controller){
        this.controller=controller;
        this.scanner=new Scanner(System.in);
    }

    public void start(){
        while(true){
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add Patient");
            System.out.println("2. Update Patient ");
            System.out.println("3. Delete Patient");
            System.out.println("4. Add Medicament");
            System.out.println("5. Update Medicament");
            System.out.println("6. Delete Medicament");
            System.out.println("7. Display all Patient");
            System.out.println("8. Display all Medicament");
            System.out.println("9. Filter by diagnose");
            System.out.println("10. Add Medicament to patient");
            System.out.println("11. Sort Medicament");
            System.out.println("12. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    updatePatient();
                    break;
                case 3:
                    deletePatient();
                    break;
                case 4:
                    addMedicament();
                    break;
                case 5:
                    updateMedicament();
                    break;
                case 6:
                    deleteMedicament();
                    break;
                case 7:
                    showAllPatient();
                    break;
                case 8:
                    showAllMedicament();
                    break;
                case 9:
                    filterbyDiagnose();
                    break;
                case 10:
                    addMedicamentToPatient();
                    break;
                case 11:
                    sortMedicamente();
                    break;
                case 12:
                    System.out.println("Exiting the application.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addPatient() {
        System.out.println("Enter  id:");
        int id=scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter  name:");
        String name = scanner.nextLine();
        System.out.println("Enter age: ");
        int age=scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter diagnose");
        String diagnose=scanner.nextLine();
        controller.addPatient(new Patient(id,name,age,diagnose));

    }


    private void updatePatient() {
        System.out.println("Enter  id to update :");
        int id=scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter  name:");
        String name = scanner.nextLine();
        System.out.println("Enter age: ");
        int age=scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter diagnose");
        String diagnose=scanner.nextLine();
        controller.updatePatient(new Patient(id,name,age,diagnose));
    }


    private void deletePatient() {
        System.out.print("Enter  ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        controller.deletePatient(id);

    }


    private void addMedicament() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter  name: ");
        String name = scanner.nextLine();
        System.out.println("Enter price: ");
        double price=scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter disease: ");
        String disease=scanner.nextLine();
        controller.addMedicament(new Medicament(id,name,price,disease));

    }


    private void updateMedicament() {
        System.out.print("Enter ID to update : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter  name: ");
        String name = scanner.nextLine();
        System.out.println("Enter price: ");
        double price=scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter disease: ");
        String disease=scanner.nextLine();
        controller.updateMedicament(new Medicament(id,name,price,disease));



    }

    private void deleteMedicament() {
        System.out.print("Enter ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        controller.deleteMedicament(id);

    }

    public void addMedicamentToPatient(){
        System.out.print("Enter the patient ID: ");
        int patientId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter the product ID: ");
        int medicamentId = Integer.parseInt(scanner.nextLine());
        controller.addMedicamentToPatient(patientId, medicamentId);
    }

    public void filterbyDiagnose(){
        System.out.println("Enter diagnose: ");
        String diagnose=scanner.nextLine();
        var filteredPatient=controller.filterByDiagnose(diagnose);
        System.out.println("Patient with "+diagnose+": "+filteredPatient);
    }

    public void sortMedicamente(){
        System.out.print("Enter patient ID to sort products: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter sort order (ascending/descending): ");
        String sortOrder = scanner.nextLine();

        boolean ascending = sortOrder.equalsIgnoreCase("ascending");
        var sortedMedicament = controller.sortMedicament(patientId, ascending);
        System.out.println("Sorted Medicament: " + sortedMedicament);
    }

    public void showAllMedicament(){
        List<Medicament> medicaments=controller.getAllMedicamnet();
        System.out.println("All available medicaments:");
        medicaments.forEach(m -> System.out.println("ID: "+m.getId()+", Name: "+m.getName() + ", Price: " + m.getPrice() + ", Disease: " + m.getDisease()));
    }

    public void showAllPatient(){
        List<Patient> patients=controller.getAllPatient();
        System.out.println("All available patients: ");
        patients.forEach(p->System.out.println("ID: "+p.getId()+", Name: "+p.getName() + ", Age: " + p.getAge() + ",Diagnose "+p.getDiagnose()));
    }




}
