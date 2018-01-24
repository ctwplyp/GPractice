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
  if (action.type === "INC") {
    return state+action.payload;
  }
  if (action.type === "DEC") {
    return state-action.payload;
  }
  return state;
}

const store = createStore(reducer, 0);

store.subscribe(() => {
  console.log("store changed ", store.getState())
})

store.dispatch({type: "INC", payload:1})
store.dispatch({type: "INC", payload:3})
store.dispatch({type: "INC", payload:5})
store.dispatch({type: "INC", payload:78})
store.dispatch({type: "DEC", payload:1000})


ReactDOM.render(
  <HelloMessage name="Taylor" />,
  document.getElementById('root')
);
