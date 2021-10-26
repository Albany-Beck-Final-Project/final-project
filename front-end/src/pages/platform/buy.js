import React, { useState } from 'react';
import { Link } from 'gatsby';

import { platform, home, homeLink, exchange, exchangeOption, historyMain,  } from '../../styles/platform.module.css';
import { buyPriceInput, buyOption, buyQuantityInput, buyStrategyInput, buyPriceTypeInput, buySubmit } from '../../styles/platform/buy.module.css'

import BuyOrders from '../../components/BuyOrders';

export default () => {

  const [buyQuantity, setBuyQuantity] = useState(null);
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
        <Link to="/" className={homeLink}>Home</Link>
      </div>

      <div className={exchange}>
        <div className={buyOption}>

          <input type="number" onChange={(e) => { setBuyQuantity(e.target.value) }} value={buyQuantity} name="quantity" className={buyQuantityInput} placeholder="Quantity" />

          <select name="strategy">
            <option value="Strategy" selected disabled>Strategy</option>
            <option value="Best Price" onChange={(e) => { setSorStrategy(e.target.value) }}>Best Price</option>
            <option value="Max Fill" onChange={(e) => { setSorStrategy(e.target.value) }}>Max Fill</option>
            <option value="Max Rebate" onChange={(e) => { setSorStrategy(e.target.value) }}>Max Rebate</option>
          </select>

          <select name="orderPriceType">
            <option value="Market Price" selected disabled>Market Price</option>
          </select>

          <input type="number" onChange={(e) => { setOrderPrice(e.target.value) }} value={convertOrderPrice()} className={buyPriceInput} style={{ display: _checkIfPriceAllowed() ? "block" : "none" }} placeholder="£/share"/>

          <input type="submit" onSubmit={(e) => { e.preventdefault() }} value="BUY" className={buySubmit}/>
        </div>

        <BuyOrders direction="BUY" />


      </div>
      <div className={historyMain}></div>
    </div>
  )
}
