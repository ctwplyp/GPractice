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

ReactDOM.render(
  <NumberDescriber number={1+2+3+4} />,
  document.getElementById('root')
);
