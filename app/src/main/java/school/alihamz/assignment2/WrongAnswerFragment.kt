package school.alihamz.assignment2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import school.alihamz.assignment2.databinding.FragmentWrongAnsBinding

class WrongAnswerFragment : Fragment() {

    private var _binding: FragmentWrongAnsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWrongAnsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val act = activity as MainActivity
        binding.tvNumber.text = act.firstNo.toString().plus(" * ").plus(act.secondNo.toString()).plus(" = ").plus(act.ans)
        binding.tvWrongAns.text = act.wrongAns.toString()

        binding.btnTryAgain.setOnClickListener {
            val newFragment: Fragment = TryAgainFragment()
            val ft: FragmentTransaction = activity?.supportFragmentManager!!.beginTransaction()
            ft.addToBackStack(null)
            ft.add(R.id.frm_container, newFragment).commit()
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