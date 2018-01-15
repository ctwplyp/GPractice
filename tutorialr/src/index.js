import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';

//const numbers = [1, 2, 3, 4, 5];
//const doubledPlus1 = numbers.map((number) => number * 2+1);
//const doubledItems = doubledPlus1.map((doubled) =>
 // <li>{doubled}</li>
//);

function Blog(props) {
const sidebar = (
    <ul>
      {props.posts.map((post) =>
        <li key={post.id}>
          {post.title}
        </li>
      )}
    </ul>
  );
const content = props.posts.map((post) =>
	<div key={post.id}>
	<h3>{post.title}</h3>
	<p>{post.content}</p>
	</div>
	);
	return (
	<div>
		{sidebar}
		<hr />
		{content}
		</div>
		);
	}
const posts = [
	{id: 1, title: 'Hello World', content: 'Welcome to rails'}];

ReactDOM.render(
  <Blog posts={posts} />,
  document.getElementById('root')
);
