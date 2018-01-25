import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import axios from "axios"
import thunk from "redux-thunk"
import {applyMiddleware, createStore} from "redux";
import logger from "redux-logger"
import promise from "redux-promise-middleware"
import {combineReducers } from "redux";


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



const tweetsReducer = (state={
  tweets: [],
  fetching: false,
  fetched: false,
  error: null,}, action) => {
  switch (action.type){
    case "FETCH_TWEETS": {
      return {...state, fetching:true}
        break;
    }
    case "FETCH_TWEETS_REJECTED" : {
      return {...state, fetching:false, error: action.payload}
        break;
    }
    case "FETCH_TWEETS__FULFILLED" : {
      return {...state,
              fetching: false,
              fetched: true,
              users: action.payload,
            }
      break
    }
    case "ADD_TWEET" : {
      return {...state,
              fetching: false,
              fetched: true,
              users: action.payload,
            }
      break
    }
    case "UPDATE_TWEET": {
      const {id, text } = action.payload
      const newTweets = [...state.tweets]
      const tweetToUpdate = newTweets.findIndex(tweet => tweet.id ===id)
      newTweets[tweetToUpdate] = action.payload
      return {
      ...state,
      tweets: newTweets,}
      
    }
    case "DELETE_TWEET": {
      return {
        ...state,
        tweets: state.tweets.filter(tweet => tweet.id !== action.payload),
      }
    }
  }
  return state
}


const userReducer = (state=initialState, action) => {
  switch (action.type){
    case "FETCH_USERS_PENDING": {
      return {...state, fetching:true}
        break;
    }
    case "FETCH_USERS_REJECTED" : {
      return {...state, fetching:false, error: action.payload}
        break;
    }
    case "FETCH_USERS__FULFILLED" : {
      return {...state,
              fetching: false,
              fetched: true,
              users: action.payload,
            }
      break
    }
    default :{
      break;
    }
  }
  return state
}

const reducers = combineReducers({
  user: userReducer,
  tweets: tweetsReducer,
})

const middleware = applyMiddleware(promise(), thunk, logger);

const store = createStore(reducers, 1, middleware);

store.dispatch({
  type:"FETCH_USERS",
  payload: axios.get("http://rest.learncode.academy/api/wstern/users")
})


ReactDOM.render(
  <HelloMessage name="Taylor" />,
  document.getElementById('root')
);
