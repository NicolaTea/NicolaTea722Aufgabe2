package Controller;

import Model.Medicament;
import Model.Patient;
import Repo.InMemoryRepo;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {
    private final InMemoryRepo<Medicament> medicamentRepo;
    private final InMemoryRepo<Patient> patientRepo;

    public Controller(InMemoryRepo<Medicament> medicamentRepo,InMemoryRepo<Patient> patientRepo){
        this.medicamentRepo=medicamentRepo;
        this.patientRepo=patientRepo;
    }

    /**
     * add medicament
     * @param medicament
     */
    public void addMedicament(Medicament medicament){
        medicamentRepo.add(medicament.getId(),medicament);
    }

    /**
     * update medicament
     * @param medicament
     */
    public void updateMedicament(Medicament medicament){
        medicamentRepo.update(medicament.getId(),medicament);
    }

    /**
     * delete medicament
     * @param medicamentID
     */
    public void deleteMedicament(int medicamentID){
        medicamentRepo.delete(medicamentID);
    }

    /**
     * get all medicament
     * @return
     */
    public List<Medicament> getAllMedicamnet(){
        return medicamentRepo.getAll();
    }


    /**
     * add patient
     * @param patient
     */
    public void addPatient(Patient patient){
        patientRepo.add(patient.getId(),patient);
    }

    /**
     * update patient
     * @param patient
     */
    public void updatePatient(Patient patient){
        patientRepo.update(patient.getId(),patient);
    }

    /**
     * delete patient
     * @param patientId
     */
    public void deletePatient(int patientId){
        patientRepo.delete(patientId);
    }

    /**
     * get all patient
     * @return
     */
    public List<Patient> getAllPatient(){
        return patientRepo.getAll();
    }

    /**
     * add medicamentToPatient
     * @param patientid
     * @param medicamentint
     */
    public void addMedicamentToPatient(int patientid,int medicamentint ){
        Patient patient=patientRepo.getById(patientid);
        Medicament medicament=medicamentRepo.getById(medicamentint);
        if (patient != null && medicament!= null) {
            patient.getMedicamentList().add(medicament);
            System.out.println("Medicament '" + medicament.getName() + "' added to Patient '" + patient.getName() + "'.");
        } else {
            System.out.println(" does not exist.");
        }
    }

    /**
     * filter by diagnose
     * @param diagnose
     * @return
     */
    public List<Patient> filterByDiagnose(String diagnose){
        return patientRepo.getAll().stream()
                .filter(p->p.getDiagnose().equalsIgnoreCase(diagnose))
                .collect(Collectors.toList());
    }


    /**
     * sortMedicament
     * @param patientId
     * @param ascending
     * @return
     */
    public List<Medicament> sortMedicament(int patientId, boolean ascending) {
        Patient kunde = patientRepo.getById(patientId);
        if (kunde == null) return List.of();

        return kunde.getMedicamentList().stream()
                .sorted((p1, p2) -> {
                    int comparison = Double.compare(p1.getPrice(), p2.getPrice());
                    return ascending ? comparison : -comparison;
                })
                .collect(Collectors.toList());
    }



}
