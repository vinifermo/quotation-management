package com.example.quotationmanagement.service;

import com.example.quotationmanagement.entity.User;
import com.example.quotationmanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }
}