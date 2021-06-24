package vldms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vldms.models.VO_dispatch_table;

@Repository
public interface VO_dispatch_Repo extends JpaRepository<VO_dispatch_table, Integer> {

}
