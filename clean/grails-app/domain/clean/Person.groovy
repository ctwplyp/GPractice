package clean

class Person {
    int id
    String name
    String email

    static constraints = {
        id blank: false, unique: true
        name blank: false
        email blank: false, email: true

    }
}
