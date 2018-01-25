import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import axios from "axios"
import thunk from "redux-thunk"
import {applyMiddleware, createStore} from "redux";
import logger from "redux-logger"


class HelloMessage extends React.Component {
  render() {
    return (
      <div>
        Hello {this.props.name}
      </div>
    );
  }
}
const initialState ={
  fetching: false,
  fetched: false,
  users: [],
  error: null,
}

const reducer = (state=initialState, action) => {
  switch (action.type){
    case "FETCH_USERS_START" :{
        break;
    }
    case "FETCH_USERS_ERROR" : {
        break;
    }
    case "RECEIVE_USERS" : {
      break
    }
    default :{
      break;
    }
  }
  return state
}

const middleware = applyMiddleware(thunk, logger);

const store = createStore(reducer, 1, middleware);


store.dispatch((dispatch) => {
  dispatch({type: "FETCH_USERS_START"})
  axios.get("http://rest.learncode.academy/api/wstern/users")
      .then((response) => {
        dispatch({type: "RECEIVE_USERS", payload: response.data})
      })
      .catch((err) => {
        dispatch({type:"FETCH_USERS_ERROR", payload: err})
      })
})


ReactDOM.render(
  <HelloMessage name="Taylor" />,
  document.getElementById('root')
);
