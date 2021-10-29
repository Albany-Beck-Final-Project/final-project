import React, { useState } from 'react';
import axios from 'axios';
import { navigate } from 'gatsby';

import { formDiv, formTitle, form, input, submit } from './userForm.module.css';

export default (props) => {

  const REGEX = /./ig;
  const API_URL = "https://localhost:8080"
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");

  // const signUp = (e) => {
  //   e.preventDefault();
    // const body = formatBodyToJSON()
  //   const options = {
  //     url: `${API_URL}/register`,
  //     method: 'POST',
  //     headers: {
  //       'Accept': 'application/json',
  //       'Content-Type': 'application/json;charset=UTF-8'
  //     },
  //     data: formatBodyToJSON()
  //   };
  //   axios(options).then(response => { console.log(response) })
  // }
  //
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
    const options = generateOptions("/users");
    // axios.post(`${API_URL}/users`, formatBodyToJSON())
    // .then(response => { console.log(response) })
    fetch(`${API_URL}/users`, {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json;charset=UTF-8'
      },
      data: formatBodyToJSON()
    })
    .then(data => console.log(data))
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

  if (props.form === "SIGNUP") {

    return (
      <div className={formDiv}>
      <h2 className={formTitle}>Sign Up</h2>
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
            type="text" name="email" className={input}
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

          <input type="submit" className={submit} onSubmit={(e) => { e.preventDefault(); }} value="Sign Up" />
      </div>
    )
  } else {
    return (
      <div className={formDiv}>
        <h2 className={formTitle}>Log In</h2>
        {/*<form className={form}>*/}
        <input
          type="text" name="username" className={input}
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
        <button className={submit} onClick={(e) => { e.preventDefault(); logIn(); navigate("/") }}>Log In</button>
      </div>
    )
  }
}
