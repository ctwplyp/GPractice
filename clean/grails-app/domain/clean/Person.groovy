package clean

class Person {
    String name
    String email

    static constraints = {
        name blank: false
        email blank: false, email: true
    }
}
