import React from 'react';
import { navigate } from 'gatsby';

import UserForm from '../components/UserForm';
import Nav from "../components/Nav"
import { signUp, main } from '../styles/signup.module.css';


const Signup = () => {

  return (
    <div className={signUp}>

      <Nav path="/signup"/>

      <div className={main}>

        <UserForm form="SIGNUP" />

      </div>

    </div>
  )
}

export default Signup;
