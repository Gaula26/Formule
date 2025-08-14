/*
Author: Annah Gaula Manda (230164250)
Date: 08/08/2025
 */

package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.CartItems;

import java.util.List;

@Service
public interface ICartItemsService extends IService<CartItems, Integer>{
    List<CartItems> getAll();

}
