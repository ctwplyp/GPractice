import fetch from 'cross-fetch'

export REQUEST_POSTS = 'REQUEST_POSTS'
function requestPosts(subreddit) {
	return {
		type: REQUEST_POSTS,
		subreddit
	}
}

export const RECEIVE_POSTS ='RECEIVE_POSTS'
function receivePosts(subreddit, json) {
	return {
		type: RECEIVE_POSTS,
		subreddit,
		posts: json.data.children.map(child => child.data),
		receivedAt: Date.now()
	}
}

export const INVALIDATE_SUBREDDIT = 'INVALIDATE_SUBREDDIT'
export function invalidateSubreddit(subreddit) {
	return {
		type: INVALIDATE_SUBREDDIT,
		subreddit
	}
}

export function fetchPosts(subreddit) {
	return function(dispatch) {
		dispatch(requestPosts(subreddit))

		return fetch('https://www.reddit.com/r/${subreddit}.json')
			.then(
				response => response.json(),
				error => console.log('An error ocurred.', error)
				)
			.then(json =>
				dispatch(receivePosts(subreddit, json))
				)
	}
}

