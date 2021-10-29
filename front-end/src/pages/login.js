import React from 'react';
import { navigate } from 'gatsby';

import UserForm from '../components/UserForm';
import Nav from "../components/Nav"
import { logIn, main } from '../styles/login.module.css';


const Login = () => {
  if (window.localStorage.StockPlatform) {
    navigate("/");
  }


  return (
    <div className={logIn}>

      <Nav path="/login"/>

      <div className={main}>

        <UserForm form="LOGIN" />

      </div>

    </div>
  )
}

export default Login;
