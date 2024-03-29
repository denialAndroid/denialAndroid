package school.alihamz.assignment2

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import school.alihamz.assignment2.databinding.FragmentFirstBinding
import school.alihamz.assignment2.model.AppData


class NewQuestationFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    private var mContext: Context? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mContext = requireActivity().applicationContext

        val act = activity as MainActivity
        act.firstNo = (1..9).random()
        act.secondNo = (1..9).random()
        act.ans = act.firstNo * act.secondNo
        act.wrongAns = 0

        binding.tvNumber.text =
            act.firstNo.toString().plus(" * ").plus(act.secondNo.toString()).plus(" = ")

        binding.btnSubmit.setOnClickListener {
            if (binding.edtAns.text.isNotEmpty()) {
                act.userRepository?.insertUser(
                    AppData(
                        act.firstNo,
                        act.secondNo,
                        binding.edtAns.text.toString().toInt()
                    )
                )
                if (binding.edtAns.text.toString().toInt() == act.ans) {
                    val newFragment: Fragment = RightAnswerFragment()
                    val ft: FragmentTransaction =
                        activity?.supportFragmentManager!!.beginTransaction()
                    ft.addToBackStack(null)
                    ft.add(R.id.frm_container, newFragment).commit()
                } else {
                    act.wrongAns = binding.edtAns.text.toString().toInt()
                    val newFragment: Fragment = WrongAnswerFragment()
                    val ft: FragmentTransaction =
                        activity?.supportFragmentManager!!.beginTransaction()
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