import React from "react";
import { ProfileProvider } from "./ProfileContext";

class ProfileProviderWrapper extends React.Component {
  state = {
    name: "Martin",
    age: "19"
  };

  render () {
    return (
      <ProfileProvider value={this.state}>
        {this.props.children || null}
      </ProfileProvider>
    )
  }
}

export default ProfileProviderWrapper;
