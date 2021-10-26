import React from 'react';
import { Link, navigate } from 'gatsby';

import { platform, home, homeLink, exchange, exchangeOption, buyOption, sellOption, buyMain, sellMain, historyMain } from '../styles/platform.module.css';

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

          <button className={buyOption}>BUY</button>
            { renderExchanges() }
          <button className={sellOption}>SELL</button>

        </div>

        <Orders className={buyMain} direction="BUY" />

        <Orders className={sellMain} direction="SELL" />

      </div>
      <div className={historyMain}></div>
    </div>
  )
}

export default Platform;
