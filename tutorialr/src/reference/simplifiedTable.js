import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';


class ProductRow extends React.Component {
  render() {
    const product = this.props.product;
    const name = 
      <span>
        {product.name}
      </span>;

    return (
      <tr>
        <td>{name}</td>
        <td>{product.price}</td>
        <td>{product.stocked}</td>
        <td>{product.category}</td>
      </tr>
    );
  }
}
class ProductTable extends React.Component {
  render() {
    const rows = [];
    
    this.props.products.forEach((product) => {
      rows.push(
        <ProductRow
          product={product}
          key={product.name} />
      );
    });

    return (
      <table>
        <thead>
          <tr>
            <th>Name</th>
            <th>Price</th>
            <th>Stocked</th>
            <th>Category</th>
          </tr>
        </thead>
        <tbody>{rows}</tbody>
      </table>
    );
  }
}

const PRODUCTS = [
  {category: 'Sporting Goods', price: '$49.99', stocked: true, name: 'Football'},
  {category: 'Sporting Goods', price: '$9.99', stocked: true, name: 'Baseball'},
  {category: 'Sporting Goods', price: '$29.99', stocked: false, name: 'Basketball'},
  {category: 'Electronics', price: '$99.99', stocked: true, name: 'iPod Touch'},
  {category: 'Electronics', price: '$399.99', stocked: false, name: 'iPhone 5'},
  {category: 'Electronics', price: '$199.99', stocked: true, name: 'Nexus 7'}
];
 
ReactDOM.render(
  <ProductTable products={PRODUCTS} />,
  document.getElementById('root')
);