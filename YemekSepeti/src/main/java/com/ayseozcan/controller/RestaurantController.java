package com.ayseozcan.controller;
import com.ayseozcan.dto.request.RestaurantSaveRequestDto;
import com.ayseozcan.repository.entity.Restaurant;
import com.ayseozcan.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.ayseozcan.constants.RestApiList.*;
@RestController
@RequiredArgsConstructor
@RequestMapping(RESTAURANT)
public class RestaurantController {
    private final RestaurantService restaurantService;
    @PostMapping(SAVE)
    public ResponseEntity<Restaurant> save(RestaurantSaveRequestDto dto){
        return ResponseEntity.ok(restaurantService.save(dto));
    }
    @PostMapping(FINDALL)
    public ResponseEntity<List<Restaurant>> findAll(){
        return ResponseEntity.ok(restaurantService.findAll());
    }
}
