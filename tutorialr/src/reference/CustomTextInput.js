import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';

class CustomTextInput extends React.Component {
  constructor(props) {
    super(props)
      this.focusTextInput = this.focusTextInput.bind(this)
  }
  focusTextInput() {
    this.textInput.focus()
  }

  render(){
    return (
      <div>
        <input type="text" ref ={(input) => {this.textInput = input}}/>
      <input
        type="button"
          value="focus the text Input"
          onClick={this.focusTextInput}
          />
          </div>
    )
  }
}

ReactDOM.render(
  <CustomTextInput />,
  document.getElementById('root')
);
