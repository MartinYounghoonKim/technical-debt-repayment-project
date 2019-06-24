import React from "react";
import { ProfileConsumer } from "./context/ProfileContext";

const ProfileDetails = () => (
  <div>
    <ProfileConsumer>
      {({ name, age }) => (
        <div>
          <div>
            <strong>My name is :</strong> {name}
          </div>
          <div>
            <strong>My age is :</strong> {age}
          </div>
        </div>
      )}
    </ProfileConsumer>
  </div>
);

export default ProfileDetails;
