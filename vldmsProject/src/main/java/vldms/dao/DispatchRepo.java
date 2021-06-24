package vldms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vldms.models.Order_dispatch_table;

@Repository
public interface DispatchRepo extends JpaRepository<Order_dispatch_table,Integer> 
{

}
