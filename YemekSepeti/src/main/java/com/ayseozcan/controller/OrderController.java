package com.ayseozcan.controller;
import com.ayseozcan.dto.request.OrderSaveRequestDto;
import com.ayseozcan.dto.response.OrderSaveResponseDto;
import com.ayseozcan.repository.entity.Order;
import com.ayseozcan.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.ayseozcan.constants.RestApiList.*;
@RestController
@RequiredArgsConstructor
@RequestMapping(ORDER)
public class OrderController {
    private final OrderService orderService;
    @PostMapping(SAVE)
    public ResponseEntity<OrderSaveResponseDto> save(OrderSaveRequestDto dto){
        return ResponseEntity.ok(orderService.save(dto));
    }
    @PostMapping(FINDALL_CUSTOMER_ID)
    public ResponseEntity<List<Order>> findAllByCustomerId(Long id){
        return ResponseEntity.ok(orderService.findAllByCustomerId(id));
    }
    @PostMapping(FINDALL)
    public ResponseEntity<List<Order>> findAll(){
        return ResponseEntity.ok(orderService.findAll());
    }
}
