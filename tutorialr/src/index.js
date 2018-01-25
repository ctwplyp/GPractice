import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import axios from "axios"
import thunk from "redux-thunk"
import {applyMiddleware, createStore} from "redux";
import logger from "redux-logger"
import promise from "redux-promise-middleware"


class HelloMessage extends React.Component {
  render() {
    return (
      <div>
        Hello {this.props.name}
      </div>
    );
  }
}



ReactDOM.render(
  <HelloMessage name="Taylor" />,
  document.getElementById('root')
);
