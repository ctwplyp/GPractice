import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import {createStore } from "redux";

class HelloMessage extends React.Component {
  render() {
    return (
      <div>
        Hello {this.props.name}
      </div>
    );
  }
}

const reducer = function (state, action) {
  return "foo";

}

const store = createStore(reducer, 0);

store.subscribe(() => {
  console.log("store changed ", store.getState())
})

store.dispatch({type: "INC", payload:1})

ReactDOM.render(
  <HelloMessage name="Taylor" />,
  document.getElementById('root')
);
