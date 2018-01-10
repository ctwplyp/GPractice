package clean

class Company {
    String name
    static hasMany= [persons:Person]

    static constraints = {
        name blank: false
    }
}
