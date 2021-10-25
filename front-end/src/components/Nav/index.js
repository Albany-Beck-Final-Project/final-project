import React from 'react';
import { Link } from 'gatsby';

import { navDiv, nav, noUserOptions, logInLink, signUpLink } from './nav.module.css';

export default (props) => {

  const userOptionsRendering = () => {
    // log in AND sign up
    // log in
    // sign up
    // {account} AND log out
    if (props.path === "/" && !(window.localStorage.StockPlatform)) {
      // DISPLAY log in AND log out
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
