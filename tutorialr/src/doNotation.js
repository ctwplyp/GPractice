import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';

const MyComponents = {
    DatePicker: function DatePicker(props) {
      return <div> Imagine a {props.color} datepicker here.</div>
    }
}

function BlueDatePicker(){
  return <MyComponents.DatePicker color="blue" />;
}

function YellowDatePicker(){
  return <MyComponents.DatePicker color="yellow" />
}

function ColorDatePicker(props){
  return <MyComponents.DatePicker color={props.color}/>
}
 
ReactDOM.render(
  <ColorDatePicker color = "yellow"/>,
  document.getElementById('root')
);