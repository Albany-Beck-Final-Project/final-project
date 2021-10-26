import React from 'react';
import { Link, navigate } from 'gatsby';

import { platform, home, homeLink, exchange, exchangeOption, buyOption, sellOption, sellMain, historyMain } from '../styles/platform.module.css';

import BuyOrders from '../components/BuyOrders';
import SellOrders from '../components/SellOrders';

const Platform = () => {
  // if(!(window.localStorage.StockPlatform)) {
  //   navigate("/login");
  // }





  const renderExchanges = () => {
    return (null)
  }

  return (
    <div className={platform}>
      <div className={home}>
        <Link to="/" className={homeLink}>Home</Link>
      </div>

      <div className={exchange}>
        <div className={exchangeOption}>

          <button className={buyOption}>BUY</button>
            { renderExchanges() }
          <button className={sellOption}>SELL</button>

        </div>

        <BuyOrders />

        <SellOrders />

      </div>
      <div className={historyMain}></div>
    </div>
  )
}

export default Platform;
