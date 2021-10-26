import React from 'react';

import { eachBuyOrder, orderId, orderDate, orderStock, orderShares, orderPrice, orderStatus, orderDirection, buyMain, headers } from './buyOrders.module.css'
import { SellService, BuyService } from '../../services';


const BuyOrders = ({ direction }) => {

  const renderOrders = () => {
    let rendering = [];
    let orders = BuyService.getOrders();

    orders.forEach((order) => {
      rendering.push(
        <li>
          <div className={eachBuyOrder}>
            <div className={orderDirection} style={{ color: direction === "BUY" ? "#18C412" : "#FF0000" }}><strong>{order.direction}</strong></div>
            <div className={orderStock}>{order.stock}</div>
            <div className={orderShares}>{order.shares}</div>
            <div className={orderPrice}>£{order.totalPrice}</div>
            <div className={orderStatus}>{order.status}</div>

          </div>
        </li>
      )
    })
    return rendering;
  }

  const renderHeaders = () => {
    return (
      <li>
        <div className={eachBuyOrder} style={{ borderWidth: 0, marginBottom: 20, fontStyle: "italic" }}>
          <div className={orderDirection}>Direction</div>
          <div className={orderStock}>Symbol</div>
          <div className={orderShares}>Quantity</div>
          <div className={orderPrice}>£/share</div>
          <div className={orderStatus}>Status</div>
        </div>
      </li>
    )
  }

  return (
    <div className={buyMain}>
    {/* BUY LOW */}
      <ul>
        { renderHeaders() }
        { renderOrders() }
      </ul>
    </div>
  )
}
export default BuyOrders;
