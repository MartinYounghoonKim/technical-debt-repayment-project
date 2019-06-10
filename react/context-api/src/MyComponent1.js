import React, { Component } from 'react';

class MyComponent1 extends Component {
  state = {
    value: 0,
  };

  render () {
    return (
        <div>
          <p>{this.props.value}</p>
          <p>{this.state.value}</p>
        </div>
    )
  }
}

export default MyComponent1;