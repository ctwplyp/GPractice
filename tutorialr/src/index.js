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


function TwoNumber(props1){
const props = {number: props1.number2}
  return <div> 
          <NumberDescriber number={props1.number1} />
           <NumberDescriber number={props1.number2} />
           <NumberDescriber {...props} />
           </div>

}

ReactDOM.render(
  <TwoNumber number1={1} number2={2}/>,
  document.getElementById('root')
);
