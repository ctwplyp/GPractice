package clean

import javax.xml.bind.ValidationException
import grails.transaction.Transactional

class PersonController {

    def index() {
       def persons = Person.list()
        [persons:persons]
    }
    def save() {
        System.out.println(params)
        new Person(name:name,email:email, company:companyId).save(flush:true)
        System.out.println()
       // def company1 = Company.load(1)
        try {
         //   company1.addToPersons(new Person(name:"Sean3",email:"sean3@gmail.com")).save(flush:true)
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
        def person = Person.get(id)
        [person:person]
    }
    def cancel() {
        render "Action Cancelled"
    }
    def create(){
        def companys =Company.list()
        [companys:companys]
    }
   def show(Integer id){
       def person =Person.get(id)
        [person:person]
   }
}
