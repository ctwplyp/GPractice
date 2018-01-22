import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';


const Button = props => {
  const { kind, ...other } = props;
  const className = kind === "primary" ? "PrimaryButton" : "SecondaryButton"
  return <button className={className} {...other  } />
}

const App = () => {
  return  (
    <div>
      <Button kind="primary" onClick={() => console.log("clicked!")}>
        Hello World!
      </Button>
    </div>
  ) 
}

ReactDOM.render(
  <App kind="yello" args1="yellow" />,
  document.getElementById('root')
);
