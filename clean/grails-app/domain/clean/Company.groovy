package clean

class Company {
    String name
    List persons
    static hasMany= [persons:Person]

    static constraints = {
        name blank: false
    }
}
