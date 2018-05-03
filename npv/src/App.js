import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import ReactTable from 'react-table'
import CashFlowTable from './components/CashFlowTable'
import PVTable from './components/PVTable'
import Table from './components/Table'
import ReactDataSheet from 'react-datasheet'
import { AgGridReact } from 'ag-grid-react';
import 'ag-grid/dist/styles/ag-grid.css';
import 'ag-grid/dist/styles/ag-theme-balham.css';
  
class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      grid: [
        [{value: '1/1/2019' }, {value:  0}],
        [{value: '1/1/2020' }, {value:  0}],
        [{value: '1/1/2021' }, {value:  0}],
        [{value: '1/1/2022' }, {value:  0}],
        [{value: '1/1/2023' }, {value:  0}]
      ],
      grid2: [
      ],
      columnDefs: [
        {headerName: "Make", field: "make"},
        {headerName: "Model", field: "model"},
        {headerName: "Price", field: "price"}

    ],
    rowData: [
        {make: "Toyota", model: "Celica", price: 35000},
        {make: "Ford", model: "Mondeo", price: 32000},
        {make: "Porsche", model: "Boxter", price: 72000}
    ],
      Date: 1/1/2018,
      percent: .04,
    }
  }

  handleSubmit= () => {   
  }

  handleClick= () => {
    
  }
//this.state.grid.concat([{value: '1/1/2024'}, {value:9999}])
  changeGridData = (data) => {
    let newGrid = data;
    for (let i=0;i<newGrid.length;i++){
       newGrid[i]= newGrid[i] * this.state.percent;
     }
    this.setState({grid2: newGrid})
    this.setState({grid: data});
  }
 
  render() {
    console.log(this.state.percent, 'percent')
    return (
      <div className="App">
       <div 
                  className="ag-theme-balham"
                  style={{ 
	                height: '500px', 
	                width: '600px' }} 
		            >
                </div>
                <div className="ag-theme-balham"
                  style={{ 
	                height: '500px', 
	                width: '600px' }} 
		            ><AgGridReact
                        columnDefs={this.state.columnDefs}
                        rowData={this.state.rowData}>
                    </AgGridReact>
                    </div>
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
        <CashFlowTable data={this.state.grid} changeGridData={this.changeGridData}/>
          </div>
          <div>
        <p className="Table-header">Cash Flows With PV</p>
          <CashFlowTable data={this.state.grid2}/>
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
