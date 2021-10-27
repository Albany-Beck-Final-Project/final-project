import React, { useState } from 'react';
import { Link } from 'gatsby';

import { platform, home, homeLink, exchange, exchangeOption, historyMain,  } from '../../styles/platform.module.css';
import { sellPriceInput, sellOption, sellQuantityInput, sellStrategyInput, sellPriceTypeInput, sellSubmit } from '../../styles/platform/sell.module.css'

import SellOrders from '../../components/SellOrders';

export default () => {

  const [sellQuantity, setSellQuantity] = useState(null);
  const [sorStrategy, setSorStrategy] = useState(null);
  const [orderPriceType, setOrderPriceType] = useState("Market Price");
  const [orderPrice, setOrderPrice] = useState(0);


  const _checkIfPriceAllowed = () => {
    // return ((orderPriceType !== "Market Price") && (sorStrategy != "Best Price"))
    return true;
  }

  const convertOrderPrice = () => {
    return "£" + orderPrice;
  }

  return (
    <div className={platform}>
      <div className={home}>
        <Link to="/platform" className={homeLink}>Back</Link>
      </div>

      <div className={exchange}>
        <div className={sellOption}>

          <input type="number" onChange={(e) => { setSellQuantity(e.target.value) }} value={sellQuantity} name="quantity" className={sellQuantityInput} placeholder="Quantity" />

          <select name="strategy">
            <option value="Strategy" selected disabled>Strategy</option>
            <option value="Best Price" onChange={(e) => { setSorStrategy(e.target.value) }}>Best Price</option>
            <option value="Max Fill" onChange={(e) => { setSorStrategy(e.target.value) }}>Max Fill</option>
            <option value="Max Rebate" onChange={(e) => { setSorStrategy(e.target.value) }}>Max Rebate</option>
          </select>

          <select name="orderPriceType">
            <option value="Market Price" selected disabled>Market Price</option>
          </select>

          <input type="number" onChange={(e) => { setOrderPrice(e.target.value) }} value={convertOrderPrice()} className={sellPriceInput} style={{ display: _checkIfPriceAllowed() ? "block" : "none" }} placeholder="£/share"/>

          <input type="submit" onSubmit={(e) => { e.preventdefault() }} value="SELL" className={sellSubmit}/>
        </div>

        <SellOrders />


      </div>
      <div className={historyMain}></div>
    </div>
  )
}
