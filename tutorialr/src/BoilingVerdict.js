import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';

function BoilingVerdict(props) {
  if (props.celsius >= 100) {
    return <p>The water would boil.</p>;
  }
    return <p>The water would not boil</p>
}

ReactDOM.render(
  <BoilingVerdict props=100/>,
  document.getElementById('root')
);
