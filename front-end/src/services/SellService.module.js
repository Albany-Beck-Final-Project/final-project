import React from 'react';




const SellService = {

    getOrders: getOrders,
    getUserOrders: getUserOrders

}

const API_URL = 'http://localhost:8080'

async function getUserOrders() {
  return await fetch(`http://localhost:8080/users/sellorders`, {
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
  // .then(data => data)
}

async function getOrders(stock) {
  return await fetch(`http://localhost:8080/sellorders`, {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*'
    },
    body: JSON.stringify({
      session: window.btoa(window.localStorage.StockPlatform),
      stock: stock
    })
  })
  .then(res => res.json())
}

export { SellService };
