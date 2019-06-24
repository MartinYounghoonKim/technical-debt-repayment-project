import React, { Component } from 'react';
import './App.css';
import ProfileWrapper from "./ProfileWrapper";
import ProfileProviderWrapper from "./provider/ProfileProvider";
import ProfileDetails from "./ProfileDetails";
import BoardProviderWrapper from "./provider/BoardProvider";
import BoardDetails from "./BoardDetails";

class App extends Component {
  render() {
    return (
      <div className="App">
        <ProfileProviderWrapper>
          <BoardProviderWrapper>
            <ProfileWrapper />
            <BoardDetails/>
          </BoardProviderWrapper>
        </ProfileProviderWrapper>
        <ProfileDetails />
      </div>
    );
  }
}

export default App;
