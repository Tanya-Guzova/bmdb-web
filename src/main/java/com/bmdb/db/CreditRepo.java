package com.bmdb.db;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bmdb.business.Credit;
//the interface gives us the access to CRUD functions
public interface CreditRepo extends JpaRepository<Credit, Integer> {

}
