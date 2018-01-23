import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';

function CustomTextInput(props) {
let textInput= null

function handleClick() {
  textInput.focus()
}
    return (
      <div>
        <input type="text" ref ={(input) => {textInput = input}}/>
      <input
        type="button"
          value="focus the text Input"
          onClick={handleClick}
          />
          </div>
    )
}

class AutoFocusTextInput extends React.Component {
  componentDidMount() {
    this.textInput.focusTextInput()
  }
  render() {
    return (
      <CustomTextInput
      ref={(input) => {this.textInput = input; }}/>
      )
  }
}
function MyFunctionalComponent() {
  return <input/>
}

class Parent extends React.Component {
  render() {
    return (
    <MyFunctionalComponent
      ref={(input) => {this.textInput = input; }} />
    )
  }
}

ReactDOM.render(
  <CustomTextInput />,
  document.getElementById('root')
);
