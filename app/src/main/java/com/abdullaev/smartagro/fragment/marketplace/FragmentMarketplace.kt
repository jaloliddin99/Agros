package com.abdullaev.smartagro.fragment.marketplace

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abdullaev.smartagro.R
import com.abdullaev.smartagro.adapter.marketplace.PodcastMainForAllAdapter
import com.abdullaev.smartagro.adapter.marketplace.PodcastMainViewpager
import com.abdullaev.smartagro.databinding.FragmentFarmManagementBinding
import com.abdullaev.smartagro.databinding.FragmentMarketplaceBinding
import com.abdullaev.smartagro.model.RentModel
import com.abdullaev.smartagro.model.TestModel
import com.google.android.material.transition.MaterialElevationScale

class FragmentMarketplace : Fragment(), PodcastMainViewpager.OnItemClick {

    private lateinit var binding: FragmentMarketplaceBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMarketplaceBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postponeEnterTransition()
        view.doOnPreDraw { startPostponedEnterTransition() }
        clickListeners()
        exitTransition = null
        reenterTransition = null


    }

    private val sportsItemListener =
        PodcastMainForAllAdapter.OnClickListener { testModel, cardView, imageView, _ ->
            exitTransition = MaterialElevationScale(false).apply {
                duration = 300.toLong()
            }

            reenterTransition = MaterialElevationScale(true).apply {
                duration = 300.toLong()
            }

            val direction: NavDirections =
                FragmentMarketplaceDirections.actionFragmentMarketplaceToFragmentPodcastDisplay(
                    testModel
                )
            val extras = FragmentNavigatorExtras(
                (cardView as View to testModel.title) as Pair<View, String>,
                (imageView as View to testModel.id) as Pair<View, String>
            )
            findNavController().navigate(direction, extras)
        }

    private fun clickListeners() {
        binding?.apply {


            loadList1()
            loadList2()
            loadList3()

            viewpager.layoutManager =
                object : LinearLayoutManager(context, HORIZONTAL, false) {
                    override fun checkLayoutParams(lp: RecyclerView.LayoutParams): Boolean {
                        lp.width = width * 7 / 8
                        return true
                    }
                }


            viewpager.adapter = PodcastMainViewpager(loadList5(), this@FragmentMarketplace)


            recyclerViewForAll.layoutManager =
                object : LinearLayoutManager(context, HORIZONTAL, false) {
                    override fun checkLayoutParams(lp: RecyclerView.LayoutParams): Boolean {
                        lp.width = width * 3 / 8
                        return true
                    }
                }

            recyclerViewMotivation.layoutManager =
                object : LinearLayoutManager(context, HORIZONTAL, false) {
                    override fun checkLayoutParams(lp: RecyclerView.LayoutParams): Boolean {
                        lp.width = width * 3 / 8
                        return true
                    }
                }

            recyclerViewNewPodcast.layoutManager =
                object : LinearLayoutManager(context, HORIZONTAL, false) {
                    override fun checkLayoutParams(lp: RecyclerView.LayoutParams): Boolean {
                        lp.width = width * 3 / 8
                        return true
                    }
                }

            recyclerViewForAll.adapter = PodcastMainForAllAdapter(list1, sportsItemListener)
            recyclerViewMotivation.adapter = PodcastMainForAllAdapter(list3, sportsItemListener)
            recyclerViewNewPodcast.adapter = PodcastMainForAllAdapter(list2, sportsItemListener)

        }
    }

    private lateinit var list1: List<TestModel>
    private lateinit var list2: List<TestModel>
    private lateinit var list3: List<TestModel>

    private fun loadList1() {
        list1 = listOf(
            TestModel("key1", R.drawable.banana, "Journeys1", "title1"),
            TestModel("key2", R.drawable.apple, "Journeys2", "title2"),
            TestModel("key3", R.drawable.banana, "Journeys3", "title3"),
            TestModel("key4", R.drawable.lemon, "Journeys4", "title4"),
            TestModel("key5", R.drawable.test_news_image, "Journeys5", "title5"),
        )
    }

    private fun loadList2() {
        list2 = listOf(
            TestModel("key11", R.drawable.banana, "Journeys11", "title11"),
            TestModel("key22", R.drawable.apple, "Journeys22", "title22"),
            TestModel("key33", R.drawable.nut, "Journeys33", "title33"),
            TestModel("key44", R.drawable.apticot, "Journeys44", "title44"),
            TestModel("key55", R.drawable.lemon, "Journeys55", "title55"),
        )
    }

    private fun loadList3() {
        list3 = listOf(
            TestModel("key111", R.drawable.fer1, "Journeys111", "title111"),
            TestModel("key222", R.drawable.fer2, "Journeys222", "title222"),
            TestModel("key333", R.drawable.fer1, "Journeys333", "title333"),
            TestModel("key444", R.drawable.fer3, "Journeys444", "title444"),
            TestModel("key555", R.drawable.fer2, "Journeys555", "title555"),
        )
    }

    private fun loadList5(): ArrayList<RentModel> {
        val list2 = arrayListOf(
            RentModel(R.drawable.lemon, "lemon"),
            RentModel(R.drawable.banana, "banana"),
            RentModel(R.drawable.nut, "nut"),
            RentModel(R.drawable.apticot, "apticot"),
            RentModel(R.drawable.apple, "apple"),

        )
        return list2
    }

    override fun viewPagerClicked() {

    }
}