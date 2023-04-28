package com.ebookfrenzy.contactsproject

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

class ContactRepository(application: Application)
{
    val searchResults = MutableLiveData<List<Contact>>()

    val allContacts: LiveData<List<Contact>>?
    val ascContacts: LiveData<List<Contact>>?
    val descContacts: LiveData<List<Contact>>?

    private var contactDao: ContactDao?

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    init
    {
        val db: ContactRoomDatabase? =
            ContactRoomDatabase.getDatabase(application)
        contactDao = db?.contactDao()
        allContacts = contactDao?.getAllContacts()
        ascContacts = contactDao?.getASCContacts()
        descContacts = contactDao?.getDESCContacts()
    }

    fun ascContacts()
    {
        coroutineScope.launch(Dispatchers.IO)
        {
            asyncAsc()
        }
    }

    private suspend fun asyncAsc()
    {
        contactDao?.getASCContacts()
    }

    fun descContacts()
    {
        coroutineScope.launch(Dispatchers.IO)
        {
            asyncDesc()
        }
    }

    private suspend fun asyncDesc()
    {
        contactDao?.getDESCContacts()
    }

    fun insertContact(newcontact: Contact)
    {
        coroutineScope.launch(Dispatchers.IO)
        {
            asyncInsert(newcontact)
        }
    }

    private suspend fun asyncInsert(contact: Contact)
    {
        contactDao?.insertContact(contact)
    }

    fun deleteContact(id: Int)
    {
        coroutineScope.launch(Dispatchers.IO)
        {
            asyncDelete(id)
        }
    }

    private suspend fun asyncDelete(id: Int)
    {
        contactDao?.deleteContact(id)
    }

    fun findContact(name: String)
    {
        coroutineScope.launch(Dispatchers.Main)
        {
            searchResults.value = asyncFind(name).await()
        }
    }

    private suspend fun asyncFind(name: String): Deferred<List<Contact>?> = coroutineScope.async(Dispatchers.IO)
    {
            return@async contactDao?.findContact(name)
    }
}