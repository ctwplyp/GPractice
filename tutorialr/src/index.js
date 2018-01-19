import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import {hello} from './stories';

// Correct! This is a component and should be capitalized:
const components = {
  HelloMessage: hello
}

ReactDOM.render(
  <HelloMessage name="Taylor" />,
  document.getElementById('root')
);
