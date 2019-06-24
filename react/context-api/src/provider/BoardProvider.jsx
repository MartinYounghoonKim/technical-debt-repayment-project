import React from "react";
import { BoardProvider } from "../context/BoardContext";

class BoardProviderWrapper extends React.Component {
  state = {
    index: "i",
    title: "Who are you ?",
    content: "This is Martin"
  };

  render () {
    return (
      <BoardProvider value={this.state}>
        {this.props.children || null}
      </BoardProvider>
    )
  }
}

export default BoardProviderWrapper;
