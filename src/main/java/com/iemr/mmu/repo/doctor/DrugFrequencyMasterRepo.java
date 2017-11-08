package com.iemr.mmu.repo.doctor;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.doctor.DrugFrequencyMaster;
@Repository
public interface DrugFrequencyMasterRepo extends CrudRepository<DrugFrequencyMaster, Integer> {
	@Query("SELECT c FROM DrugFrequencyMaster c where c.deleted != 1")
	public ArrayList<DrugFrequencyMaster> getDrugFrequencyMaster();
}