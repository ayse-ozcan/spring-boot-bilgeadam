package com.ayseozcan.SBstart.service;

import com.ayseozcan.SBstart.repository.IPersonelRepository;
import com.ayseozcan.SBstart.repository.entity.Personel;
import com.ayseozcan.SBstart.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class PersonelService extends ServiceManager<Personel,Long> {
    private final IPersonelRepository personelRepository;

    public PersonelService(IPersonelRepository repository, IPersonelRepository personelRepository) {
        super(repository);
        this.personelRepository = personelRepository;
    }
}
