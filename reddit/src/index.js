import thunkMiddleware from 'redux-thunk'
import { createStore, combineReducers, applyMiddleware} from 'redux'
import { selectSubreddit, fetchPostsIfNeeded } from './actions'
import reducers from './reducers'
import Raven from 'raven-js'
//import crashReporter from 'redux-reporter'
import React from 'react'
import ReactDOM from 'react-dom'
import 'babel-polyfill'
import Root from './containers/Root'
import'./index.css'

ReactDOM.render(
    <Root />,
    document.getElementById('root')
)