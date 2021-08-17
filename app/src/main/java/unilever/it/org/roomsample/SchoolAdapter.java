package unilever.it.org.roomsample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import unilever.it.org.roomsample.entities.JoinSchoolClassData;

public class SchoolAdapter extends RecyclerView.Adapter<SchoolAdapter.ViewHolder> {
    Context context;
    List<JoinSchoolClassData> joinSchoolClassDataList;


    public SchoolAdapter(Context context, List<JoinSchoolClassData> joinSchoolClassDataList) {
        this.context = context;
        this.joinSchoolClassDataList = joinSchoolClassDataList;
    }


    @Override
    public SchoolAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from( context ).inflate(R.layout.school_list_item,parent,false);
        return new SchoolAdapter.ViewHolder(view);
    }
   public void changeData(List<JoinSchoolClassData> list){
        this.joinSchoolClassDataList=list;
        notifyDataSetChanged();
    }
    @Override
    public void onBindViewHolder(@NonNull SchoolAdapter.ViewHolder holder, final int position) {
        JoinSchoolClassData joinSchoolClassData=joinSchoolClassDataList.get( position );
        String schoolName=joinSchoolClassData.getSchoolName();
        String className=joinSchoolClassData.getClassName();

        holder.schoolName.setText(schoolName);
        holder.className.setText(className);


    }

    @Override
    public int getItemCount() {
        return joinSchoolClassDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView schoolName;
        private TextView className;


        public ViewHolder(View itemView) {
            super( itemView );
            schoolName=itemView.findViewById( R.id.txtSchoolName);
            className=itemView.findViewById(R.id.txt_className);


        }
    }
}
