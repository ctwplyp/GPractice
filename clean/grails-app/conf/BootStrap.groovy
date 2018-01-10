import clean.Person
import clean.Company
class BootStrap {

    def init = { servletContext ->
        //def person1 = new Person(name:"Sean",email:"sean@gmail.com").save()
        //def person2 = new Person(name:"ralph",email:"sralph@gmail.com").save()
       // def person3 = new Person(name:"mike",email:"mike@gmail.com").save()
       // def company = new Company(name:"Sample6", persons: [person1,person2,person3]).save()
      //  company.add(person1).save()
       // company.add(person2).save()
        //company.add(person3).save()
        def company = new Company(name:"Sample6").save()
        company.addToPersons(new Person(name:"Sean",email:"sean@gmail.com")).save()

    }
    def destroy = {
    }
}
