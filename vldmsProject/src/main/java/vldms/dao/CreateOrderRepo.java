package vldms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vldms.models.Order_detail_table;

@Repository
public interface CreateOrderRepo extends JpaRepository<Order_detail_table, Integer>
{

}
