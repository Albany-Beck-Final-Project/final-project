const { hot } = require("react-hot-loader/root")

// prefer default export if available
const preferDefault = m => (m && m.default) || m


exports.components = {
  "component---cache-dev-404-page-js": hot(preferDefault(require("/Users/ben/Desktop/IT Portfolio/ALBANY BECK/FINAL PROJECT/front-end/.cache/dev-404-page.js"))),
  "component---src-pages-index-js": hot(preferDefault(require("/Users/ben/Desktop/IT Portfolio/ALBANY BECK/FINAL PROJECT/front-end/src/pages/index.js"))),
  "component---src-pages-login-js": hot(preferDefault(require("/Users/ben/Desktop/IT Portfolio/ALBANY BECK/FINAL PROJECT/front-end/src/pages/login.js"))),
  "component---src-pages-platform-js": hot(preferDefault(require("/Users/ben/Desktop/IT Portfolio/ALBANY BECK/FINAL PROJECT/front-end/src/pages/platform.js"))),
  "component---src-pages-signup-js": hot(preferDefault(require("/Users/ben/Desktop/IT Portfolio/ALBANY BECK/FINAL PROJECT/front-end/src/pages/signup.js")))
}

