import React from 'react';


const ExchangeService = {

  getExchanges: async function() {
    return await fetch(`http://localhost:8080/exchanges`, {
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

export { ExchangeService };
