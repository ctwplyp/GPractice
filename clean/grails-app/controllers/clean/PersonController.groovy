package clean

class PersonController {

    def index() {
        Person person = new Person(id: 1, name: "sean", "sean@gmail.com")
        [person:person]
    }
}
