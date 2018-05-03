import React, { Component } from 'react';
import {BootstrapTable, 
       TableHeaderColumn} from 'react-bootstrap-table';
import ReactDataSheet from 'react-datasheet'


 
class CashFlowTable extends Component {
  /*constructor(props) {
    super(props);
    this.state = {
      grid: [
        [{value: '1/1/2019' }, {value:  -5000}],
        [{value: '1/1/2020' }, {value:  1000}],
        [{value: '1/1/2021' }, {value:  1000}],
        [{value: '1/1/2022' }, {value:  1000}],
        [{value: '1/1/2023' }, {value:  4000}]
      ]
    }
  }*/
  render() {
    return (
      <div>
        <div>
        Cash Flows
        </div>
        <ReactDataSheet
        data={this.props.data}
        valueRenderer={(cell) => cell.value}
        onCellsChanged={changes => {
          const grid = this.props.data.map(row => [...row])
          changes.forEach(({cell, row, col, value}) => {
            grid[row][col] = {...grid[row][col], value}
          })
          this.props.changeGridData(grid)
        }}
      />
      </div>
    );
  }
}
 
export default CashFlowTable;