import React, { Component } from 'react';
import './App.css';
import ProfileWrapper from "./ProfileWrapper";
import {ProfilePrivider} from "./ProfileContext";

class App extends Component {
  state = {
    name: "Martin",
    age: "19"
  };

  render() {
    return (
      <div className="App">
        <ProfilePrivider value={this.state}>
          <ProfileWrapper />
        </ProfilePrivider>
      </div>
    );
  }
}

export default App;
