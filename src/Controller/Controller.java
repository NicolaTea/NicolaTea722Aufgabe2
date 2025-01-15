package Controller;

import Model.Medicament;
import Model.Patient;
import Repo.InMemoryRepo;

import java.util.List;

public class Controller {
    private final InMemoryRepo<Medicament> medicamentRepo;
    private final InMemoryRepo<Patient> patientRepo;

    public Controller(InMemoryRepo<Medicament> medicamentRepo,InMemoryRepo<Patient> patientRepo){
        this.medicamentRepo=medicamentRepo;
        this.patientRepo=patientRepo;
    }

    public void addMedicament(Medicament medicament){
        medicamentRepo.add(medicament.getId(),medicament);
    }

    public void updateMedicament(Medicament medicament){
        medicamentRepo.update(medicament.getId(),medicament);
    }

    public void deleteMedicament(int medicamentID){
        medicamentRepo.delete(medicamentID);
    }

    public List<Medicament> getAllMedicamnet(){
        return medicamentRepo.getAll();
    }


    public void addPatient(Patient patient){
        patientRepo.add(patient.getId(),patient);
    }

    public void updatePatient(Patient patient){
        patientRepo.update(patient.getId(),patient);
    }

    public void deletePatient(int patientId){
        patientRepo.delete(patientId);
    }

    public List<Patient> getAllPatient(){
        return patientRepo.getAll();
    }



}
