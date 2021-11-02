import React from 'react';




const BuyService = {

    getOrders: getOrders,
    getUserOrders: getUserOrders

}

const API_URL = 'http://localhost:8080'

async function getUserOrders() {
  return await fetch(`http://localhost:8080/users/buyorders`, {
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
  // return [
  //   {
  //     id: 1014,
  //     date: "14 OCT 2021",
  //     stock: "AAPL",
  //     shares: 4,
  //     price: 192.84,
  //     status: "FILLED",
  //     direction: "BUY"
  //   }
  // ];
  return await fetch(`http://localhost:8080/buyorders`, {
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

export { BuyService };
