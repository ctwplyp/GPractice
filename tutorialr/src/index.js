import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';

class EssayForm extends React.Component {
	constructor(props) {
		super(props);
		this.state = {
			value: 'Please write an essay about your favorite Dom element.'};

		this.handleChange = this.handleChange.bind(this);
		this.handleSubmit = this.handleSubmit.bind(this);
		
	}

	handleChange(event) {
		//only uppercase letters allowed
		this.setState({value: event.target.value.toUpperCase()});
	}

	handleSubmit(event) {
		alert('A name was submitted: ' + this.state.value);
		event.preventDefault();
	}

	render() {
		return (
			<form onSubmit={this.handleSubmit}>
				<label>
					Essay:
					<textarea value={this.state.value} onChange={this.handleChange} />
				</label>
				<input type="submit" value="Submit" />
				</form>
			);
	}

}


ReactDOM.render(
  <EssayForm />,
  document.getElementById('root')
);
