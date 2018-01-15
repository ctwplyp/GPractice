import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';

const numbers = [1, 2, 3, 4, 5];
//const doubledPlus1 = numbers.map((number) => number * 2+1);
//const doubledItems = doubledPlus1.map((doubled) =>
 // <li>{doubled}</li>
//);
function NumberList(props) {
  const numbers = props.numbers;
  const listItems = numbers.map((number) =>
    <li key={number.toString()}>
    	{number}
    </li>
  );
  return (
    <ul>{listItems}</ul>
  );
}


ReactDOM.render(
  <NumberList numbers={numbers} />,
  document.getElementById('root')
);
