import React, { createContext, Component } from 'react';


export const PlatformContext = createContext();


class PlatformContextProvider extends Component {
  state = {
    buyOrderList: [],
    sellOrderList: [],
    books: [],
    currentBook: ""
  }

  setBuyOrderList = (newList) => {
    this.setState({ buyOrderList: [...newList] })
  }

  setSellOrderList = (newList) => {
    this.setState({ sellOrderList: [...newList] })
  }

  setBooks = (newList) => {
    this.setState({ books: [...newList] })
  }

  setCurrentBook = (newBook) => {
    this.setState({ currentBook: newBook })
  }

  render() {
    return (
      <PlatformContext.Provider value={{
        ...this.state,
        setBuyOrderList: this.setBuyOrderList,
        setSellOrderList: this.setSellOrderList,
        setBooks: this.setBooks,
        setCurrentBook: this.setCurrentBook
      }}>
      { this.props.children }
      </PlatformContext.Provider>
    )
  }
}

export default PlatformContextProvider;
