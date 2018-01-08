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
    def update(Person person) {
        Person.load(person.id).delete()
            try {
            def personUpdate = new Person(person)
            personUpdate.save
        } catch(ValidationException e) {
            render "Unsuccessful Update"
        }
        render "Successful Update"
    }
    def edit(Integer id) {
        def person =Person.get(id)
        [person:person]
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
