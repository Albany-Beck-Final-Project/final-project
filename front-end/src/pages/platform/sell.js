import React, { useState, useEffect } from 'react';
import { Link, navigate } from 'gatsby';

import { platform, home, homeLink, exchange, exchangeOption, historyMain,  } from '../../components/Platform/platform.module.css';
import { sellPriceInput, sellOption, sellQuantityInput, sellStrategyInput, sellPriceTypeInput, sellSubmit } from '../../styles/platform/sell.module.css'

import SellOrders from '../../components/SellOrders';

export default (props) => {

  const [sellQuantity, setsellQuantity] = useState(null);
  const [sorStrategy, setSorStrategy] = useState(null);
  const [orderPriceType, setOrderPriceType] = useState("Market Price");
  const [orderPrice, setOrderPrice] = useState(null);
  const [orderBook, setOrderBook] = useState(props.location.state.currentBook)




  const _checkIfPriceAllowed = () => {
    // return ((orderPriceType !== "Market Price") && (sorStrategy != "Best Price"))
    return true;
  }

  const generateNewOrder = () => {
    fetch(`http://localhost:8080/sellorders/new`, {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*'
      },
      body: JSON.stringify({
        session: window.btoa(window.localStorage.StockPlatform),
        quantity: sellQuantity,
        sorStrategy: sorStrategy,
        type: orderPriceType,
        price: orderPrice,
        companyName: orderBook
      })
    })
    .then(res => res.json())
    .then(data => {
      console.log(data)
      navigate("/platform")
    })
  }

  return (
    <div className={platform}>
      <div className={home}>
        <Link to="/platform" className={homeLink}>Back</Link>
      </div>

      <div className={exchange}>
        <div className={sellOption}>

          <input type="number" onChange={(e) => { setsellQuantity(e.target.value) }} value={sellQuantity} name="quantity" className={sellQuantityInput} placeholder="Quantity" />

          <select name="strategy">
            <option value="Strategy" selected disabled>Strategy</option>
            <option value="NONE" onChange={(e) => { setSorStrategy(e.target.value) }}>NONE</option>
            <option value="Best Price" onChange={(e) => { setSorStrategy(e.target.value) }}>Best Price</option>
            <option value="Max Fill" onChange={(e) => { setSorStrategy(e.target.value) }}>Max Fill</option>
            <option value="Max Rebate" onChange={(e) => { setSorStrategy(e.target.value) }}>Max Rebate</option>
          </select>

          <select name="orderPriceType">
            <option value="Market Price" selected disabled>Market Price</option>
          </select>

          <input type="number" onChange={(e) => { setOrderPrice(e.target.value) }} value={orderPrice} className={sellPriceInput} style={{ display: _checkIfPriceAllowed() ? "block" : "none" }} placeholder="??/share" />

          {/*<input type="submit" onSubmit={(e) => { e.preventdefault(); generateNewOrder() }} value="BUY" className={buySubmit}/>*/}
          <button onClick={() => { generateNewOrder(); }} className={sellSubmit}>SELL</button>
        </div>

        <SellOrders orderBook={orderBook}/>


      </div>
      <div className={historyMain}></div>
    </div>
  )
}
