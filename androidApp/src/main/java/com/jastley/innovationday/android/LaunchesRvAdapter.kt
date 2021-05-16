package com.jastley.innovationday.android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.jastley.innovationday.android.databinding.ItemLaunchBinding
import com.jastley.innovationday.shared.entity.RocketLaunch

class LaunchesRvAdapter(var launches: List<RocketLaunch>): RecyclerView.Adapter<LaunchesRvAdapter.LaunchViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LaunchesRvAdapter.LaunchViewHolder {
        val binding = ItemLaunchBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        return LaunchViewHolder(binding)
    }

    override fun getItemCount(): Int = launches.count()

    override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) {
        holder.bindData(launches[position])
    }

    inner class LaunchViewHolder(binding: ItemLaunchBinding): RecyclerView.ViewHolder(binding.root) {
        private val missionTV = binding.missionName
        private val launchYearTV = binding.launchYear
        private val launchSuccessTV = binding.launchSuccess
        private val missionDetailsTV = binding.details

        fun bindData(launch: RocketLaunch) {
            val ctx = itemView.context
            missionTV.text = ctx.getString(R.string.mission_name_field, launch.missionName)
            launchYearTV.text = ctx.getString(R.string.launch_year_field, launch.launchYear.toString())
            missionDetailsTV.text = ctx.getString(R.string.details_field, launch.details ?: "")

            when (launch.launchSuccess) {
                true -> {
                     launchSuccessTV.text = ctx.getString(R.string.successful)
                     launchSuccessTV.setTextColor((ContextCompat.getColor(ctx, R.color.colorSuccessful)))
                }
                false -> {
                    launchSuccessTV.text = ctx.getString(R.string.unsuccessful)
                    launchSuccessTV.setTextColor((ContextCompat.getColor(ctx, R.color.colorUnsuccessful)))
                }
                else -> {
                    launchSuccessTV.text = ctx.getString(R.string.no_data)
                    launchSuccessTV.setTextColor((ContextCompat.getColor(ctx, R.color.colorNoData)))
                }
            }

        }
    }
}