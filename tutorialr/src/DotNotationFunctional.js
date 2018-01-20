import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';


const MyComponents = {
  Hello: function Hello(props) {
  return <div> {props.foo} </div>
  }
}

ReactDOM.render(
  <MyComponents.Hello foo={1+2+3+4} />,
  document.getElementById('root')
);
