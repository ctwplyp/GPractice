import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import ReactTable from 'react-table'
import CashFlowTable from './components/CashFlowTable'
import PVTable from './components/PVTable'
import Table from './components/Table'
import { AgGridReact } from 'ag-grid-react';
import 'ag-grid/dist/styles/ag-grid.css';
import 'ag-grid/dist/styles/ag-theme-balham.css';
import outputJson from './output.json';
import Cell from './components/Cell'
import SpreadTable from './components/SpreadTable'
//import CashFlowTable from 'components/CashFlowTable_backup'
  
class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      grid: [{Date:1/1/2018, amount:5000}
      ],
      grid2: [
      ],
      Date: 1/1/2018,
      percent: .04,
      value: 20
    }
  }

  handleSubmit= () => {   
  }

  handleClick= () => {
    
  }
//this.state.grid.concat([{value: '1/1/2024'}, {value:9999}])
/*  changeGridData = (data) => {
    let newGrid = data;
    for (let i=0;i<newGrid.length;i++){
       newGrid[i]= newGrid[i] * this.state.percent;
     }
    this.setState({grid2: newGrid})
    this.setState({grid: data});
  }*/
  
 
  render() {
    console.log(this.state.percent, 'percent')
    return (
      <div className="App">
        <header className="App-header">
          <h1 className="App-NPV">NPV</h1>
        </header>
        <form onSubmit={this.handleSubmit} >
        <div>
        <label>
          Analysis Date:
        </label>
        </div>
        
        <div>
          <input type="Date" value={this.state.Date} />
        </div>

        <div>
        <label>
          Discount Rate:
        </label>
        </div>
        <div>
          <input type="Percent" value={this.state.Percent}/>
        </div>
        <div>
        <p className="Table-header">Cash Flows</p>
          <SpreadTable value/>
        {/* <CashFlowTable data={this.state.grid} changeGridData={this.changeGridData}/> */}
          </div>
          <div>
        <p className="Table-header">Cash Flows With PV</p>
          {/* <CashFlowTable data={this.state.grid2}/> */}
        </div>
        <input type="submit" value="Submit" />
        <div>
          <label>
            NPV: 
            </label>
            1,158.99
          </div>
      </form>
      </div>
    );
  }
}

export default App;
