import React from 'react';
import { navigate } from 'gatsby';

import PlatformContextProvider from '../contexts/PlatformContext.js';
import PlatformComponent from '../components/Platform';



const Platform = () => {
  if(window.localStorage.StockPlatform === undefined) {
    navigate("/login");
  }


  return (
    <PlatformContextProvider>
      <PlatformComponent />
    </PlatformContextProvider>
  )
}

export default Platform;
