import React, { useEffect, useState } from 'react';

import { eachSellOrder, orderId, orderDate, orderStock, orderShares, orderPrice, orderStatus, orderDirection, buyMain, headers } from './sellOrders.module.css'
import { SellService } from '../../services';


const SellOrders = ({ orderBook }) => {

  const [orderList, setOrderList] = useState([])

  useEffect(() => {
    async function getOrders() {
      setOrderList(await SellService.getOrders(orderBook))
    }

    getOrders();
  }, [])

  const renderOrders = () => {
    let rendering = [];

    orderList.forEach((order) => {
      rendering.push(
        <li>
          <div className={eachSellOrder}>
            <div className={orderDirection} style={{ color: "#FF0000" }}><strong>SELL</strong></div>
            <div className={orderStock}>{order.orderBook.companyName}</div>
            <div className={orderShares}>{order.available}</div>
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
        <div className={eachSellOrder} style={{ borderWidth: 0, marginBottom: 20, fontStyle: "italic" }}>
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
export default SellOrders;
