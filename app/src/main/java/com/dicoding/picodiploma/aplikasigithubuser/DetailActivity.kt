package com.dicoding.picodiploma.aplikasigithubuser

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DETAIL = "extra_detail"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_user)


        val tvObject: TextView = findViewById(R.id.txt_name)
        val imgPhoto: ImageView = findViewById(R.id.img_photo)

        val detail = intent.getParcelableExtra<Detail>(EXTRA_DETAIL) as Detail
        val text = "Name : ${detail.name.toString()}" +
                "\nUser Name : ${detail.username}" +
                "\nLocation : ${detail.location}" +
                "\nRepository : ${detail.repository}" +
                "\nCompany : ${detail.company}" +
                "\nFollowers : ${detail.followers}" +
                "\nFollowing : ${detail.following}"
        tvObject.text = text

        Glide.with(this@DetailActivity)
            .load(detail.photo)
            .apply(RequestOptions())
            .into(imgPhoto)

        val actionBar = supportActionBar
        this!!.title = "Detail User"
        actionBar.run {
            this!!.title = detail.name.toString()
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}