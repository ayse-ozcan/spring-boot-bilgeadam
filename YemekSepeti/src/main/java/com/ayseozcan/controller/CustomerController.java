package com.ayseozcan.controller;

import com.ayseozcan.dto.request.ActivateStatusRequestDto;
import com.ayseozcan.dto.request.CardDetailsSaveRequestDto;
import com.ayseozcan.dto.request.CustomerLoginRequestDto;
import com.ayseozcan.dto.request.CustomerRegisterRequestDto;
import com.ayseozcan.dto.response.CustomerFindAllResponseDto;
import com.ayseozcan.dto.response.CustomerRegisterResponseDto;
import com.ayseozcan.service.CustomerService;
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
@RequestMapping(CUSTOMER)
public class CustomerController {
    private final CustomerService customerService;
    @PostMapping(REGISTER)
    public ResponseEntity<CustomerRegisterResponseDto> register(@RequestBody @Valid CustomerRegisterRequestDto dto){
        return ResponseEntity.ok(customerService.register(dto));
    }
    @PostMapping(LOGIN)
    public ResponseEntity<Boolean> login(@RequestBody @Valid CustomerLoginRequestDto dto){
        return ResponseEntity.ok(customerService.login(dto));
    }
    @PostMapping(ACTIVATE_STATUS)
    public ResponseEntity<Boolean> activateStatus(@RequestBody @Valid ActivateStatusRequestDto dto){
        return ResponseEntity.ok(customerService.activateStatus(dto));
    }
    @PostMapping(FINDALL)
    public ResponseEntity<List<CustomerFindAllResponseDto>> findAllDto(){
        return ResponseEntity.ok(customerService.findAllDto());
    }

}
