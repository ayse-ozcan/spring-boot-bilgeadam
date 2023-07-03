package com.ayseozcan.controller;

import com.ayseozcan.dto.request.RandevuSaveRequestDto;
import com.ayseozcan.dto.response.RandevuFindAllResponseDto;
import com.ayseozcan.dto.response.RandevuSaveResponseDto;
import com.ayseozcan.repository.entity.Randevu;
import com.ayseozcan.service.RandevuService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.ayseozcan.constants.RestApiList.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(RANDEVU)
public class RandevuController {
    private final RandevuService randevuService;
    @PostMapping(SAVE)
    public RandevuSaveResponseDto save(@RequestBody @Valid RandevuSaveRequestDto dto){
        return randevuService.save(dto);
    }
    @GetMapping(FINDALL)
    public List<RandevuFindAllResponseDto> findAllDto(){
        return randevuService.findAllDto();
    }
    @GetMapping(FINDALLDURUM)
    public Optional<Randevu> findAllRandevuSaatleri(){
        return randevuService.findOptionalByRandevuDurumFalse();
    }
    @PutMapping(UPDATE)
    public void updateDurum(boolean durum, String email){
         randevuService.updateDurum(durum,email);
    }

}
