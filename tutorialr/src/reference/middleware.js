import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import {applyMiddleware, createStore } from "redux";

class HelloMessage extends React.Component {
  render() {
    return (
      <div>
        Hello {this.props.name}
      </div>
    );
  }
}

const reducer = (initialState=0, action) => {
  if (action.type === "INC") {
    return initialState +1;
  }
  if (action.type === "DEC") {
    return initialState -1;
  } if (action.type === "E"){
    throw new Error("AAAAAAAA!!!")
  }
  return initialState;

}

const logger = (store) => (next) => (action) => {
  console.log("action fired", action)
 // action.type ="DEC" //overwriting action
  next(action)
}

const error =(store) => (next) => (action) => {
  try {
    next(action)
  } catch(e) {
    console.log("ERRRRRRORRRRR!", e)
  }
}

const middleware = applyMiddleware(logger, error);

const store = createStore(reducer, 1, middleware);

store.subscribe(() => {
  console.log("store changed" , store.getState())
})


store.dispatch({type: "INC" })
store.dispatch({type: "INC" })
store.dispatch({type: "INC" })
store.dispatch({type: "INC" })
store.dispatch({type: "DEC" })
store.dispatch({type: "E" })


ReactDOM.render(
  <HelloMessage name="Taylor" />,
  document.getElementById('root')
);
