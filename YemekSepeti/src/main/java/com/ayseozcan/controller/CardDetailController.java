package com.ayseozcan.controller;

import com.ayseozcan.dto.request.CardDetailsSaveRequestDto;
import com.ayseozcan.service.CardDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.ayseozcan.constants.RestApiList.*;
@RestController
@RequiredArgsConstructor
@RequestMapping(CARD_DETAIL)
public class CardDetailController {
    private final CardDetailService cardDetailService;
    @PostMapping(SAVE_CARD_DETAILS)
    public ResponseEntity<Boolean> saveCardDetails(CardDetailsSaveRequestDto dto){
        return ResponseEntity.ok(cardDetailService.saveCardDetails(dto));
    }
}
