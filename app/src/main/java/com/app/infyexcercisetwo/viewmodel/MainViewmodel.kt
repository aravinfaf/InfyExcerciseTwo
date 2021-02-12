package com.app.infyexcercisetwo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.infyexcercisetwo.R
import com.app.infyexcercisetwo.data.CountryModel

class MainViewmodel : ViewModel() {

    private val countrylist = ArrayList<CountryModel>()
    private val livedata = MutableLiveData<ArrayList<CountryModel>>()

    init {
          livedata.postValue(fetchData())
    }

    private fun fetchData(): ArrayList<CountryModel>? {

        val data1 = CountryModel(
            "Beavers",
            "Beavers are second only to humans in their ability to manipulate and change their environment. They can measure up to 1.3 metres long. A group of beavers is called a colony",
            R.drawable.american_beaver
        )
        if (checkiSEmpty(data1)) countrylist!!.add(data1)

        val data2 = CountryModel("Flag", null, R.drawable.flag_of_canada)
        if (checkiSEmpty(data2)) countrylist!!.add(data2)

        val data3 = CountryModel(
            "Transportation",
            "It is a well known fact that polar bears are the main mode of transportation in Canada. They consume far less gas and have the added benefit of being difficult to steal.",
            R.drawable.the_golden_compass_still
        )
        if (checkiSEmpty(data3)) countrylist!!.add(data3)

        val data4 = CountryModel(
            "Hockey Night in Canada",
            "These Saturday night CBC broadcasts originally aired on radio in 1931. In 1952 they debuted on television and continue to unite (and divide) the nation each week.",
            null
        )
        if (checkiSEmpty(data4)) countrylist!!.add(data4)

        val data5 = CountryModel(
            "Eh",
            "A chiefly Canadian interrogative utterance, usually expressing surprise or doubt or seeking confirmation.",
            null
        )
        if (checkiSEmpty(data5)) countrylist!!.add(data5)

        val data6 =
            CountryModel("Housing", "Warmer than you might think.", R.drawable.igloo_icon)
        if (checkiSEmpty(data6)) countrylist!!.add(data6)

        val data7 = CountryModel("Public Shame", "Sadly it's true.", R.drawable.avril_lavigne)
        if (checkiSEmpty(data7)) countrylist!!.add(data7)

        val data8 = CountryModel(null, null, null)
        if (checkiSEmpty(data8)) countrylist!!.add(data8)

        val data9 = CountryModel(
            "Space Program",
            "Canada hopes to soon launch a man to the moon.",
            null
        )
        if (checkiSEmpty(data9)) countrylist!!.add(data9)

        val data10 = CountryModel(
            "Meese",
            "A moose is a common sight in Canada. Tall and majestic, they represent many of the values which Canadians imagine that they possess. They grow up to 2.7 metres long and can weigh over 700 kg. They swim at 10 km/h. Moose antlers weigh roughly 20 kg. The plural of moose is actually 'meese', despite what most dictionaries, encyclopedias, and experts will tell you.",
            null
        )
        if (checkiSEmpty(data10)) countrylist!!.add(data10)

        val data11 = CountryModel("Geography", "It's really big.", null)
        if (checkiSEmpty(data11)) countrylist!!.add(data11)

        val data12 =
            CountryModel("Kittens...", "Éare illegal. Cats are fine.", R.drawable.image_kittens)
        if (checkiSEmpty(data12)) countrylist!!.add(data12)

        val data13 = CountryModel(
            "Mounties",
            "They are the law. They are also Canada's foreign espionage service. Subtle.",
            R.drawable.mounties
        )
        if (checkiSEmpty(data13)) countrylist!!.add(data13)

        val data14 = CountryModel("Language", "Nous parlons tous les langues importants.", null)
        if (checkiSEmpty(data14)) countrylist!!.add(data14)

        return countrylist
    }

    fun checkiSEmpty(data: CountryModel): Boolean = if (data.title != null) true else false

    fun getCountryData() : LiveData<ArrayList<CountryModel>>{
        return livedata
    }
}