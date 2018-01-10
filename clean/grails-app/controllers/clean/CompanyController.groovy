package clean

class CompanyController {

    def index() {
        def companys = Company.list()
        [companys:companys]
    }
}
