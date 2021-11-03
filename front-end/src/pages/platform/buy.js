import React, { useState, useEffect } from 'react';
import { Link, navigate } from 'gatsby';

import { platform, home, homeLink, exchange, exchangeOption, historyMain,  } from '../../components/Platform/platform.module.css';
import { buyPriceInput, buyOption, buyQuantityInput, buyStrategyInput, buyPriceTypeInput, buySubmit } from '../../styles/platform/buy.module.css'

import BuyOrders from '../../components/BuyOrders';

export default (props) => {

  const [buyQuantity, setBuyQuantity] = useState(null);
  const [sorStrategy, setSorStrategy] = useState(null);
  const [orderPriceType, setOrderPriceType] = useState("Market");
  const [orderPrice, setOrderPrice] = useState(null);
  const [orderBook, setOrderBook] = useState(props.location.state.currentBook)




  const _checkIfPriceAllowed = () => {
    // return ((orderPriceType !== "Market Price") && (sorStrategy != "Best Price"))
    return true;
  }

  const generateNewOrder = () => {
    fetch(`http://localhost:8080/buyorders/new`, {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*'
      },
      body: JSON.stringify({
        session: window.btoa(window.localStorage.StockPlatform),
        quantity: buyQuantity,
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
        <div className={buyOption}>

          <input type="number" onChange={(e) => { setBuyQuantity(e.target.value) }} value={buyQuantity} name="quantity" className={buyQuantityInput} placeholder="Quantity" />

          <select name="strategy">
            <option value="Strategy" selected disabled>Strategy</option>
            <option value="NONE" onChange={(e) => { setSorStrategy(e.target.value) }}>NONE</option>
            <option value="Best Price" onChange={(e) => { setSorStrategy(e.target.value) }}>Best Price</option>
            <option value="Max Fill" onChange={(e) => { setSorStrategy(e.target.value) }}>Max Fill</option>
            <option value="Max Rebate" onChange={(e) => { setSorStrategy(e.target.value) }}>Max Rebate</option>
          </select>

          <select name="orderPriceType">
            <option value="Market" selected disabled>Market Price</option>
          </select>

          <input type="number" onChange={(e) => { setOrderPrice(e.target.value) }} value={orderPrice} className={buyPriceInput} style={{ display: _checkIfPriceAllowed() ? "block" : "none" }} placeholder="£/share" />

          {/*<input type="submit" onSubmit={(e) => { e.preventdefault(); generateNewOrder() }} value="BUY" className={buySubmit}/>*/}
          <button onClick={() => { generateNewOrder(); }} className={buySubmit}>BUY</button>
        </div>

        <BuyOrders orderBook={orderBook}/>


      </div>
      <div className={historyMain}></div>
    </div>
  )
}
