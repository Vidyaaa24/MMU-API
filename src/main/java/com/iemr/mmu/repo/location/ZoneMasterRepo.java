package com.iemr.mmu.repo.location;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.iemr.mmu.data.location.ZoneMaster;

public interface ZoneMasterRepo extends CrudRepository<ZoneMaster, Integer> {
	@Query(" SELECT zoneID, zoneName FROM ZoneMaster WHERE providerServiceMapID = :providerServiceMapID AND deleted != 1 ")
	public ArrayList<Object[]> getZoneMaster(@Param("providerServiceMapID") Integer providerServiceMapID);
}
