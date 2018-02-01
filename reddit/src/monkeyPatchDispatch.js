import thunkMiddleware from 'redux-thunk'
import { createLogger } from 'redux-logger'
import { createStore, applyMiddleware } from 'redux'
import { selectSubreddit, fetchPostsIfNeeded } from './actions'
import rootReducer from './reducers'

const loggerMiddleware = createLogger()

const store = createStore(
  rootReducer,
  applyMiddleware(
    thunkMiddleware, // lets us dispatch() functions
    loggerMiddleware // neat middleware that logs actions
  )
)

let next = store.dispatch

store.dispatch = function dispatchAndLog(action) {
    console.log('dispatching', action)
    let result = next(action)
    console.log('next state', store.getState())
    return result
}

function dispatchAndThenLog(store, action) {
    console.log('dispatching', action)
    store.dispatch(action)
        .then(() => console.log(store.getState()))
    console.log('next state', store.getState())
}
   store.dispatch(selectSubreddit('reactjs'))
  dispatchAndThenLog(store, fetchPostsIfNeeded('reactjs'))





