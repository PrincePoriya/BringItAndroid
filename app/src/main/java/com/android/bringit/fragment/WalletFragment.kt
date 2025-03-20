package com.android.bringit.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.bringit.R
import com.android.bringit.activity.DeliveryDetailActivity
import com.android.bringit.activity.TransactionHistoryActivity
import com.android.bringit.activity.WithdrawActivity
import com.android.bringit.databinding.FragmentHomeBinding
import com.android.bringit.databinding.FragmentWalletBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
/**
 * A simple [Fragment] subclass.
 * Use the [WalletFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WalletFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentWalletBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentWalletBinding.inflate(inflater, container, false)

        binding.crdTransactionHistory.setOnClickListener {
            val intent = Intent(requireContext(), TransactionHistoryActivity::class.java)
            startActivity(intent)
        }

        binding.crdTransferToAccount.setOnClickListener {
            val intent = Intent(requireContext(), WithdrawActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MyTripFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            WalletFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}