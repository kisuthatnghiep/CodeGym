package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService {
    @Autowired
    private ICustomerRepository customerRepository;
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findById(Long id) {
        return customerRepository.findById(id);
    }

    public void save(Customer customer) throws DuplicateEmailException{
        try {
        customerRepository.save(customer);
        }catch (DataIntegrityViolationException e){
            throw new DuplicateEmailException();
        }
    }

    public void remove(Long id) {
        customerRepository.remove(id);
    }
}
