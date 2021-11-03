import React, { useState, useEffect, useContext } from 'react';

import { PlatformContext } from '../../contexts/PlatformContext.js';
import { eachBuyOrder, orderId, orderDate, orderStock, orderShares, orderPrice, orderStatus, orderDirection } from './orders.module.css'
import { SellService, BuyService, OrderService } from '../../services';


const Orders = ({ className, direction }) => {

  const { buyOrderList, setBuyOrderList, sellOrderList, setSellOrderList, currentBook } = useContext(PlatformContext);

  useEffect(() => {
    // let isMounted = true;
    async function setBooks() {
        if (direction === "BUY") {
           setBuyOrderList(await BuyService.getOrders(currentBook));
        } else {
          setSellOrderList(await SellService.getOrders(currentBook));
        }
    }
    // if(currentBook !== "") {
      setBooks()
    // }

    // return () => { isMounted = false };
  }, [currentBook])

  const renderOrders = () => {
    let rendering = [];
    const sortedOrders = OrderService.orderBuyOrSellOrders(direction === "BUY" ? [ buyOrderList, "DESC" ] : [ sellOrderList, "ASC" ]);
    sortedOrders.forEach((order) => {
      rendering.push(
        <li>
          <div className={eachBuyOrder}>
            <div className={orderDirection} style={{ color: direction === "BUY" ? "#18C412" : "#FF0000" }}><strong>{direction}</strong></div>
            <div className={orderStock}>{order.orderBook.companyName}</div>
            <div className={orderShares}>{order.shares}</div>
            <div className={orderPrice}>£{order.price.toLocaleString(undefined, {minimumFractionDigits: 2, maximumFractionDigits: 2})}</div>

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
