import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import {createStore, combineReducers } from "redux";

class HelloMessage extends React.Component {
  render() {
    return (
      <div>
        Hello {this.props.name}
      </div>
    );
  }
}



const userReducer = (state={}, action ) => {
  switch(action.type) {
    case "CHANGE_NAME": {
      state.name = {...state, name:action.payload}
      break
    }
    case "CHANGE_AGE": {
      state.age = {...state, age:action.payload}
      break
    } 
  }
  return state;
}
const defaults ={}

const tweetsReducer = (state=[], action ) => {
  switch(action.type) {
    case "CHANGE_TWEET" : {
      state.message = {...state, message:action.payload }
      break
    }
  }
  return state;
}

const reducers = combineReducers({
  user: userReducer,
  tweets: tweetsReducer,
})

const store = createStore(reducers);

store.subscribe(() => {
  console.log("store changed ", store.getState())
})

store.dispatch({type: "CHANGE_NAME", payload:"Will"})
store.dispatch({type: "CHANGE_AGE", payload:"37"})
store.dispatch({type: "CHANGE_AGE", payload:"35"})
store.dispatch({type: "CHANGE_TWEET", payload:"Will's age changed"})
store.dispatch({type: "CHANGE_TWEET", payload:"Will is young!"})


ReactDOM.render(
  <HelloMessage name="Taylor" />,
  document.getElementById('root')
);
