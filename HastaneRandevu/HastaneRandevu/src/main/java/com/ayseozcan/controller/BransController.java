package com.ayseozcan.controller;

import com.ayseozcan.dto.request.BransSaveRequestDto;
import com.ayseozcan.repository.entity.Brans;
import com.ayseozcan.service.BransService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.ayseozcan.constants.RestApiList.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(BRANS)
public class BransController {
    private final BransService bransService;
    @PostMapping(SAVE)
    public Brans save(@RequestBody @Valid BransSaveRequestDto dto){
        return bransService.save(dto);
    }
    @PostMapping(FINDALL)
    public ResponseEntity<List<Brans>> findAll(){
        return ResponseEntity.ok(bransService.findAll());
    }
}
