package com.ayseozcan.SBstart.service;

import com.ayseozcan.SBstart.repository.IPersonelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonelService {
    private final IPersonelRepository personelRepository;


}
