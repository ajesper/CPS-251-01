package com.ebookfrenzy.recycleviewintents

class Data (
    private var titles: Array<String>,
    private var details: Array<String>,
    private var images: Array<Int>)
{

    fun getTitle(): Array<String> {
        return titles
    }

    fun getTheDetails(): Array<String> {
        return details
    }

    fun getImage(): Array<Int> {
        return images
    }
}