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
const showHeader =true;

function TwoNumber(props1){
const props = {number: props1.number2}
  return <div> 
          <NumberDescriber number={props1.number1} />
          <div>{showHeader && <Header messages={"{props1.number1}"}/>}</div>
           <NumberDescriber number={props1.number2} />
           <NumberDescriber {...props} />
           <NumberDescriber></NumberDescriber>
           </div>
}

function Header(props){
  return <div>{props.messages && "true" 
              //  <MessageList messages={props.messages}/>
              }
         </div>
}


function Repeat(props) {
  let items =[];
  for (let i =0; i<props.numTimes; i++) {
    items.push(props.children(i));
  }
  return <div>{items}</div>;
}

function ListOfTenThings() {
  return (
    <Repeat numTimes={10}>
      {(index) => <div key={index}><div>{showHeader && <Header />}</div>This is item {index} in the list</div>}
      </Repeat>
      )
}

ReactDOM.render(
  <ListOfTenThings />,
  document.getElementById('root')
);
