package au.edu.unsw.infs3634.courseoutliner;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
//TODO  Implement the CourseAdapter class so that it integrates into the existing code base:
//      - The CourseAdapter must be connected to the RecyclerView in the MainActivity
//      - The CourseAdapter must use the course_item.xml layout file to display the list items
//      - The CourseAdapter's list items must be clickable to launch the DetailActivity
//      - The CourseAdapter's data must be modifiable during runtime
public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {
    private MainActivity mainActivity;
    private List<Course> mCourse;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Course course = (Course) v.getTag();
            Context context = v.getContext();
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra(DetailActivity.ARG_ITEM_ID, course.getId());
            context.startActivity(intent);
        }
    };
    public CourseAdapter(MainActivity MmainActivity, List<Course> courses){
        mainActivity = MmainActivity;
        mCourse = courses;
    }


    public class CourseViewHolder  extends  RecyclerView.ViewHolder{
        public TextView name, school, code;

        public CourseViewHolder(View v){
            super(v);
            name = v.findViewById(R.id.tvName);
            school = v.findViewById(R.id.tvSchool);
            code = v.findViewById(R.id.tvCode);
        }
    }

    @Override
    public CourseAdapter.CourseViewHolder onCreateViewHolder(ViewGroup mainActivity, int viewType){
        View v = LayoutInflater.from(mainActivity.getContext()).inflate(R.layout.course_item, mainActivity, false);
        return  new CourseViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CourseViewHolder holder, int position){
        Course course = mCourse.get(position);
        holder.name.setText(course.getName());
        holder.school.setText(course.getSchool());
        holder.school.setText(course.getCode());
    }

    @Override
    public int getItemCount() {
        return mCourse.size();
    }

    public void setCourse(List<Course> course){
        mCourse.clear();;
        mCourse.addAll(course);
        notifyDataSetChanged();
    }

    public class CourseClickListener {
    }
}
