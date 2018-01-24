import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';

class NameForm extends React.Component {
  constructor(props) {
    super(props)
    this.handleSubmit +this.handleSubmit.bind(this)
  }

  handleSubmit(event) {
    alert('A name was submitted ' + this.input.value);
    event.preventDefault()
  }

  render() {
    return (
        <form  onSubmit={this.handleSubmit}>
          <label>
            Name:
              <input defaultValue="bob" type ="text" ref ={(input) => this.input = input} />
          </label>
          <input type="submit" value="Submit" />
        </form>
        );
      }
    }


ReactDOM.render(
  <NameForm />,
  document.getElementById('root')
);
