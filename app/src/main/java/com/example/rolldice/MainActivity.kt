package com.example.rolldice

import android.animation.Animator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.rolldice.databinding.ActivityMainBinding
lateinit var viewmodel:viewModel
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        viewmodel=ViewModelProvider(this).get(viewModel::class.java)
        viewmodel.number.observe(this, Observer {
            number ->
            if(number==0) {
                binding.textView2.text = number.toString()
            }
            else
            {
                binding.textView2.visibility=View.VISIBLE
                binding.textView2.text = number.toString()
            }
        })
        binding.button.setOnClickListener {
            binding.apply {
                animationView.visibility= View.VISIBLE
                animationView.playAnimation()
                button.isEnabled=false
                textView2.visibility=View.INVISIBLE
            }
        }
        binding.animationView.addAnimatorListener(object : Animator.AnimatorListener{
            override fun onAnimationStart(p0: Animator?) {

            }
            override fun onAnimationEnd(p0: Animator?) {
                viewmodel.generate()
                binding.apply {
                    animationView.visibility= View.INVISIBLE
                    button.isEnabled=true
                    textView2.visibility=View.VISIBLE
                }
            }
            override fun onAnimationCancel(p0: Animator?) {

            }
            override fun onAnimationRepeat(p0: Animator?) {
            }
        })
    }
}