package com.example.shoestore.data

class Show (name: String, company: String, size: String, description: String,image:Int) {
    var name: String? = ""
    var company: String? = ""
    var size: String? = ""
    var description: String? = ""
    var image:Int =0


    init{
        this.name = name
        this.company = company
        this.size = size
        this.description = description
        this.image= image
    }

    fun isOk() : Boolean{
        return isEmp(name) ||
                isEmp(company) ||
                isEmp(size) ||
                isEmp(description)
    }
    private fun isEmp(string: String? ): Boolean{
        return string== null || string.isEmpty()
    }
}