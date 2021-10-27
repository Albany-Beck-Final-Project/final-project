import React, { useState } from 'react';

import { formDiv, formTitle, form, input, submit } from './userForm.module.css';

export default (props) => {

  const REGEX = /./ig;
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");

  const signUp = (e) => {
    e.preventDefault();
    // const body = formatBodyToJSON()
    const options = {
      url: `${API_URL}/register`,
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json;charset=UTF-8'
      },
      data: formatBodyToJSON()
    };
    axios(options).then(response => { console.log(response) })
  }

  const formatBodyToJSON = () => {
    const body = {
      firstName: firstName,
      lastName: lastName,
      email: email,
      password: password,
      confirmPassword: confirmPassword
    }
    return JSON.stringify(body)
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

          <input type="submit" className={submit} onSubmit={(e) => { signUp(e) }} value="Sign Up" />
      </div>
    )
  } else {
    return (
      <div className={formDiv}>
        <h2 className={formTitle}>Log In</h2>
        <form className={form}>
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

          <input type="submit" className={submit} onSubmit={() => {  }} value="Log In" />
        </form>
      </div>
    )
  }
}
