import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';

// Correct! This is a component and should be capitalized:
function hello(props) {
  // Correct! This use of <div> is legitimate because div is a valid HTML tag:
  return <div>Hello {props.toWhat}</div>;
}

function HelloWorld() {
  return <hello toWhat="World" />;
}
 
ReactDOM.render(
  <HelloWorld/>,
  document.getElementById('root')
);