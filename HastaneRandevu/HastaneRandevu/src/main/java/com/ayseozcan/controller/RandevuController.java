package com.ayseozcan.controller;
import com.ayseozcan.dto.request.RandevuSaveRequestDto;
import com.ayseozcan.repository.entity.Randevu;
import com.ayseozcan.service.RandevuService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ayseozcan.constants.RestApiList.*;
@RestController
@AllArgsConstructor
@RequestMapping(RANDEVU)
public class RandevuController {
    private final RandevuService randevuService;
    @PostMapping(SAVE)
    public Randevu save(@RequestBody @Valid RandevuSaveRequestDto dto){
        return randevuService.save(dto);
    }
    @GetMapping("/findmostfrequent")
    public List<Randevu> mostFrequent(){
        return randevuService.mostFrequent();
    }
}
