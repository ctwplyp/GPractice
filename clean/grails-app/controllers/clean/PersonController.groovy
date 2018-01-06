package clean

class PersonController {

    def index() {
        def person1 = new Person(idp: 8, name:"Sean",email:"sean@gmail.com",age:21)
        def person2 = new Person(idp: 9, name:"ralph",email:"sralph@gmail.com",age:21)
        def person3 = new Person(idp: 10, name:"mike",email:"mike@gmail.com",age:21)

        [person1:person1, person2:person2, person3:person3]
    }
}
