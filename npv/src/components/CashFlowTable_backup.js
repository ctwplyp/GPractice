import React, { Component } from 'react';
import {BootstrapTable, 
       TableHeaderColumn} from 'react-bootstrap-table';

 
class CashFlowTable extends Component {
  render() {
    var selectRowProp = {
      mode: "checkbox",
      clickToSelectAndEditCell: true,
    };
    var cellEditProp = {
      mode: "click",
      blurToSave: true
   };
    return (
      <div>
        <BootstrapTable data={this.props.data}
                        cellEdit={cellEditProp}>
          <TableHeaderColumn isKey dataField='id'>
            ID
          </TableHeaderColumn>
          <TableHeaderColumn dataField='date'>
            Date
          </TableHeaderColumn>
          <TableHeaderColumn dataField='value'>
            Value
          </TableHeaderColumn>
        </BootstrapTable>
      </div>
    );
  }
}
 
export default CashFlowTable;