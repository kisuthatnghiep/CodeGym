package com.example.module_4.repository;

import com.example.module_4.model.Branch;
import com.example.module_4.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findAllByBranch(Branch branch);
    @Query(value = "select * from Employee order by age asc", nativeQuery = true)
    List<Employee> sortByAge();
}
