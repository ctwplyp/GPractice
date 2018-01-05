package feedback

class Company {
    Integer id
    String name
    static hasMany = [persons:Person]

    static constraints = {
        id (blank: false)
        name (blank: false)
    }
}
