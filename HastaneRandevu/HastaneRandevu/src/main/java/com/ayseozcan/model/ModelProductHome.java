package com.ayseozcan.model;

import com.ayseozcan.repository.view.VwProduct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ModelProductHome {
    /**
     * sol menüdeki liste bilgilerine
     * ürünlerin listesine
     * başlığa
     * v.s.
     */
    List<String> menuList;
    String title;
    Long userId;
    String userName;
    String userImage;
    List<VwProduct> urunListesi;

}
