import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';



function Repeat(props) {
  let items =[];
  for (let i =0; i<props.numTimes; i++) {
    items.push(props.children(i));
  }
  return <div>{items}</div>;
}

function ListOfTenThings() {
  var myVariable
  return (
    <Repeat numTimes={10}>
      {(index) => <div key={index}><div>
      </div>My JavaScript {index} variable is {String(myVariable)}</div>}
      </Repeat>
      )
}

ReactDOM.render(
  <ListOfTenThings />,
  document.getElementById('root')
);
