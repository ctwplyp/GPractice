package clean

import javax.xml.bind.ValidationException

class PersonController {

    def index() {
       def persons = Person.list()
        [persons:persons]
    }
    def save() {
        def person = new Person(params)
        try {
            person.save()
        } catch(ValidationException e) {
            render "Unsuccessful Save"
        }
        render "Successful Save"
    }
    def cancel() {
        render "Action Cancelled"
    }
    def create(){

    }
    def show(Person person){
        person = Person.get(1)
        [person:person]
    }
}
