import React from 'react';
import { SellService, BuyService } from './index.js';


const OrderService = {

  orderAllOrders: function(buy, sell) {
    let unsorted = [...buy, ...sell]
    return unsorted.sort((first, second) => {
      const firstDate = new Date(first.timeOfPurchase);
      const secondDate = new Date(second.timeOfPurchase);
      return secondDate - firstDate
    })
  },
  orderBuyOrSellOrders: function([orders, sortDirection]) {
    let unsorted = [...orders]
    return unsorted.sort((first, second) => {
      const firstPrice = first.price;
      const secondPrice = second.price;
      if (sortDirection === "DESC") {
        return secondPrice - firstPrice;
      } else {
        return firstPrice - secondPrice;
      }
    })
  },
  getAllUserOrders: async function() {
    return [...await BuyService.getUserOrders(), ...await SellService.getUserOrders()];
  }

}


export { OrderService };
