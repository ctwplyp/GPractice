import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';


function NumberDescriber(props) {
  let description;
  if (props.number % 2 == 0) {
    description =<strong>even</strong>
  }else {
    description = <i>odd</i>;
  }
  return <div>{props.number} is an {description} number </div>
}

function AddNumbers() {
  const props ={number1:{number1} , number2:{number2}}
  return <NumberAdder {...props} />;
}

function NumberAdder() {
  const answer = {number1}+{number2
  return <NumberDescriber answer />
}

ReactDOM.render(
  <NumberDescriber number1={1} number2={2}/>,
  document.getElementById('root')
);
