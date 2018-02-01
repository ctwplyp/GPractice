import thunkMiddleware from 'redux-thunk'
import { createStore} from 'redux'
import { selectSubreddit, fetchPostsIfNeeded } from './actions'
import rootReducer from './reducers'
import Raven from 'raven-js'
//import crashReporter from 'redux-reporter'

const store = createStore(
  rootReducer, thunkMiddleware
)

function patchStoreToAddLogging(store) {
    let next = store.dispatch
    store.dispatch = function dispatchAndLog(action) {
        console.log('dispatching', action)
        let result = next(action)
        console.log('next state', store.getState())
        return result
    }
}

const crashReporter = store => next => action => {
        try {
            return next(action)
        } catch (err) {
            console.error('Caught an exception!', err)
            Raven.captureException(err, {
                extra: {
                    action,
                    state: store.getState()
                }
            })
            throw err
        }
    }

const logger = store => next => action => {
        console.log('dispatching', action)
        let result = next(action)
        console.log('next state', store.getState())
        return result
    }



function applyMiddleware(store, middlewares) {
    middlewares = middlewares.slice()
    middlewares.reverse()

    let dispatch = store.dispatch
    middlewares.forEach(middleware =>
        dispatch = middleware(store)(dispatch)
    )
    return Object.assign( store, {dispatch})
}
   applyMiddleware(store, [logger, crashReporter])
   store.dispatch(selectSubreddit('reactjs'))
   store.dispatch(fetchPostsIfNeeded('reactjs'))