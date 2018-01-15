import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';

class LoggingButton extends React.Component {
  // This syntax ensures `this` is bound within handleClick.
  // Warning: this is *experimental* syntax.
  handleClick() {
    console.log('this is:', this);
  }

  render() {
    return (
       <button onClick={this.handleClick.bind(this, "Goodbye")}>
        Click me Good bye
      </button>
    );
  }
}
	ReactDOM.render(
    	<LoggingButton />,
    	document.getElementById('root')
	);
