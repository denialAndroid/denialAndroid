package school.alihamz.assignment2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.fragment.findNavController
import school.alihamz.assignment2.databinding.FragmentFirstBinding
import school.alihamz.assignment2.databinding.FragmentSeeAnsBinding

class SeeAnswerFragment : Fragment() {

    private var _binding: FragmentSeeAnsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSeeAnsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val act = activity as MainActivity
        binding.tvNumber.text = act.firstNo.toString().plus(" * ").plus(act.secondNo.toString()).plus(" = ").plus(act.ans)

        binding.llNewProblem.setOnClickListener {
            val newFragment: Fragment = NewQuestationFragment()
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