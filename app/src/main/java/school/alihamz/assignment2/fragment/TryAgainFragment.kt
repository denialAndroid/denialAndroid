package school.alihamz.assignment2.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import school.alihamz.assignment2.MainActivity
import school.alihamz.assignment2.R
import school.alihamz.assignment2.databinding.FragmentTryAgainBinding

class TryAgainFragment : Fragment() {

    private var _binding: FragmentTryAgainBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentTryAgainBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val act = activity as MainActivity
        binding.tvNumber.text = act.firstNo.toString().plus(" * ").plus(act.secondNo.toString()).plus(" = ")
        binding.edtAns.text.clear()

        binding.btnSubmit.setOnClickListener {
            if (binding.edtAns.text.isNotEmpty()) {
                if (binding.edtAns.text.toString().toInt() == act.ans) {
                    val newFragment: Fragment = RightAnswerFragment()
                    val ft: FragmentTransaction = activity?.supportFragmentManager!!.beginTransaction()
                    ft.addToBackStack(null)
                    ft.add(R.id.frm_container, newFragment).commit()
                } else {
                    act.wrongAns = binding.edtAns.text.toString().toInt()
                    val newFragment: Fragment = WrongAnswerFragment()
                    val ft: FragmentTransaction = activity?.supportFragmentManager!!.beginTransaction()
                    ft.addToBackStack(null)
                    ft.add(R.id.frm_container, newFragment).commit()
                }
            }
        }

        binding.llSeeAns.setOnClickListener {
            val newFragment: Fragment = SeeAnswerFragment()
            val ft: FragmentTransaction = activity?.supportFragmentManager!!.beginTransaction()
            ft.addToBackStack(null)
            ft.add(R.id.frm_container, newFragment).commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}