package clean

import javax.xml.bind.ValidationException
import grails.transaction.Transactional

class CompanyController {

    def index() {
        def companys = Company.list()
        [companys:companys]
    }
    def save(String name) {
        try {
        def company = new Company(name:name).save(flush:true)
           // company.addToPersons(new Person(name:personName,email:"sean@gmail.com")).save(flush:true)
        } catch(ValidationException e) {
            render "Unsuccessful Save"
        }
        render "Successful Save"
    }
    def create(){
        def persons = Person.list()
        [persons:persons]
    }
    def show(Integer id){
        def company = Company.get(id)
        [company:company]
    }
    def edit(){
        System.out.print(params)

    }

}
