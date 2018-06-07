package com.teangsunry.countryflag

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.teangsunry.countrylibrary.CountryPickerDialog
import com.teangsunry.countrylibrary.listener.OnCountryPickerListener
import com.teangsunry.countrylibrary.model.Country
import com.teangsunry.countrylibrary.model.CountryPicker
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnCountryPickerListener {

    private var countryPicker: CountryPicker? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countryPicker = CountryPicker.Builder().with(this)
                .listener(this)
                .build()
        select_country_pick.setOnClickListener {
            countryPicker?.showDialog(supportFragmentManager)
        }
        onSelectCountry(countryPicker?.getDefualtCountry(this))

    }


    override fun onSelectCountry(country: Country?) {
        flag_icon_imageview?.setBackgroundResource(country!!.flag)
        country_code_textview.text = "" + country?.dialCode
    }
}
