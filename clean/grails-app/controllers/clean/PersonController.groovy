package clean

import com.sun.codemodel.internal.JForEach

class PersonController {

    def index() {
       def persons = Person.list()
        [persons:persons]
    }
}
