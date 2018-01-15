import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';

const numbers = [1, 2, 3, 4, 5];
//const doubledPlus1 = numbers.map((number) => number * 2+1);
//const doubledItems = doubledPlus1.map((doubled) =>
 // <li>{doubled}</li>
//);

function ListItem(props) {
	return<li>{props.value}</li>;
}

function NumberList(props) {
  const numbers = props.numbers;
  return (
  	<ul>
  		{ numbers.map((number) =>
    		<ListItem key={number.toString()}
    			value = {number + 4} />
	)}
	</ul>
  );
}


ReactDOM.render(
  <NumberList numbers={numbers} />,
  document.getElementById('root')
);
