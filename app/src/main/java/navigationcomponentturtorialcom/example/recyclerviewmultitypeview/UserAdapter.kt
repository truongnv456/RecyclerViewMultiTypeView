package navigationcomponentturtorialcom.example.recyclerviewmultitypeview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private val mListUser: List<User>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_USER_FEATURED = 1
        private const val TYPE_USER_NORMAL = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            TYPE_USER_FEATURED -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_user_featured, parent, false)
                return UserFeatureViewHolder(view)
            }

            TYPE_USER_NORMAL -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_user_normal, parent, false)
                return UserNormalViewHolder(view)
            }
            else -> {
                throw IllegalArgumentException("Invalid view type: $viewType")
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder.itemViewType == TYPE_USER_FEATURED) {
            val userFeatureViewHolder = holder as UserFeatureViewHolder
            userFeatureViewHolder.imgUserFeatured?.setImageResource(mListUser[position].resourceId)
            userFeatureViewHolder.tvUserNameFeatured?.text = mListUser[position].name
            Log.d("CheckData", "User Feature Success")
        } else if (holder.itemViewType == TYPE_USER_NORMAL) {
            val userNormalViewHolder = holder as UserNormalViewHolder
            userNormalViewHolder.imgUserNormal?.setImageResource(mListUser[position].resourceId)
            userNormalViewHolder.tvUserNameNormal?.text = mListUser[position].name
            Log.d("CheckData", "User Normal Success")

        }
    }

    override fun getItemCount(): Int {
        return mListUser.size
    }

    override fun getItemViewType(position: Int): Int {
        val user: User = mListUser[position]
        if (user.isFeatured) {
            return TYPE_USER_FEATURED
        } else {
            return TYPE_USER_NORMAL
        }
    }

    inner class UserFeatureViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgUserFeatured: ImageView? = null
        var tvUserNameFeatured: TextView? = null

        init {
            imgUserFeatured = itemView.findViewById(R.id.img_user_featured)
            tvUserNameFeatured = itemView.findViewById(R.id.tv_user_name_featured)
        }
    }

    inner class UserNormalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgUserNormal: ImageView? = null
        var tvUserNameNormal: TextView? = null

        init {
            imgUserNormal = itemView.findViewById(R.id.img_user_normal)
            tvUserNameNormal = itemView.findViewById(R.id.tv_user_name_normal)
        }
    }
}