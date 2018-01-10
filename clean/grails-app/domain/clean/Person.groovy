package clean

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode(includes='name,email')
class Person {
    String name
    String email

    static constraints = {
        name blank: false
        email blank: false, email: true
    }

}
