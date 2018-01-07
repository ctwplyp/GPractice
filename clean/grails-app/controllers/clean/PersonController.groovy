package clean

class PersonController {

    def index() {
       def persons = Person.list()
        [persons:persons]
    }
    def save() {
        def person = new Person(params)
        person.save()
        render "Success!"
    }
    def create(){
        
    }
}
