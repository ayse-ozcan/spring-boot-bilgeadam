package com.ayseozcan.controller;
import com.ayseozcan.dto.request.HastaSaveRequestDto;
import com.ayseozcan.repository.entity.Hasta;
import com.ayseozcan.service.HastaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ayseozcan.constants.RestApiList.*;
@RestController
@AllArgsConstructor
@RequestMapping(HASTA)
public class HastaController {
    private final HastaService hastaService;

    @PostMapping(SAVE)
    public Hasta save(@RequestBody @Valid HastaSaveRequestDto dto){
        return hastaService.save(dto);
    }

    @GetMapping(FINDALL)
    public List<Hasta> findAll(){
        return  hastaService.findAll();
    }
}
