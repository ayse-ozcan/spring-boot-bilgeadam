package com.ayseozcan.controller;

import com.ayseozcan.dto.request.DoktorSaveRequestDto;
import com.ayseozcan.dto.response.DoktorResponseDto;
import com.ayseozcan.repository.entity.Doktor;
import com.ayseozcan.repository.view.VwDoktor;
import com.ayseozcan.service.DoktorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.ayseozcan.constants.RestApiList.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(DOKTOR)
public class DoktorController {
    private final DoktorService doktorService;
    @Value("${myapplication.name}")
    private String uygulamaAdi;
    @GetMapping("/uygulamaadi")
    public String getActiveApplicationFile(){
        return uygulamaAdi;
    }
    @PostMapping(SAVE)
    public Doktor save(@RequestBody @Valid DoktorSaveRequestDto dto) {
        return doktorService.save(dto);
    }

    @GetMapping(FINDBYAD)
    public List<Doktor> findByAd(String ad) {
        return doktorService.findByAd(ad);
    }

    /**
     * TODO: FINDALL - responsedto ve view olarak donus yapan 2 method yaziniz.++
     * 1.method da doktorlari cekip DTO ya donusturup listeleyiniz.
     * 2.method da direkt DB den alinan kayitlari View olarak alip donus yapiniz.
     */
    @GetMapping(FINDALLDTO)
    public List<DoktorResponseDto> findAllResponse() {
        return doktorService.findAllResponse();
    }

    @GetMapping("/findallview")
    public List<VwDoktor> findAllView() {
        List<Doktor> doktorList = doktorService.findAll();
        List<VwDoktor> result = new ArrayList<>();
        doktorList.forEach(doktor -> {
            VwDoktor vwDoktor = VwDoktor.builder()
                    .id(doktor.getId())
                    .ad(doktor.getAd())
                    .bransid(doktor.getBransid())
                    .build();
            result.add(vwDoktor);
        });
        return result;
    }
    @GetMapping(FINDALL)
    public List<Doktor> findAll(){
        return doktorService.findAll();

    }

}
