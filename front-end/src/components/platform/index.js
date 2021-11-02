import React, { useState, useEffect, useContext } from 'react';
import { Link, navigate } from 'gatsby';

import { PlatformContext } from '../../contexts/PlatformContext.js';
import { OrderBookService } from '../../services';

import { platform, home, homeLink, exchange, exchangeOption, bookOptionSelectDiv, buyOptionButton, sellOptionButton, buyMain, sellMain, historyMain } from './platform.module.css';

import Orders from '../Orders';

const PlatformComponent = () => {

  const { books, setBooks, currentBook, setCurrentBook } = useContext(PlatformContext);


  useEffect(async () => {
    const orderBooks = await OrderBookService.getAllBooks();
    setBooks(orderBooks);
    if (orderBooks.length > 0) {
      setCurrentBook(orderBooks[0].companyName);
    }
  }, [])



  const renderOrderBookOptions = () => {
    let jsx = [];
    books.forEach(book => {
      jsx.push(<option value={book.companyName}>{book.companyName}</option>)
    });


    return jsx;
  }

  return (
      <div className={platform}>
        <div className={home}>
          <Link to="/" className={homeLink}>Home</Link>
        </div>

        <div className={exchange}>
          <div className={exchangeOption}>

            <Link to="/platform/buy" state={{ currentBook: currentBook }} className={buyOptionButton}>BUY</Link>
            <div className={bookOptionSelectDiv}>
              <select onChange={(e) => { setCurrentBook(e.target.value) }} value={currentBook}>
                { renderOrderBookOptions() }
              </select>
            </div>
            <Link to="/platform/sell" state={{ currentBook: currentBook }} className={sellOptionButton}>SELL</Link>

          </div>

          <Orders className={buyMain} direction="BUY"/>

          <Orders className={sellMain} direction="SELL"/>

        </div>
        <div className={historyMain}></div>
      </div>
  )
}

export default PlatformComponent;
