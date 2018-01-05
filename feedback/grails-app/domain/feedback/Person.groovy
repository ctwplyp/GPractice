package feedback

class Person {
    int id
    String name
    String email
    static belongsTo = [companys: Company]

    static constraints = {
        id (blank: false)
        name (blank: false)
        email (blank: false)
    }
}
