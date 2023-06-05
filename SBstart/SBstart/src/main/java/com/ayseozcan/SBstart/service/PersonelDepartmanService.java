package com.ayseozcan.SBstart.service;

import com.ayseozcan.SBstart.repository.IPersonelDepartmanRepository;
import com.ayseozcan.SBstart.repository.entity.PersonelDepartman;
import com.ayseozcan.SBstart.utility.ServiceManager;
import org.springframework.stereotype.Service;


@Service
public class PersonelDepartmanService extends ServiceManager<PersonelDepartman,Long> {

    private final IPersonelDepartmanRepository personelDepartmanRepository;

    public PersonelDepartmanService(IPersonelDepartmanRepository repository, IPersonelDepartmanRepository personelDepartmanRepository) {
        super(repository);
        this.personelDepartmanRepository = personelDepartmanRepository;
    }
}
