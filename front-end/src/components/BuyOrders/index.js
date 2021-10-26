import React from 'react';

import { buyMain, eachBuyOrder, orderId, orderDate, orderStock, orderShares, orderPrice, orderStatus, orderDirection } from './buyOrders.module.css'

const BuyOrders = ({ ...props }) => {

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

  return (
    <div className={buyMain}>
    {/* BUY LOW */}
      <ul>
        { renderBuyOrders() }
      </ul>
    </div>
  )
}
export default BuyOrders;
