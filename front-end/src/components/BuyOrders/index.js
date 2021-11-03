import React, { useState, useEffect } from 'react';

import { eachBuyOrder, orderId, orderDate, orderStock, orderShares, orderPrice, orderStatus, orderDirection, buyMain, headers } from './buyOrders.module.css'
import { BuyService } from '../../services';


const BuyOrders = ({ orderBook }) => {

  const [orderList, setOrderList] = useState([])

  useEffect(() => {
    async function getOrders() {
      setOrderList(await BuyService.getOrders(orderBook))
    }

    getOrders();
  }, [])

  const renderOrders = () => {
    let rendering = [];
    // let orders = BuyService.getOrders(stock);

    orderList.forEach((order) => {
      rendering.push(
        <li>
          <div className={eachBuyOrder}>
            <div className={orderDirection} style={{ color: "#18C412" }}><strong>BUY</strong></div>
            <div className={orderStock}>{order.orderBook.companyName}</div>
            <div className={orderShares}>{order.shares}</div>
            <div className={orderPrice}>£{order.price.toLocaleString(undefined, {minimumFractionDigits: 2, maximumFractionDigits: 2})}</div>
            <div className={orderStatus}>{order.orderStatus}</div>

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
          <div className={orderStock}>Stock</div>
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
