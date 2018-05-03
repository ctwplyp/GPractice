import React, { Component } from 'react';
import {BootstrapTable, 
       TableHeaderColumn} from 'react-bootstrap-table';

 
class PVTable extends Component {
  render() {
    return (
      <div>
        <BootstrapTable data={this.props.data}>
          <TableHeaderColumn isKey dataField='id'>
            ID
          </TableHeaderColumn>
          <TableHeaderColumn dataField='date'>
            Date
          </TableHeaderColumn>
          <TableHeaderColumn dataField='value'>
            CashFlow
          </TableHeaderColumn>
          <TableHeaderColumn dataField='pv'>
            PV
          </TableHeaderColumn>
        </BootstrapTable>
      </div>
    );
  }
}
 
export default PVTable;