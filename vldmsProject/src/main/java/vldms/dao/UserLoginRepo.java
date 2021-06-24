package vldms.dao;





import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import vldms.models.User_table;


@Repository
public interface UserLoginRepo extends JpaRepository<User_table,String>
{

	
}
