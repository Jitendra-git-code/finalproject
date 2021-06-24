package vldms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import vldms.models.Distribution_to_district_table;
import vldms.models.Vaccination_office_distribution;

@Repository
public interface Vacc_Offi_Repo extends JpaRepository<Vaccination_office_distribution , Integer> 
{

	
	@Query("SELECT v FROM Vaccination_office_distribution v  where v.batch_no = :batch_no")
	   public List<Vaccination_office_distribution> findByBatch_no(int batch_no);

}
