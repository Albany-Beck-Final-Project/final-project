import React from 'react';
import { Link, navigate } from 'gatsby';

import { platform, home, homeLink, exchange, exchangeOption, buyOption, sellOption, buyMain, sellMain, historyMain } from '../styles/platform.module.css';
import { eachBuyOrder, orderId, orderDate, orderStock, orderShares, orderPrice, orderStatus, orderDirection } from '../styles/order.module.css'


const Platform = () => {
  // if(!(window.localStorage.StockPlatform)) {
  //   navigate("/login");
  // }

  const renderBuyOrders = () => {
    return (
      <li>
        <div className={eachBuyOrder}>
          <div className={orderId}>1014</div>
          <div className={orderDate}>24 OCT 2021</div>
          <div className={orderStock}>AAPL</div>
          <div className={orderShares}>4</div>
          <div className={orderPrice}>£592.48</div>
          <div className={orderStatus}>FILLED</div>
          <div className={orderDirection} style={{ color: "#18C412" }}><strong>BUY</strong></div>
        </div>
      </li>
    )
  }

  const renderSellOrders = () => {
    return (
      <li>
        <div className={eachBuyOrder}>
          <div className={orderId}>1014</div>
          <div className={orderDate}>24 OCT 2021</div>
          <div className={orderStock}>AAPL</div>
          <div className={orderShares}>4</div>
          <div className={orderPrice}>£592.48</div>
          <div className={orderStatus}>FILLED</div>
          <div className={orderDirection} style={{ color: "#18C412" }}><strong>SELL</strong></div>
        </div>
      </li>
    )
  }

  const renderExchanges = () => {
    return (null)
  }

  return (
    <div className={platform}>
      <div className={home}>
        <Link to="/" className={homeLink}>Home</Link>
      </div>

      <div className={exchange}>
        <div className={exchangeOption}>

        <button className={buyOption}>BUY</button>
        { renderExchanges() }
        <button className={sellOption}>SELL</button>

        </div>

        <div className={buyMain}>
        {/* BUY LOW */}
          <ul>
            { renderBuyOrders() }
          </ul>
        </div>

        <div className={sellMain}>
          {/* SELL HIGH */}
          <ul>
            { renderSellOrders() }
          </ul>
        </div>
      </div>
      <div className={historyMain}></div>
    </div>
  )
}

export default Platform;
