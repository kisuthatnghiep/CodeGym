package com.example.module_4.service;

import com.example.module_4.model.Branch;
import com.example.module_4.repository.IBranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BranchService implements IBranchService{
    @Autowired
    private IBranchRepository branchRepository;
    @Override
    public Iterable<Branch> findAll() {
        return branchRepository.findAll();
    }

    @Override
    public Optional<Branch> findById(Long id) {
        return branchRepository.findById(id);
    }

    @Override
    public boolean save(Branch branch) {
        branchRepository.save(branch);
        return true;
    }

    @Override
    public void remove(Long id) {
        branchRepository.deleteById(id);
    }
}
