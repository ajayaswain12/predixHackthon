package com.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This class models the spring-data repository for alarmevent entity. Apart form the standard operations supported by
 * CRUD Repository, this class also supports customized named queries ,pagination, sorting and type safe queries using query-dsl.
 * l
 * @author 212350258
 */
@Repository
public interface IEmployee extends JpaRepository<Employee, Long>
{
	
	
	
}