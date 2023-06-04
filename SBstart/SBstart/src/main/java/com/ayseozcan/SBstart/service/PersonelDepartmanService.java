package com.ayseozcan.SBstart.service;

import com.ayseozcan.SBstart.repository.IPersonelDepartmanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonelDepartmanService {
    private final IPersonelDepartmanRepository personelDepartmanRepository;
}
