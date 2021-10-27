import React from 'react';

import { eachBuyOrder, orderId, orderDate, orderStock, orderShares, orderPrice, orderStatus, orderDirection } from './orders.module.css'
import { SellService, BuyService } from '../../services';


const Orders = ({ className, direction }) => {

  const renderOrders = () => {
    let rendering = [];
    let orders = direction === "BUY" ? BuyService.getOrders() : SellService.getOrders();

    orders.forEach((order) => {
      rendering.push(
        <li>
          <div className={eachBuyOrder}>
            <div className={orderDirection} style={{ color: direction === "BUY" ? "#18C412" : "#FF0000" }}><strong>{order.direction}</strong></div>
            <div className={orderStock}>{order.stock}</div>
            <div className={orderShares}>{order.shares}</div>
            <div className={orderPrice}>£{order.price}</div>

          </div>
        </li>
      )
    })
    return rendering;
  }

  const renderOrderHeaders = () => {
    return (
      <li>
        <div className={eachBuyOrder} style={{ marginBottom: 10, fontStyle: "italic" }}>
          <div className={orderDirection}>Direction</div>
          <div className={orderStock}>Stock</div>
          <div className={orderShares}>Shares</div>
          <div className={orderPrice}>£/share</div>

        </div>
      </li>
    )
  }

  return (
    <div className={className}>
    {/* BUY LOW */}
      <ul>
        { renderOrderHeaders() }
        { renderOrders() }
      </ul>
    </div>
  )
}
export default Orders;
