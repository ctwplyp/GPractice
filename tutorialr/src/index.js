import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import axios from "axios"
import thunk from "redux-thunk"
import {applyMiddleware, createStore} from "redux";
import logger from "redux-logger"
import promise from "redux-promise-middleware"
import todoApp from './reducers'
import {
  addTodo,
  toggleTodo,
  setVisibilityFilter,
  VisibilityFilters
} from './actions'



class HelloMessage extends React.Component {
  render() {
    return (
      <div>
        Hello {this.props.name}
      </div>
    );
  }
}
let store = createStore(todoApp)


// Log the initial state
console.log(store.getState())

// Every time the state changes, log it
// Note that subscribe() returns a function for unregistering the listener
const unsubscribe = store.subscribe(() =>
  console.log(store.getState())
)

// Dispatch some actions
store.dispatch(addTodo('Learn about actions'))
store.dispatch(addTodo('Learn about reducers'))
store.dispatch(addTodo('Learn about store'))
store.dispatch(toggleTodo(0))
store.dispatch(toggleTodo(1))
store.dispatch(setVisibilityFilter(VisibilityFilters.SHOW_COMPLETED))

// Stop listening to state updates
unsubscribe()


ReactDOM.render(
  <HelloMessage name="Taylor" />,
  document.getElementById('root')
);
