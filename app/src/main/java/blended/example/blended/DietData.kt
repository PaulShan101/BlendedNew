package com.example.blended
/*AUTHOR: Paul Shanahan
Date : 10/02/2022
Version : 1.0
*/
//firebase diet data. all of the options for my app that are in the console
class DietData {
    /**set Data*/
    var name :String? = null
    var info:String? = null
    var img:String? = null
    var date:String? = null
    var calories:String? = null
    constructor(){}

    constructor(
        name:String?,
        info:String?,
        img:String?,
        date:String?,
        calories:String?
    ){
        this.name = name
        this.info = info
        this.img = img
        this.date = date
        this.calories = calories
    }
}