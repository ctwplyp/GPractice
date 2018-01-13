import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
const element = <WelcomeFunc name="SaraFunc" />;

function WelcomeFunc(props) {
		return <h1>Hello, {props.name} </h1>;
};

//class WelcomeComp extends React.Component {
//	render() {
//		return <h1>Hello, {this.props.name} </h1>;
//	}
//};

//const element1 =  <WelcomeComp name="SaraComp" />;

ReactDOM.render(
    element,
    document.getElementById('root')
);
