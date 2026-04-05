package com.example.cyberarmour.Auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.cyberarmour.R

class ScamDetailFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_scam_detail, container, false)

        // Receiving the custom object from the Bundle
        val scam = arguments?.getSerializable("selected_scam") as? Scam

        val titleTv: TextView = view.findViewById(R.id.detailTitle)
        val severityTv: TextView = view.findViewById(R.id.detailSeverity)
        val descriptionTv: TextView = view.findViewById(R.id.detailDescription)
        val backBtn: Button = view.findViewById(R.id.btnBackToList)

        scam?.let {
            titleTv.text = it.title
            severityTv.text = "Severity: ${it.severity}"
            descriptionTv.text = it.description
        }

        backBtn.setOnClickListener {
            // F4: Transaction to go back to the list
            activity?.supportFragmentManager?.popBackStack()
        }

        return view
    }

    companion object {
        fun newInstance(scam: Scam): ScamDetailFragment {
            val fragment = ScamDetailFragment()
            val args = Bundle()
            // Passing the custom object into a Bundle
            args.putSerializable("selected_scam", scam)
            fragment.arguments = args
            return fragment
        }
    }
}
