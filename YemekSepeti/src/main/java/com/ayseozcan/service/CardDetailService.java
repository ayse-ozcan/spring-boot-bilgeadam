package com.ayseozcan.service;

import com.ayseozcan.dto.request.CardDetailsSaveRequestDto;
import com.ayseozcan.repository.ICardDetailRepository;
import com.ayseozcan.repository.entity.CardDetail;
import com.ayseozcan.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class CardDetailService extends ServiceManager<CardDetail, Long> {
    private final ICardDetailRepository cardDetailRepository;
    public CardDetailService(ICardDetailRepository cardDetailRepository) {
        super(cardDetailRepository);
        this.cardDetailRepository = cardDetailRepository;
    }
    public Boolean saveCardDetails(CardDetailsSaveRequestDto dto){
        CardDetail cardDetail = CardDetail.builder()
                .customerid(dto.getCustomerid())
                .cardName(dto.getCardName())
                .cardNumber(dto.getCardNumber())
                .cvv(dto.getCvv())
                .cardExpiration(dto.getCardExpiration())
                .balance(dto.getBalance())
                .build();
        cardDetailRepository.save(cardDetail);
        return true;
    }
}
