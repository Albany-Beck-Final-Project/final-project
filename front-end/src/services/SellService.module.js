import React from 'react';




const SellService = {

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
      direction: "SELL"
    }
  ];
}

export { SellService };
