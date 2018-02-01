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

function dispatchAndLog(store, action) {
    console.log('dispatching', action)
    store.dispatch(action)
    console.log('next state', store.getState())
}

function dispatchAndThenLog(store, action) {
    console.log('dispatching', action)
    store.dispatch(action)
        .then(() => console.log(store.getState()))
    console.log('next state', store.getState())
}
   dispatchAndLog(store, selectSubreddit('reactjs'))
  dispatchAndThenLog(store, fetchPostsIfNeeded('reactjs'))



