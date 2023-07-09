package com.ayseozcan.service;

import com.ayseozcan.dto.request.OrderSaveRequestDto;
import com.ayseozcan.dto.response.OrderSaveResponseDto;
import com.ayseozcan.repository.ICardDetailRepository;
import com.ayseozcan.repository.IOrderRepository;
import com.ayseozcan.repository.entity.Order;
import com.ayseozcan.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService extends ServiceManager<Order, Long> {
    private final IOrderRepository orderRepository;

    public OrderService(IOrderRepository orderRepository) {
        super(orderRepository);
        this.orderRepository = orderRepository;
    }
    public OrderSaveResponseDto save(OrderSaveRequestDto dto) {
        orderRepository.save(Order.builder()
                .customerid(dto.getCustomerid())
                .restaurantid(dto.getRestaurantid())
                .productid(dto.getProductid())
                .dateTime(LocalDateTime.now())
                .build());
        return OrderSaveResponseDto.builder()
                .message("your order has been received")
                .build();
    }

    public List<Order> findAllByCustomerId(Long id) {
        return orderRepository.findAllByCustomerid(id);
    }
    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}
