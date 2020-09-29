package com.example.learndiseaseapp;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.learndiseaseapp.Model.Diseases;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class DiseaseDetail extends AppCompatActivity {

    TextView disease_name, disease_description, disease_symptoms;
    ImageView disease_image;
    CollapsingToolbarLayout collapsingToolbarLayout;

    String diseaseId="";

    FirebaseDatabase database;
    DatabaseReference diseases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease_detail);

        database = FirebaseDatabase.getInstance();
        diseases = database.getReference("Diseases");

        disease_name = (TextView) findViewById(R.id.txt_diseaseName);
        disease_description = (TextView)findViewById(R.id.txt_disease_description);
        disease_image = (ImageView) findViewById(R.id.img_disease);
        disease_symptoms = (TextView)findViewById(R.id.txt_disease_Symptoms);


        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppbar);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppbar);

        if(getIntent() !=null)
            diseaseId = getIntent().getStringExtra("DiseaseId");
        if(!diseaseId.isEmpty()){
            getDetailsDisease(diseaseId);
        }


    }

    private void getDetailsDisease(String diseaseId) {
diseases.child(diseaseId).addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        Diseases disease = dataSnapshot.getValue(Diseases.class);

        Picasso.with(getBaseContext()).load(disease.getImage()).into(disease_image);
        collapsingToolbarLayout.setTitle(disease.getName());
        disease_name.setText(disease.getName());
        disease_description.setText(disease.getDescription());
        disease_symptoms.setText(disease.getSymptoms());
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
});
    }
}
