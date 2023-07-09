package com.ayseozcan.service;

import com.ayseozcan.dto.request.RestaurantSaveRequestDto;
import com.ayseozcan.repository.IRestaurantRepository;
import com.ayseozcan.repository.entity.Restaurant;
import com.ayseozcan.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService extends ServiceManager<Restaurant, Long> {
    private final IRestaurantRepository restaurantRepository;

    public RestaurantService(IRestaurantRepository restaurantRepository) {
        super(restaurantRepository);
        this.restaurantRepository = restaurantRepository;
    }
    public Restaurant save(RestaurantSaveRequestDto dto) {
        return restaurantRepository.save(Restaurant.builder()
                .name(dto.getName())
                .point(dto.getPoint())
                .address(dto.getAddress())
                .build());
    }
    public List<Restaurant> findAll(){
        return restaurantRepository.findAll();
    }
}
