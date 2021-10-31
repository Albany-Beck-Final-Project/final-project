import React, { useState } from 'react';
import axios from 'axios';
import { navigate } from 'gatsby';

import { formDiv, formTitle, form, input, submit, errorMessage } from './userForm.module.css';

export default (props) => {

  const REGEX = /./ig;
  const API_URL = "http://localhost:8080"
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");

  const formatBodyToJSON = () => {
    return JSON.stringify({
      firstName: window.btoa(firstName),
      lastName: window.btoa(lastName),
      email: window.btoa(email),
      password: window.btoa(password),
      confirmPassword: window.btoa(confirmPassword)
    })
  }

  const logIn = () => {
    fetch(`${API_URL}/users`, {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*'
      },
      body: formatBodyToJSON()
    })
    .then(response => response.json())
    .then(data => {
      if (data.status === "successful") {
        // window.localStorage.StockPlatform = {
          // session: data.session
        // }
        window.localStorage.setItem("StockPlatform", data.session)
        navigate("/")
      }
    })
  }

  const signUp = () => {
    fetch(`${API_URL}/users/new`, {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*'
      },
      body: formatBodyToJSON()
    })
    .then(response => response.json())
    .then(data => {
      if (data.status === "Successfully Registered!") {
        // setTimeout(() => {
          navigate("/login");
        // }, 1000)
      } else {
        document.getElementById("signUpError").innerHTML = data.status;
        window.scrollTo(0,0);
      }
    })
  }

  const generateOptions = (urlPath) => {
    return {
      url: `${API_URL}${urlPath}`,
          method: 'POST',
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json;charset=UTF-8'
          },
          data: formatBodyToJSON()
        }
    }

    const isFormButtonDisabled = (formType) => {
      if (formType === 'signup') {
        if (firstName.length > 0 && lastName.length > 0 && email.length > 0 && password.length > 0 && confirmPassword.length > 0) {
          return false
        } else {
          return true
        }
      } else {
        if (email.length > 0 && password.length > 0) {
          return false
        } else {
          console.log("right place!")
          return true
        }
      }
    }

  if (props.form === "SIGNUP") {

    return (
      <div className={formDiv}>
        <h2 className={formTitle}>Sign Up</h2>
        <div className={errorMessage} id="signUpError"></div>
          <input
            type="text" name="firstName" className={input}
            onChange={(e) => { setFirstName(e.target.value) }}
            value={firstName}
            placeholder="First Name"
          />
          <input
            type="text" name="lastName" className={input}
            onChange={(e) => { setLastName(e.target.value) }}
            value={lastName}
            placeholder="Last Name"
          />
          <input
            type="email" name="email" className={input}
            onChange={(e) => { setEmail(e.target.value) }}
            value={email}
            placeholder="Email"
          />
          <input
            type="password" name="password" className={input}
            onPaste={(e) => { e.preventDefault() }}
            onChange={(e) => { setPassword(e.target.value) }}
            value={password.replaceAll(REGEX, "*")}
            placeholder="Password"
          />
          <input
            type="password" name="confirmPassword" className={input}
            onPaste={(e) => { e.preventDefault() }}
            onChange={(e) => { setConfirmPassword(e.target.value) }}
            value={confirmPassword.replaceAll(REGEX, "*")}
            placeholder="Confirm Password"
          />

          <button className={submit} onClick={(e) => { e.preventDefault(); signUp(); }} disabled={isFormButtonDisabled("signup")}>Sign Up</button>
      </div>
    )
  } else {
    return (
      <div className={formDiv}>
        <h2 className={formTitle}>Log In</h2>
        {/*<form className={form}>*/}
        <input
          type="email" name="email" className={input}
          onChange={(e) => { setEmail(e.target.value) }}
          value={email}
          placeholder="Email"
        />
        <input
          type="password" name="password" className={input}
          onPaste={(e) => { e.preventDefault() }}
          onChange={(e) => { setPassword(e.target.value) }}
          value={password.replaceAll(REGEX, "*")}
          placeholder="Password"
        />

          {/*<input type="submit" className={submit} onSubmit={(e) => { e.preventDefault(); logIn(); navigate("/") }} value="Log In" />
        </form>*/}
        <button className={submit} onClick={(e) => { e.preventDefault(); logIn(); }} disabled={isFormButtonDisabled("login")}>Log In</button>
      </div>
    )
  }
}
