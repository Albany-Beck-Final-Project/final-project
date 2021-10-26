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
            <div className={orderId}>{order.id}</div>
            <div className={orderDate}>{order.date}</div>
            <div className={orderStock}>{order.stock}</div>
            <div className={orderShares}>{order.shares}</div>
            <div className={orderPrice}>£{order.totalPrice}</div>
            <div className={orderStatus}>{order.status}</div>
            <div className={orderDirection} style={{ color: "#18C412" }}><strong>{order.direction}</strong></div>
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
