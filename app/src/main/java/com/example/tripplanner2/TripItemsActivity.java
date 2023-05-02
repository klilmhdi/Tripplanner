package com.example.tripplanner2;

//public class TripItemsActivity extends AppCompatActivity {
//
////    private TripDatabaseHelper mDbHelper;
////    private List<Trip> mTripList;
////    private TripListAdapter mTripListAdapter;
////    private ListView mListView;
////    private RelativeLayout mInfoLayout;
////    private TextView mTripNameTextView;
////    private TextView mDestinationTextView;
////    private TextView mTripDateTextView;
////
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.trip_list_item);
////
////        // Initialisation des vues
////        Toolbar toolbar = findViewById(R.id.toolbar);
////        setSupportActionBar(toolbar);
////        mListView = findViewById(R.id.list_view);
////        mInfoLayout = findViewById(R.id.info_layout);
////        mTripNameTextView = findViewById(R.id.trip_name);
////        mDestinationTextView = findViewById(R.id.destination);
////        mTripDateTextView = findViewById(R.id.trip_date);
////
////        // Initialisation de la base de données et récupération des voyages précédents
////        mDbHelper = new TripDatabaseHelper(this);
////        mTripList = mDbHelper.getAllTrips();
////
////        // Création de l'adapter pour la liste de voyages
////        mTripListAdapter = new TripListAdapter(this, mTripList);
////
////        // Ajout de l'adapter à la ListView
////        mListView.setAdapter(mTripListAdapter);
////
////        // Gestion du clic sur un élément de la ListView
////        mListView.setOnItemClickListener((parent, view, position, id) -> {
////            Trip trip = mTripList.get(position);
////            displayTripInfo(trip);
////        });
////
////        // Gestion du clic sur le bouton hamburger
////        ImageButton menuButton = findViewById(R.id.menu_button);
////        menuButton.setOnClickListener(v -> toggleListVisibility());
////
////        // Gestion du long clic sur un élément de la ListView pour le supprimer
////        mListView.setOnItemLongClickListener((parent, view, position, id) -> {
////            Trip trip = mTripList.get(position);
////            mDbHelper.deleteTrip(trip.getId());
////            mTripList.remove(trip);
////            mTripListAdapter.notifyDataSetChanged();
////            return true;
////        });
////
////        // Affichage du dernier voyage saisi par défaut
////        if (mTripList.size() > 0) {
////            Trip lastTrip = mTripList.get(mTripList.size() - 1);
////            displayTripInfo(lastTrip);
////        }
////    }
////
////    /**
////     * Affiche les informations du voyage donné dans le layout d'information.
////     *
////     * @param trip Le voyage à afficher.
////     */
////    private void displayTripInfo(Trip trip) {
////
////        mDestinationTextView.setText(trip.getLocation());
////
////        mTripDateTextView.setText(trip.getStartDate() + " - " + trip.getEndDate());
////        mInfoLayout.setVisibility(View.VISIBLE);
////    }
////
////    /**
////     * Affiche ou masque la liste des voyages précédents.
////     */
////    private void toggleListVisibility() {
////        if (mListView.getVisibility() == View.VISIBLE) {
////            mListView.setVisibility(View.GONE);
////            mInfoLayout.setVisibility(View.GONE);
////        } else {
////            mListView.setVisibility(View.VISIBLE);
////            mInfoLayout.setVisibility(View.GONE);
////        }
////    }
////
////    public TextView getmTripNameTextView() {
////        return mTripNameTextView;
////    }
////
////    public void setmTripNameTextView(TextView mTripNameTextView) {
////        this.mTripNameTextView = mTripNameTextView;
////    }
//}

//public class TripItemsActivity extends AppCompatActivity {
//    TripDatabaseHelper databaseHelper = new TripDatabaseHelper(this);
//    TripListAdapter tripListAdapter;
//    ListView listView;
//    // Insert an event
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_creat_trip);
//        tripListAdapter = new TripListAdapter(this, listView);
//        listView.setAdapter(tripListAdapter);
//
//        Button button = findViewById(R.id.nextButton);
//    }
//}
