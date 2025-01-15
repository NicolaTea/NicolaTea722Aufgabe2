import Controller.Controller;
import Model.Medicament;
import Model.Patient;
import Repo.InMemoryRepo;
import View.View;

public class Main {
    public static void main(String[] args) {
        InMemoryRepo<Patient> patient=new InMemoryRepo<>();
        InMemoryRepo<Medicament> medicament=new InMemoryRepo<>();
         Controller controller=new Controller(medicament,patient);
         View view=new View(controller);
         view.start();
    }
}