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


console.log('dispatching', selectSubreddit('reactjs') )
store.dispatch(selectSubreddit('reactjs'))
store
  .dispatch(fetchPostsIfNeeded('reactjs'))
  .then(() => console.log(store.getState()))
console.log('next state', store.getState())