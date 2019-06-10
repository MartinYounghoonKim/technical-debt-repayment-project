import React, { Component } from 'react';

class MyComponent extends Component {
  state = {
    value: 0,
    value1: 0,
  };

  static getDerivedStateFromProps (nextProps, prevState) {
    if (nextProps !== prevState) {
      return {
        value: nextProps.value
      }
      return null;
    }
  }
  shouldComponentUpdate (nextProps, nextState) {
    if (nextProps.value === 10) {
      return false;
    }
    return true;
  }
  componentWillUnmount () {
    console.log('Good bye')
  }
  render () {
    return (
        <div>
          <p>{this.props.value}</p>
          <p>{this.state.value}</p>
          <p>{this.props.name}</p>
          <p>{this.state.name}</p>
        </div>
    )
  }
}

export default MyComponent;