package com.irmak.customcomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.irmak.customcomponent.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.progressButtonBlueLarge.setOnClickListener{
//            binding.progressButtonBlueLarge.setLoading()
            lifecycleScope.launch {
                delay(1_500)
                Toast.makeText(applicationContext,"tıklandı",Toast.LENGTH_SHORT).show()
//                binding.progressButtonBlueLarge.setNormal()
            }
        }
        binding.progressButtonBlueMedium.setOnClickListener{
            binding.progressButtonBlueMedium.setLoading()
            lifecycleScope.launch {
                delay(1_500)
                binding.progressButtonBlueMedium.setNormal()
            }
        }
        binding.progressButtonBlueSmall.setOnClickListener{
            binding.progressButtonBlueSmall.setLoading()
            lifecycleScope.launch {
                delay(1_500)
                binding.progressButtonBlueSmall.setNormal()
            }
        }
        binding.progressButtonLightBlueLarge.setOnClickListener{
            binding.progressButtonLightBlueLarge.setLoading()
            lifecycleScope.launch {
                delay(1_500)
                binding.progressButtonLightBlueLarge.setNormal()
            }
        }
        binding.progressButtonLightBlueMedium.setOnClickListener{
            binding.progressButtonLightBlueMedium.setLoading()
            lifecycleScope.launch {
                delay(1_500)
                binding.progressButtonLightBlueMedium.setNormal()
            }
        }
        binding.progressButtonLightBlueSmall.setOnClickListener{
            binding.progressButtonLightBlueSmall.setLoading()
            lifecycleScope.launch {
                delay(1_500)
                binding.progressButtonLightBlueSmall.setNormal()
            }
        }
        binding.progressButtonWhiteLarge.setOnClickListener{
            binding.progressButtonWhiteLarge.setLoading()
            lifecycleScope.launch {
                delay(1_500)
                binding.progressButtonWhiteLarge.setNormal()
            }
        }
        binding.progressButtonWhiteMedium.setOnClickListener{
            binding.progressButtonWhiteMedium.setLoading()
            lifecycleScope.launch {
                delay(1_500)
                binding.progressButtonWhiteMedium.setNormal()
            }
        }
        binding.progressButtonWhiteSmall.setOnClickListener{
            binding.progressButtonWhiteSmall.setLoading()
            lifecycleScope.launch {
                delay(1_500)
                binding.progressButtonWhiteSmall.setNormal()
            }
        }
    }
}