package com.madhavsewasociety.receivedatafromyoutubeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.madhavsewasociety.receivedatafromyoutubeapp.databinding.ActivityReceiveBinding
import java.util.regex.Matcher
import java.util.regex.Pattern

class ReceiveActivity : AppCompatActivity() {
    lateinit var binding : ActivityReceiveBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityReceiveBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.action== Intent.ACTION_SEND
        if("text/plain"==intent.type){
            binding.textView.text=intent.getStringExtra(Intent.EXTRA_TEXT)
            var link="https://img.youtube.com/vi/${getLinkFromURL(intent.getStringExtra(Intent.EXTRA_TEXT))}/maxresdefault.jpg"
            Glide.with(this@ReceiveActivity).load(link).into(binding.imgView)
        }

    }
    fun getLinkFromURL(url : String?) : String?{
        val regex = "(?<=youtu.be/|watch\\? v=|/videos/|embed\\/)[^#\\&\\?]*"
        var pattern=Pattern.compile(regex,Pattern.CASE_INSENSITIVE)
        var matcher=pattern.matcher(url.toString())
        var videoId = ""
        if(matcher.find()){
            videoId=matcher.group()
        }
        return videoId
    }
}