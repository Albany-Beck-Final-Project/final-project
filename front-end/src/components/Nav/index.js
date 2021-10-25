import React from 'react';
import { Link } from 'gatsby';

import { navDiv, nav, noUserOptions, logInLink, signUpLink, logOut, dropdown, accountOptions, dropdownMenu, menuItems, itemLinks, lastItem, active } from './nav.module.css';

export default (props) => {

  const userOptionsRendering = () => {
    if (props.path === "/" && !(window.localStorage.StockPlatform)) {
      return (
        <div className={noUserOptions}>
          <Link to="/signup" className={signUpLink}>Sign Up</Link>
          <Link to="/login" className={logInLink} >Log In</Link>
        </div>
      )
    } else if (props.path === "/signup") {
      return (
        <div className={noUserOptions}>
          <Link to="/login" className={logInLink} >Log In</Link>
        </div>
      )
    } else if (props.path === "/login") {
      return (
        <div className={noUserOptions}>
          <Link to="/signup" className={signUpLink}>Sign Up</Link>
        </div>
      )
    } else if (window.localStorage.StockPlatform) {
      return (
        <div className={noUserOptions}>
          <button className={logOut} onClick={() => { }}>Log Out</button>
          <div className={dropdown}>
            <button className={accountOptions} onClick={() => { console.log(document.getElementById('dropdownMenu')); document.getElementById('dropdownMenu').classList.toggle(active) }}>Account &#9660;</button>
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

  return (
    <div className={navDiv}>
      <div className={nav}>

          { userOptionsRendering() }

        </div>
    </div>
  )
}
