import React from "react";

import "../styles/global.css";

import Nav from '../components/Nav';
import { main, photoDiv, about } from '../styles/index.module.css';

export default function Home() {



  if (window.localStorage.StockPlatform) {
    return (
      <div>
        <Nav path="/"/>
      </div>
    )
  } else {
    return (
      <div>
        <Nav path="/" />

        <div className={main}>
          <div className={photoDiv}></div>

          <div className={about}>
            <h1>Stock Exchange</h1>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas rhoncus dignissim nisi vitae molestie. Proin interdum feugiat quam, non rutrum diam eleifend non. Cras consequat nunc nec erat pellentesque hendrerit. Donec ultrices urna est, eu tristique sapien pulvinar a. Sed tortor nibh, porta eget tellus quis, facilisis vulputate metus. Praesent ornare vel urna at facilisis. Cras eu eros nec ligula vulputate mollis nec at velit. Phasellus semper odio sit amet dolor blandit,    sed consequat urna gravida. Proin aliquam nisi lobortis mauris sagittis commodo. Quisque ac dolor vitae lectus pharetra posuere id vitae ex. Nulla non lacus porta augue ullamcorper efficitur. Ut accumsan eros nec metus consectetur aliquet. Nulla facilisi. Quisque egestas interdum est, non ullamcorper mi luctus at. Donec et turpis a nisl bibendum ultrices hendrerit sed nibh.
            <br />
            <br />
            Integer venenatis lectus ut porta eleifend. Maecenas aliquet dolor ante. Duis quam libero, facilisis eget volutpat sit amet, tempus quis nisl. Pellentesque aliquam semper pellentesque. Suspendisse ut turpis rhoncus purus dignissim mollis ac quis sem. Donec condimentum lacus et orci mattis tincidunt. Curabitur ut auctor enim.</p>
          </div>
        </div>
      </div>
    )
  }
}
