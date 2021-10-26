import React from 'react';

import { sellMain, eachBuyOrder, orderId, orderDate, orderStock, orderShares, orderPrice, orderStatus, orderDirection } from './sellOrders.module.css'

const SellOrders = ({ ...props }) => {

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

  return (
    <div className={sellMain}>
      {/* SELL HIGH */}
      <ul>
        { renderSellOrders() }
      </ul>
    </div>
  )
}
export default SellOrders;
