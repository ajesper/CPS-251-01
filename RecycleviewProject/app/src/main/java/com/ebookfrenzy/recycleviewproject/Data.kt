package com.ebookfrenzy.recycleviewproject

class Data (private var title: String, private var details: String, private var image: Int) {
    fun getTitle(): String {
        return title
    }

    fun getDetails(): String {
        return details
    }

    fun getImage(): Int {
        return image
    }
}