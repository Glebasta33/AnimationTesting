package com.trusov.animationtesting.ui.property_animation

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.*
import android.widget.TextView
import androidx.core.view.ViewCompat.animate
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.trusov.animationtesting.databinding.FragmentPropertyAnimationBinding

class PropertyAnimationFragment : Fragment() {

    private var _binding: FragmentPropertyAnimationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewModel =
            ViewModelProvider(this).get(PropertyAnimationViewModel::class.java)

        _binding = FragmentPropertyAnimationBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        viewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textHome.setOnClickListener {
            it.animate().apply {
                rotation(360F)
                duration = 1000L
                interpolator = AccelerateDecelerateInterpolator()
            }.start()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}