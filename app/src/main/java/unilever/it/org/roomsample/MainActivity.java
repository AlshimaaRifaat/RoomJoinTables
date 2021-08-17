package unilever.it.org.roomsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.RoomDatabase;

import android.os.Bundle;

import java.util.List;
import java.util.Locale;

import unilever.it.org.roomsample.database.AppDatabase;
import unilever.it.org.roomsample.database.DataInitializer;
import unilever.it.org.roomsample.entities.JoinSchoolClassData;

public class MainActivity extends AppCompatActivity {
   private SchoolAdapter mAdapter;
    private RecyclerView mRecyclerView;
 // private AppCompatTextView mDataappCompatTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        AppDatabase appDatabase = AppDatabase.getINSTANCE(MainActivity.this);
        DataInitializer.AddSampleDataAsync(appDatabase);
      mAdapter = new SchoolAdapter(getApplicationContext(),null);
      mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mRecyclerView.setAdapter(mAdapter);
        List<JoinSchoolClassData> data= appDatabase.schoolDao()
                .getSchoolCLassData();
        if(data!=null)
        mAdapter.changeData(data);
       /* List<JoinSchoolClassData> joinSchoolClassStudentData = appDatabase.schoolDao().getSchoolCLassData();
        showJoinData(joinSchoolClassStudentData);*/

    }

  /*  public void showJoinData(List<JoinSchoolClassData> joinSchoolClassData) {
        StringBuilder sb = new StringBuilder();
        for (JoinSchoolClassData joinSchoolClassData1 : joinSchoolClassData) {
            sb.append(String.format(Locale.US,
                    "School name :  %s, Class name : %s,\n\n", joinSchoolClassData1.getSchoolName(), joinSchoolClassData1.getClassName()));
        }
        mDataappCompatTextView.setText(String.format("\n \n%s%s", sb.toString(), mDataappCompatTextView.getText()));
    }*/
    private void init()
    {
       mRecyclerView=findViewById(R.id.rv_schools);
       // mDataappCompatTextView = findViewById(R.id.AM_data);
    }
}