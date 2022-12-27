package com.example.th_mobile_manager.repository;

import com.example.th_mobile_manager.model.Smartphone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISmartPhoneRepository extends CrudRepository<Smartphone, Long> {
}
