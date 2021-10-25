import React from 'react';
import { navigate } from 'gatsby';

import UserForm from '../components/UserForm';


const Login = () => {
  if (window.localStorage.StockPlatform) {
    navigate("/");
  }


  return (
    <UserForm form="LOGIN" />
  )
}

export default Login;
