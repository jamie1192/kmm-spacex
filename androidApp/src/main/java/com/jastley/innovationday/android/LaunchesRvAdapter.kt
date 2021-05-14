package com.jastley.innovationday.android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.jastley.innovationday.entity.RocketLaunch

class LaunchesRvAdapter(var launches: List<RocketLaunch>): RecyclerView.Adapter<LaunchesRvAdapter.LaunchViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LaunchesRvAdapter.LaunchViewHolder {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.item_launch, parent, false)
            .run(::LaunchViewHolder)
    }

    override fun getItemCount(): Int = launches.count()

    override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) {
        holder.bindData(launches[position])
    }

    inner class LaunchViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val missionTV = itemView.findViewById<TextView>(R.id.missionName)
        private val launchYearTV = itemView.findViewById<TextView>(R.id.launchYear)
        private val launchSuccessTV = itemView.findViewById<TextView>(R.id.launchSuccess)
        private val missionDetailsTV = itemView.findViewById<TextView>(R.id.details)

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