import React from 'react';




const BuyService = {

    getOrders: getOrders

}

function getOrders() {
  return [
    {
      id: 1014,
      date: "14 OCT 2021",
      stock: "AAPL",
      shares: 4,
      price: 192.84,
      status: "FILLED",
      direction: "BUY"
    }
  ];
}

export { BuyService };