import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import PropTypes from 'prop-types'



class GreetingWithDefault extends React.Component {
static defaultProps={
  name: 'Stranger1'
  }
  render() {
      return (
        <h1>Hello, {this.props.name}</h1>
    )
  }
}

class GreetingWithoutDefault extends React.Component {

  render() {
      return (
        <h1>Hello, {this.props.name}</h1>
    )
  }
}

GreetingWithoutDefault.propTypes = {
    name:PropTypes.string
}

GreetingWithDefault.propTypes = {
    name:PropTypes.string
}

class MyComponent extends React.Component {
  render() {
      const children = this.props.children
      return (
        <div>
        {children}
          </div>
        )
  }
}
MyComponent.propTypes = {
  children: PropTypes.element.isRequired
}



ReactDOM.render(
  <GreetingWithoutDefault />,
  document.getElementById('root')
);
