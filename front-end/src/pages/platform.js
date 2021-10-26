import React from 'react';
import { Link, navigate } from 'gatsby';

import { platform, home, homeLink, exchange, exchangeOption, buyOptionButton, sellOptionButton, buyMain, sellMain, historyMain } from '../styles/platform.module.css';

import Orders from '../components/Orders';

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

          <button className={buyOptionButton}>BUY</button>
            { renderExchanges() }
          <button className={sellOptionButton}>SELL</button>

        </div>

        <Orders className={buyMain} direction="BUY" />

        <Orders className={sellMain} direction="SELL" />

      </div>
      <div className={historyMain}></div>
    </div>
  )
}

export default Platform;
