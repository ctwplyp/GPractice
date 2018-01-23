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

function Repeat(props) {
  let items =[];
  for (let i =0; i<props.numTimes; i++) {
    items.push(<NumberDescriber number={i} />);
  }
  return <div>{items}</div>;
}

function ListOfTenThings() {
  return (
    <Repeat numTimes={10}>
      {(index) => <div key={index}>This is item {index} in the list</div>}
      </Repeat>
      )
}

ReactDOM.render(
  <ListOfTenThings />,
  document.getElementById('root')
);
