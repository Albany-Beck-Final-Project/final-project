import React, { useState, useEffect } from "react";

import "../styles/global.css";

import Nav from '../components/Nav';
import { SellService, BuyService, OrderService } from '../services';
import { main, photoDiv, about, portfolio, orders, orderId, orderDate, orderStock, orderShares, orderPrice, orderStatus,
  orderDirection } from '../styles/index.module.css';

import { eachOrderMain, orderTitle, eachStockMain, stockName, stockShares, stockPrice, stockTitle } from '../styles/order.module.css'



export default function Home() {
  if (window.localStorage.StockPlatform) {
    // USESTATE
  }
  const [orderList, setOrderList] = useState([]);

  useEffect(() => {
      (async function getUserOrders() {
        const ordered = await OrderService.getAllUserOrders();
        setOrderList(ordered)

      })();

  }, [])



  const renderOrders = () => {
    let jsx = [];
    if (orderList.length === 0) {
      return null;
    }
    orderList.forEach(order => {
      jsx.push(
        <li>
          <div className={eachOrderMain}>
              <div className={orderDate}>{order.timeOfPurchase.toUpperCase()}</div>
              <div className={orderStock}>{order.stockName}</div>
              <div className={orderShares}>{order.shares}</div>
              <div className={orderPrice}>£{order.price.toLocaleString(undefined, {minimumFractionDigits: 2, maximumFractionDigits: 2})}</div>
              <div className={orderStatus}>{order.orderStatus}</div>
              <div className={orderDirection}>{order.orderDirection}</div>
          </div>
        </li>
      )
    })
    return jsx;
  }

  const whiteSpaceForId = (orderId) => {
    console.log(4 - orderId.toString().length)
    return "\u00A0".repeat(4 - orderId.toString().length)
  }

  const getOrders = () => {
    let jsx = [];
    jsx.push(renderOrders(orderList))
    return jsx;
  }

  const renderPortfolio = () => {
    return (
      <li>
        <div className={eachStockMain}>
          <div className={stockName}>AAPL</div>
          <div className={stockShares}>500</div>
          <div className={stockPrice}>$148.10</div>
        </div>
      </li>
    )
  }

  if (window.localStorage.StockPlatform !== undefined) {

    return (
      <div>
        <Nav path="/"/>

        <div className={main}>
          <div className={portfolio}>
            <h2>Your Portfolio</h2>
            <ul>
              <li>
                <div className={stockTitle}>
                    <div className={stockName}><u>Stock</u></div>
                    <div className={stockShares}><u>No.Shares</u></div>
                    <div className={stockPrice}><u>Price</u></div>
                </div>
              </li>
              { renderPortfolio() }
            </ul>
          </div>
          <div className={orders}>
            <h2>Your Orders</h2>
            <ul>
              <li>
                <div className={orderTitle}>
                  <div className={orderDate}><u>Date</u></div>
                  <div className={orderStock}><u>Stock</u></div>
                  <div className={orderShares}><u>Shares</u></div>
                  <div className={orderPrice}><u>Price</u></div>
                  <div className={orderStatus}><u>Status</u></div>
                  <div className={orderDirection}><u>Direction</u></div>
                </div>
              </li>
              <li>
              </li>
              { renderOrders() }
            </ul>
          </div>
        </div>
      </div>
    )
  } else {
    return (
      <div>
        <Nav path="/" />

        <div className={main}>
          <div className={photoDiv}></div>
          <hr />

          <div className={about}>
            <h1>Stock Platform</h1>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas rhoncus dignissim nisi vitae molestie. Proin interdum feugiat quam, non rutrum diam eleifend non. Cras consequat nunc nec erat pellentesque hendrerit. Donec ultrices urna est, eu tristique sapien pulvinar a. Sed tortor nibh, porta eget tellus quis, facilisis vulputate metus. Praesent ornare vel urna at facilisis. Cras eu eros nec ligula vulputate mollis nec at velit. Phasellus semper odio sit amet dolor blandit,    sed consequat urna gravida. Proin aliquam nisi lobortis mauris sagittis commodo. Quisque ac dolor vitae lectus pharetra posuere id vitae ex. Nulla non lacus porta augue ullamcorper efficitur. Ut accumsan eros nec metus consectetur aliquet. Nulla facilisi. Quisque egestas interdum est, non ullamcorper mi luctus at. Donec et turpis a nisl bibendum ultrices hendrerit sed nibh.
            <br />
            <br />
            Integer venenatis lectus ut porta eleifend. Maecenas aliquet dolor ante. Duis quam libero, facilisis eget volutpat sit amet, tempus quis nisl. Pellentesque aliquam semper pellentesque. Suspendisse ut turpis rhoncus purus dignissim mollis ac quis sem. Donec condimentum lacus et orci mattis tincidunt. Curabitur ut auctor enim.</p>
          </div>
        </div>
      </div>
    )
  }
}
