import thunkMiddleware from 'redux-thunk'
import { createLogger } from 'redux-logger'
import { createStore, applyMiddleware } from 'redux'
import { selectSubreddit, fetchPostsIfNeeded } from './actions'
import rootReducer from './reducers'
import Raven from 'raven-js'
import crashReporter from 'redux-reporter'
const loggerMiddleware = createLogger()

const store = createStore(
  rootReducer,
  applyMiddleware(
    thunkMiddleware, // lets us dispatch() functions
    loggerMiddleware // neat middleware that logs actions
  )
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

function patchStoreToAddCrashReporting(store) {
    let next = store.dispatch
    store.dispatch = function dispatchAndReportErrors(action) {
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
}

function logger(store) {
    let next = store.dispatch

    return  function dispatchAndLog(action) {
        console.log('dispatching', action)
        let result = next(action)
        console.log('next state', store.getState())
        return result
    }
}

function applyMiddlewareByMonkeypatching(store, middlewares) {
        middlewares = middlewares.slice()
        middlewares.reverse()

        middlewares.forEach(middleware =>
            store.dispatch = middleware(store)
        )
    }
   applyMiddlewareByMonkeypatching(store, [logger, crashReporter])
   store.dispatch(selectSubreddit('reactjs'))
   store.dispatch(store, fetchPostsIfNeeded('reactjs'))