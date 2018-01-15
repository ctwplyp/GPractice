import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';

function Greeting(props) {
  const isLoggedIn = props.isLoggedIn;
  if (isLoggedIn) {
    return <UserGreeting />;
  }
  return <GuestGreeting />;
}

function LoginButton(props) {
  return (
    <button onClick={props.onClick}>
      Login
    </button>
  );
}
function UserGreeting(props) {
  return <h1>Welcome back!</h1>;
}

function GuestGreeting(props) {
  return <h1>Please sign up.</h1>;
}


function LogoutButton(props) {
  return (
    <button onClick={props.onClick}>
      Logout
    </button>
  );
}

 class LoginControl extends React.Component {
  constructor(props) {
    super(props);
    this.handleLoginClick = this.handleLoginClick.bind(this);
    this.handleLogoutClick = this.handleLogoutClick.bind(this);
    this.state = {isLoggedIn: false};
  }

  handleLoginClick() {
    this.setState({isLoggedIn: true});
  }

  handleLogoutClick() {
    this.setState({isLoggedIn: false});
  }

  render() {
    const isLoggedIn = this.state.isLoggedIn;
 	return (	
      <div>
    {isLoggedIn ? (
      <LogoutButton onClick={this.handleLogoutClick} />
    ) : (
      <LoginButton onClick={this.handleLoginClick} />
    )}
    	The user is <b>{isLoggedIn ? "currently" : 'not'}</b> logged in.
    </div>
    );
}
}
	function Mailbox(props) {
		const unreadMessages = props.unreadMessages;
  			return (
    			<div>
      			<h1>Hello!</h1>
      			{unreadMessages.length > 0 &&
        		<h2>
          		You have {unreadMessages.length} unread messages.
        		</h2>
      			}
    		</div>
  		);
	}

	const messages= ['React', 'Re: React', 'Re:Re: React','Reactsdf'];
	ReactDOM.render(
    	<LoginControl />,
    	document.getElementById('root')
	);
