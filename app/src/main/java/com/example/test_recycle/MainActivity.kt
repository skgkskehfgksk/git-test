package com.example.test_recycle

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.test_recycle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //어댑터 전역 선언
    lateinit var profileAdapter: ProfileAdapter
    //데이타 리스트전연변수 선언
    val datas = mutableListOf<ProfileData>()
    //뷰바이딩 선언
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //바인딩뷰 표시
        setContentView(binding.root)

        initRecycler()
    }

    private fun initRecycler() {
        profileAdapter = ProfileAdapter(this)
        binding.rvProfile.adapter = profileAdapter

        datas.apply {
            add(ProfileData(img = R.drawable.free1, name = "mary", age = 24))
            add(ProfileData(img = R.drawable.free2, name = "jenny", age = 26))
            add(ProfileData(img = R.drawable.free1, name = "jhon", age = 27))
            add(ProfileData(img = R.drawable.free2, name = "ruby", age = 21))
            add(ProfileData(img = R.drawable.free1, name = "yuna", age = 23))
        }
        binding.rvProfile.addItemDecoration(VerticalItemDecorator(20))
        binding.rvProfile.addItemDecoration(HorizontalItemDecorator(10))
        profileAdapter.datas = datas
        profileAdapter.notifyDataSetChanged()
    }
}

class VerticalItemDecorator(private val divHeight : Int) : RecyclerView.ItemDecoration() {

    @Override
    override fun getItemOffsets(outRect: Rect, view: View, parent : RecyclerView, state : RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.top = divHeight
        outRect.bottom = divHeight
    }
}
class HorizontalItemDecorator(private val divHeight : Int) : RecyclerView.ItemDecoration() {

    @Override
    override fun getItemOffsets(outRect: Rect, view: View, parent : RecyclerView, state : RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.left = divHeight
        outRect.right = divHeight
    }
}
