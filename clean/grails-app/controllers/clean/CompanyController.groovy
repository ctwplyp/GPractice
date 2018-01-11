package clean

import javax.xml.bind.ValidationException
import grails.transaction.Transactional

class CompanyController {

    def index() {
        def companys = Company.list()
        [companys:companys]
    }
    def save(String companyName, String personName) {
       // System.out.println()
        try {
        def company = new Company(name:companyName).save(flush:true)
            company.addToPersons(new Person(name:personName,email:"sean@gmail.com")).save(flush:true)

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

}
