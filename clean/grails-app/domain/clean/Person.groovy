package clean

class Person {
    Integer idp
    String name
    String email
    int age

    static constraints = {
        name blank: false
        email blank: false, email: true

    }
}
