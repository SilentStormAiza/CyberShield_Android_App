package com.example.cyberarmour.Auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cyberarmour.R

class ScamListFragment : Fragment() {

    private lateinit var adapter: ScamAdapter
    private val allScams = listOf(
        Scam("1. Phishing Case", "A deceptive attempt to obtain sensitive information.", "High"),
        Scam("2. Cyberbullying", "Harassment using digital devices.", "Medium"),
        Scam("3. Ransomware", "Malicious software that threatens to pay for recovering data.", "Critical"),
        Scam("4. Social Engineering", "Psychological manipulation of people, by using social media gathered there information.", "High"),
        Scam("5. Identity Theft", "Deliberate use of someone else's identity.", "Critical"),
        Scam("6. Investment Scam", "Fraudulent schemes promising high returns.", "High")
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_scam_list, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.scamsRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        
        adapter = ScamAdapter(allScams) { scam ->
            (activity as? dashboard)?.showScamDetail(scam)
        }
        recyclerView.adapter = adapter

        val searchView: SearchView = view.findViewById(R.id.searchView)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean = false
            override fun onQueryTextChange(newText: String?): Boolean {
                filterScams(newText)
                return true
            }
        })

        return view
    }

    private fun filterScams(query: String?) {
        val filteredList = if (query.isNullOrEmpty()) {
            allScams
        } else {
            allScams.filter { it.title.contains(query, ignoreCase = true) }
        }
        adapter.updateList(filteredList)
    }
}
