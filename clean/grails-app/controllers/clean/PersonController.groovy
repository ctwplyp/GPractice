package clean

import javax.xml.bind.ValidationException
import grails.transaction.Transactional

class PersonController {

    def index() {
       def persons = Person.list()
        [persons:persons]
    }
    def save() {
        def person = new Person(params)
        try {
            person.save(flush:true)
        } catch(ValidationException e) {
            render "Unsuccessful Save"
        }
        render "Successful Save"
    }
    def update(Person person) {
        if (person==null){
            render txt "Unsuccessful Update"
            return
        }
        try {
            person.save(flush:true)

        } catch(ValidationException e) {
            render "Unsuccessful Update"
        }
        render "Successful Update"
    }
    def edit(Integer id) {
        System.out.print(id)
        def person = Person.get(id)
        [person:person]
    }
    def cancel() {
        render "Action Cancelled"
    }
    def create(){

    }
   def show(Integer id){
       def person =Person.get(id)
        [person:person]
   }
}
