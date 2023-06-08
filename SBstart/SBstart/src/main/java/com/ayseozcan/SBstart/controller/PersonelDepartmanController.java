package com.ayseozcan.SBstart.controller;

import com.ayseozcan.SBstart.dto.request.GetNameUpperCaseRequestDto;
import com.ayseozcan.SBstart.exception.ErrorType;
import com.ayseozcan.SBstart.exception.SBstartException2;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personeldepartman")
@RequiredArgsConstructor
public class PersonelDepartmanController {
    @GetMapping("/getname")
    public ResponseEntity<String> getNameUpperCase(@RequestBody GetNameUpperCaseRequestDto dto){
        if(dto.getName() == null)
            throw new SBstartException2(ErrorType.NAME_IS_NULL);
        String nameUpper = dto.getName().toUpperCase();
        return ResponseEntity.ok(nameUpper);
    }
}
