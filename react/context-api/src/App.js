import React, { Component } from 'react';
import './App.css';
import ProfileWrapper from "./ProfileWrapper";
import ProfileProviderWrapper from "./ProfileProvider";
import ProfileDetails from "./ProfileDetails";

class App extends Component {
  render() {
    return (
      <div className="App">
        <ProfileProviderWrapper>
          <ProfileWrapper />
        </ProfileProviderWrapper>
        <ProfileDetails />
      </div>
    );
  }
}

export default App;
