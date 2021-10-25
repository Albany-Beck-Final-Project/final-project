
// prefer default export if available
const preferDefault = m => (m && m.default) || m


exports.components = {
  "component---cache-dev-404-page-js": preferDefault(require("/Users/ben/Desktop/IT Portfolio/ALBANY BECK/front-end/.cache/dev-404-page.js")),
  "component---src-pages-account-js": preferDefault(require("/Users/ben/Desktop/IT Portfolio/ALBANY BECK/front-end/src/pages/account.js")),
  "component---src-pages-app-js": preferDefault(require("/Users/ben/Desktop/IT Portfolio/ALBANY BECK/front-end/src/pages/app.js")),
  "component---src-pages-index-js": preferDefault(require("/Users/ben/Desktop/IT Portfolio/ALBANY BECK/front-end/src/pages/index.js")),
  "component---src-pages-login-js": preferDefault(require("/Users/ben/Desktop/IT Portfolio/ALBANY BECK/front-end/src/pages/login.js")),
  "component---src-pages-signup-js": preferDefault(require("/Users/ben/Desktop/IT Portfolio/ALBANY BECK/front-end/src/pages/signup.js"))
}

