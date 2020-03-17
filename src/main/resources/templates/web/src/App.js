import React, { Component } from "react";
import "./App.css";

//import TableEnterprise from "./components/TableEnterprise";
//import Home from "./components/Home";
import AddEnterprise from "./components/AddEnterprise";

class App extends Component {
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <AddEnterprise />
        </header>
      </div>
    );
  }
}

export default App;
