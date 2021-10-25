import React from 'react';
import { Link } from 'gatsby';

import { navDiv, nav, homeDiv, homeLink, userOptions, logInLink, signUpLink, logOut, dropdown, accountOptions, dropdownMenu, menuItems, itemLinks, lastItem, active } from './nav.module.css';

export default (props) => {

  const userOptionsRendering = () => {
    if (props.path === "/" && !(window.localStorage.StockPlatform)) {
      return (
        <div className={userOptions}>
          <Link to="/signup" className={signUpLink}>Sign Up</Link>
          <Link to="/login" className={logInLink} >Log In</Link>
        </div>
      )
    } else if (props.path === "/signup") {
      return (
        <div className={userOptions}>
          <Link to="/login" className={logInLink} >Log In</Link>
        </div>
      )
    } else if (props.path === "/login") {
      return (
        <div className={userOptions}>
          <Link to="/signup" className={signUpLink}>Sign Up</Link>
        </div>
      )
    } else if (window.localStorage.StockPlatform) {
      return (
        <div className={userOptions}>
          <button className={logOut} onClick={() => { }}>Log Out</button>
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
          { userOptionsRendering() }

        </div>
    </div>
  )
}
