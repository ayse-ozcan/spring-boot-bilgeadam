package com.ayseozcan.service;

import com.ayseozcan.dto.request.HastaSaveRequestDto;
import com.ayseozcan.mapper.IHastaMapper;
import com.ayseozcan.repository.IHastaRepository;
import com.ayseozcan.repository.entity.Hasta;
import com.ayseozcan.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class HastaService extends ServiceManager<Hasta, Long> {
    private final IHastaRepository hastaRepository;

    public HastaService(IHastaRepository hastaRepository) {
        super(hastaRepository);
        this.hastaRepository = hastaRepository;
    }

    public Hasta save(HastaSaveRequestDto dto) {
        Hasta hasta = IHastaMapper.INSTANCE.fromSaveDto(dto);
        return save(hasta);
    }
}
