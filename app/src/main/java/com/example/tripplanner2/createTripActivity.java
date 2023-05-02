package com.example.tripplanner2;
//        private EditText mStartDateEditText;
//        private EditText mEndDateEditText;
//        private Button mNextButton;
//
//        private EditText mLocationEditText ;
//
//        private final Calendar mCalendar = Calendar.getInstance();
//
//        private final DatePickerDialog.OnDateSetListener mStartDateListener = (view, year, month, dayOfMonth) -> {
//            mCalendar.set(Calendar.YEAR, year);
//            mCalendar.set(Calendar.MONTH, month);
//            mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
//            updateStartDateEditText();
//        };
//
//
//
//
//
//
//    private final DatePickerDialog.OnDateSetListener mEndDateListener = (view, year, month, dayOfMonth) -> {
//        mCalendar.set(Calendar.YEAR, year);
//        mCalendar.set(Calendar.MONTH, month);
//        mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
//        updateEndDateEditText();
//    };
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_creat_trip);
//
//        mStartDateEditText = findViewById(R.id.startDateEditText);
//        mEndDateEditText = findViewById(R.id.endDateEditText);
//         mLocationEditText = findViewById(R.id.locationEditText);
//        mNextButton =findViewById(R.id.nextButton);
//        mNextButton.setOnClickListener(v -> {
//            // ya
//            // Récupérer les valeurs saisies par l'utilisateur
//            String location = mLocationEditText.getText().toString();
//            String startDate = mStartDateEditText.getText().toString();
//            String endDate = mEndDateEditText.getText().toString();
//
//            // Créer une instance de Trip
//            TripModel newTripModel = new TripModel(1, "null", "null", "null");
//            newTripModel.setLocation(location);
//            newTripModel.setStartDate(startDate);
//            newTripModel.setEndDate(endDate);
//            insertData(newTripModel);
//
//        });
//
//
//        mStartDateEditText.setOnClickListener(v -> new DatePickerDialog(createTripActivity.this, mStartDateListener,
//                mCalendar.get(Calendar.YEAR), mCalendar.get(Calendar.MONTH),
//                mCalendar.get(Calendar.DAY_OF_MONTH)).show());
//
//        mEndDateEditText.setOnClickListener(v -> new DatePickerDialog(createTripActivity.this, mEndDateListener,
//                mCalendar.get(Calendar.YEAR), mCalendar.get(Calendar.MONTH),
//                mCalendar.get(Calendar.DAY_OF_MONTH)).show());
//
//        mLocationEditText.setOnClickListener(v -> {
//            // Récupérer la liste des pays à partir des ressources
//            String[] countries = getResources().getStringArray(R.array.countries_array);
//
//            // Créer une boîte de dialogue avec une liste de choix pour les pays
//            AlertDialog.Builder builder = new AlertDialog.Builder(this);
//            builder.setTitle("Select Country");
//
//            // Ajouter une zone de recherche
//            final EditText searchEditText = new EditText(this);
//            searchEditText.setHint("Search Country");
//            builder.setView(searchEditText);
//
//            // Ajouter la liste de choix
//            builder.setItems(countries, (dialog, which) -> {
//                String selectedCountry =countries[which];
//                mLocationEditText.setText(selectedCountry);
//            });
//
//            // Afficher la boîte de dialogue
//            AlertDialog dialog = builder.create();
//            dialog.show();
//        });
//
//
//
//
//
//
//    }
//    @SuppressLint("StaticFieldLeak")
//    private void insertData(TripModel newTripModel) {
//        new AsyncTask<Void, Void, Void>() {
//
//            @Override
//            protected Void doInBackground(Void... voids) {
//                // Insérer le nouveau voyage dans la base de données en utilisant TripDao
//                TripDatabase db = TripDatabase.getInstance(getApplicationContext());
//                TripDao tripDao = db.tripDao();
//                tripDao.insert(newTripModel);
//
//
//                return null;
//            }
//
//            @Override
//            protected void onPostExecute(Void aVoid) {
//                // Update the UI if necessary
//                // Lancer l'activité TripItemActivity
//                               Intent intent = new Intent(createTripActivity.this, TripItemsActivity.class);
//                               startActivity(intent);
//            }
//        }.execute();
//    }
//
//
//
//
//    private void updateStartDateEditText() {
//        @SuppressLint("DefaultLocale") String startDate = String.format("%02d/%02d/%d",
//                mCalendar.get(Calendar.DAY_OF_MONTH),
//                mCalendar.get(Calendar.MONTH) + 1,
//                mCalendar.get(Calendar.YEAR));
//        mStartDateEditText.setText(startDate);
//    }
//
//    private void updateEndDateEditText() {
//        @SuppressLint("DefaultLocale") String endDate = String.format("%02d/%02d/%d",
//                mCalendar.get(Calendar.DAY_OF_MONTH),
//                mCalendar.get(Calendar.MONTH) + 1,
//                mCalendar.get(Calendar.YEAR));
//        mEndDateEditText.setText(endDate);
//    }
//
//    public void setmNextButton(Button mNextButton) {
//        this.mNextButton = mNextButton;
//    }
//
//    public void setmLocationEditText(EditText mLocationEditText) {
//        this.mLocationEditText = mLocationEditText;
//    }
//
//    public EditText getmLocationEditText() {
//        return mLocationEditText;
//    }

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class createTripActivity extends AppCompatActivity {
    Button addBtn;
    // Button showBtn;
    EditText nameFieldEdit, startFieldEdit, endFieldEdit, locationFieldEdit;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creat_trip);
        addBtn = findViewById(R.id.nextButton);
        startFieldEdit = findViewById(R.id.startDateEditText);
        nameFieldEdit = findViewById(R.id.nameTripEditText);
        endFieldEdit = findViewById(R.id.endDateEditText);
        locationFieldEdit = findViewById(R.id.locationEditText);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TripModel model;
                try {
                    model = new TripModel(-1, "hello", locationFieldEdit.getText().toString(), startFieldEdit.getText().toString(), endFieldEdit.getText().toString());
                    Toast.makeText(createTripActivity.this, "Successfully", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    model = new TripModel(-1, "hello", "wrong", "wrong", "wrong");
                    Toast.makeText(createTripActivity.this, "Write an empty field!!!", Toast.LENGTH_SHORT).show();
                }
                TripDatabaseHelper helper = new TripDatabaseHelper(createTripActivity.this);
                boolean success = helper.insert(model);
                Toast.makeText(createTripActivity.this, "Successfully= " + model.getLocation(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}