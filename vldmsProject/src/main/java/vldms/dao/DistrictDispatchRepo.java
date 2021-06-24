package vldms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import vldms.models.District_dispatch_table;

public interface DistrictDispatchRepo extends JpaRepository<District_dispatch_table, Integer> 
{

}
