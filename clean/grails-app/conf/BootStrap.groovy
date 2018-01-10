import clean.Person
class BootStrap {

    def init = { servletContext ->
        new Person(name:"Sean",email:"sean@gmail.com").save()
        new Person(name:"ralph",email:"sralph@gmail.com").save()
        new Person(name:"mike",email:"mike@gmail.com").save()

    }
    def destroy = {
    }
}
