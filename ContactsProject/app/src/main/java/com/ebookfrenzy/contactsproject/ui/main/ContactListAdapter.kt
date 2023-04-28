package com.ebookfrenzy.contactsproject.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.contactsproject.Contact
import com.ebookfrenzy.contactsproject.R
import com.google.android.material.snackbar.Snackbar

class ContactListAdapter(private val contactItemLayout: Int, private val viewModel: MainViewModel) :  RecyclerView.Adapter<ContactListAdapter.ViewHolder>() {

    private var contactList: List<Contact>? = null

    override fun onBindViewHolder(holder: ViewHolder, listPosition: Int) {
        val nam = holder.name
        val num = holder.number
        val tra = holder.trash
        contactList.let {
            nam.text = it!![listPosition].contactName
            num.text = it!![listPosition].contactNumber
            tra.id = it!![listPosition].id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(view, contactList, viewModel)
    }

    fun setContactList(contacts: List<Contact>) {
        contactList = contacts
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if (contactList == null) 0 else contactList!!.size
    }

    class ViewHolder(itemView: View, contactList: List<Contact>?, viewModel: MainViewModel) : RecyclerView.ViewHolder(itemView) {
        var trash: ImageButton
        var name: TextView
        var number: TextView


        init {

            trash = itemView.findViewById(R.id.trash)
            name = itemView.findViewById(R.id.name)
            number = itemView.findViewById(R.id.number)

            trash.setOnClickListener { v: View ->
                val position: Int = adapterPosition
                val contact = contactList?.get(position)

                contact?.let {
                    viewModel.deleteContact(it.id)
                    Snackbar.make(
                        v,
                        "Contact ${it.contactName} deleted",
                        Snackbar.LENGTH_LONG
                    ).setAction("Action", null).show()
                }
            }
        }
    }
}