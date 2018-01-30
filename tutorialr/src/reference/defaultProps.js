import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import PropTypes from 'prop-types'



class Greeting extends React.Component {
  render() {
      return (
        <h1>Hello, {this.props.name}</h1>
    )
  }
}

Greeting.propTypes = {
    name:PropTypes.string
}

class MyComponent extends React.Component {
  render() {
      const children = this.props.children
      return (
        <div>
          Greeting {children}
          </div>
        )
  }
}
MyComponent.propTypes = {
  children: PropTypes.element.isRequired
}

Greeting.defaultProps={
  name: 'Stranger'
}

ReactDOM.render(
  <Greeting />,
  document.getElementById('root')
);
