import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';

const numbers = [1, 2, 3, 4, 5];
const doubled = numbers.map((number) => number * 2);
const doubledItems = doubled.map((doubled) =>
  <li>{doubled}</li>
);



	ReactDOM.render(
    	<ul>{doubledItems}</ul>,
    	document.getElementById('root')
	);
