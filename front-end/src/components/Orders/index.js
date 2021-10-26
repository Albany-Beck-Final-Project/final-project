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
            <div className={orderPrice}>£{order.totalPrice}</div>

          </div>
        </li>
      )
    })
    return rendering;
  }

  return (
    <div className={className}>
    {/* BUY LOW */}
      <ul>
        { renderOrders() }
      </ul>
    </div>
  )
}
export default Orders;
