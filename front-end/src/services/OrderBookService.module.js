import React from 'react';


const OrderBookService = {

  getAllBooks: async function() {
    return await fetch(`http://localhost:8080/orderbooks`, {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*'
      },
      body: JSON.stringify({
        session: window.btoa(window.localStorage.StockPlatform)
      })
    })
    .then(res => res.json())
  }
}

export { OrderBookService };
