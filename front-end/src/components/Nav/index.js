import React from 'react';
import { Link, navigate } from 'gatsby';

import { navDiv, nav, homeDiv, homeLink, stockDiv, stockLink, userOptions, logInLink, signUpLink, logOut, dropdown, accountOptions, dropdownMenu, menuItems, itemLinks, lastItem, active } from './nav.module.css';

export default (props) => {

  const API_URL = "http://localhost:8080"

  const logOutHandler = () => {
    fetch(`${API_URL}/users`, {
      method: 'DELETE',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*'
      },
      body: JSON.stringify({
        "session": window.localStorage.StockPlatform
      })
    })
    .then(response => response.json())
    .then(data => {
      console.log(data.status)
      if (data.status === "successful") {
        window.localStorage.clear();
        navigate("/login");
      }
    })
  }

  const userOptionsRendering = () => {
    if (props.path === "/" && window.localStorage.StockPlatform === undefined) {
      return (
        <div className={userOptions}>
          <Link to="/signup" className={signUpLink}>Sign Up</Link>
          <Link to="/login" className={logInLink}>Log In</Link>
        </div>
      )
    } else if (props.path === "/signup") {
      return (
        <div className={userOptions}>
          <Link to="/login" className={logInLink}>Log In</Link>
        </div>
      )
    } else if (props.path === "/login") {
      return (
        <div className={userOptions}>
          <Link to="/signup" className={signUpLink}>Sign Up</Link>
        </div>
      )
    } else if (props.path === "/" && window.localStorage.StockPlatform !== undefined) {
      return (
        <div className={userOptions}>
          <button className={logOut} onClick={(e) => { e.preventDefault(); logOutHandler(); }}>Log Out</button>
          <div className={dropdown}>
            <button className={accountOptions} id="accountOptionButton" onClick={() => { handleDropdown() }}>Account &#9660;</button>
            <div className={dropdownMenu} id="dropdownMenu">
              <div className={menuItems}><Link to="" className={itemLinks}>Your Account</Link></div>
              <div className={menuItems}><Link to="" className={itemLinks}>Deposit</Link></div>
              <div className={menuItems} id={lastItem}><Link to="" className={itemLinks}>Withdraw</Link></div>
            </div>
          </div>
        </div>
      )
    }
  }

  const handleDropdown = () => {
    document.getElementById('dropdownMenu').classList.toggle(active);
    // If dropdown is toggled -> includes `active` as a class name
    if (document.getElementById('dropdownMenu').classList.value.includes(active)) {
      document.getElementById('accountOptionButton').innerHTML = "Account &#9650;"
    } else {
      document.getElementById('accountOptionButton').innerHTML = "Account &#9660;";
    }
  }

  return (
    <div className={navDiv}>
      <div className={nav}>
          <div className={homeDiv}>
            <Link to="/" className={homeLink}>Home</Link>
          </div>
          <div className={stockDiv}>
            <Link to={ window.localStorage.StockPlatform !== undefined ? "/platform" : "/login" } className={stockLink}>Stocks</Link>
          </div>
          { userOptionsRendering() }

        </div>
    </div>
  )
}
