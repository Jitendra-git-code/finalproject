package vldms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vldms.models.Consignment_usage_table;

@Repository
public interface Consignment_usage_Repo extends JpaRepository<Consignment_usage_table , Integer> 
{

}
