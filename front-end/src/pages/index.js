import React from "react";

import "../styles/global.css";

import Nav from '../components/Nav';
import { main, photoDiv, about, portfolio, orders } from '../styles/index.module.css';

import { eachOrderMain, orderTitle, eachStockMain, orderId, orderDate, orderStock, orderShares, orderPrice, orderStatus,
  orderDirection, stockName, stockShares, stockPrice, stockTitle } from '../styles/order.module.css'



export default function Home() {
  if (window.localStorage.StockPlatform) {
    // USESTATE
  }


  const renderOrders = () => {
    // ITERATE
    return (
      <li>
        <div className={eachOrderMain}>
            <div className={orderId}>1014</div>
            <div className={orderDate}>24 OCT 2021</div>
            <div className={orderStock}>AAPL</div>
            <div className={orderShares}>4</div>
            <div className={orderPrice}>£592.48</div>
            <div className={orderStatus}>FILLED</div>
            <div className={orderDirection}>SELL</div>
        </div>
      </li>
    )
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

  if (window.localStorage.StockPlatform) {
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
                  <div className={orderId}><u>Id</u></div>
                  <div className={orderDate}><u>Date</u></div>
                  <div className={orderStock}><u>Stock</u></div>
                  <div className={orderShares}><u>Shares</u></div>
                  <div className={orderPrice}><u>Price</u></div>
                  <div className={orderStatus}><u>Status</u></div>
                  <div className={orderDirection}><u>Direction</u></div>
                </div>
              </li>
              <li>
                <div className={eachOrderMain}>
                    <div className={orderId}>1013</div>
                    <div className={orderDate}>14 OCT 2021</div>
                    <div className={orderStock}>AAPL</div>
                    <div className={orderShares}>4</div>
                    <div className={orderPrice}>£592.48</div>
                    <div className={orderStatus}>FILLED</div>
                    <div className={orderDirection}>BUY</div>
                </div>
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
