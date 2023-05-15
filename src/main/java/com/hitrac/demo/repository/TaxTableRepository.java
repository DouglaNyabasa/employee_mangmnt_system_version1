package com.hitrac.demo.repository;


import com.hitrac.demo.model.TaxTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxTableRepository extends JpaRepository<TaxTable,Long> {

}
