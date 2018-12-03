package com.example.asus.newpracticedesign;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DataView extends AppCompatActivity {

    TextView tv_firstName, tv_LastName, tv_idNo, tv_upi, tv_birthCertificateNumber, tv_dateofBirth,
            tv_gender, tv_nationality, tv_class, tv_subject, tv_position, tv_mobileNumber ,tv_contract
            , tv_startdate, tv_enddate
            ,tv_addexpInfo, tv_institutionName, tv_startDate, tv_endDate, tv_teachingLevel
            ,tv_sub
            ,tv_teachingRoles, tv_addrolesInfo
            ,tv_addinfo, tv_otherinfo;

    LinearLayout layoutsub_roles;

    SharedPreferences shared,sharedPreferences;
    int size =0;
    int size1 = 0;
    int size_addroles = 0;
    int size_rolessub = 0, size_addinfo=0;
    int[] sizesub;
    List<Model.AddExperienceBean> addExperienceBeans;
    List<Model.AddExperienceBean.AddSubTaughtBean> addSubTaughtBeans;

    Model model ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_view);
        //to get data from model class

        addExperienceBeans = new ArrayList<>();

        model= (Model) getIntent().getExtras().get("Data");
        addExperienceBeans = (List<Model.AddExperienceBean>) getIntent().getExtras().getSerializable("data");
        addSubTaughtBeans = (List<Model.AddExperienceBean.AddSubTaughtBean>)getIntent().getExtras().getSerializable("expsub");

        tv_firstName = (TextView)findViewById(R.id.tv_firstName);
        tv_LastName = (TextView)findViewById(R.id.tv_LastName);
        tv_idNo = (TextView)findViewById(R.id.tv_idNo);
        tv_upi = (TextView)findViewById(R.id.tv_upi);
        tv_birthCertificateNumber = (TextView)findViewById(R.id.tv_birthCertificateNumber);
        tv_dateofBirth = (TextView)findViewById(R.id.tv_dateofBirth);
        tv_gender = (TextView)findViewById(R.id.tv_gender);
        tv_nationality = (TextView)findViewById(R.id.tv_nationality);
        tv_class = (TextView)findViewById(R.id.tv_class);
        tv_subject = (TextView)findViewById(R.id.tv_subject);
        tv_position = (TextView)findViewById(R.id.tv_position);
        tv_mobileNumber = (TextView)findViewById(R.id.tv_mobileNumber);
        tv_contract = (TextView)findViewById(R.id.tv_contract);
        tv_startdate = (TextView)findViewById(R.id.tv_startdate);
        tv_enddate = (TextView)findViewById(R.id.tv_enddate);

        shared = getApplicationContext().getSharedPreferences("MainActivity",MODE_PRIVATE);
        //sharedPreferences = getApplicationContext().getSharedPreferences("MainActivity",MODE_PRIVATE);
//
         size = shared.getInt("array_size", 0);
             size1 = shared.getInt("array_size1", 0);
//
//        String[] arrayInstitutionName = new String[size];
//        String[] arrayStartdate = new String[size];
//        String[] arrayEndDate = new String[size];
//        String[] arrayTeachingLevel = new String[size];
//        String[][] arraysub = new String[size][size];
//        for(int i=0; i<size; i++){
//         arrayInstitutionName[i] =   shared.getString("arrayInstitutionName_" + i, null);
//            arrayStartdate[i] =   shared.getString("arrayStartdate_" + i, null);
//            arrayEndDate[i] =   shared.getString("arrayEndDate_" + i, null);
//            arrayTeachingLevel[i] =   shared.getString("arrayTeachingLevel_" + i, null);
//            for (int j =0;j<size1;j++){
//                arraysub[i][j] = shared.getString("arraysub_" + i+j,null);
//            }
//        }

//       tv_firstName.setText(shared.getString("firstName",null));
//        tv_LastName.setText(shared.getString("lastName",null));
//        tv_idNo.setText(shared.getString("idNo",null));
//        tv_upi.setText(shared.getString("upi",null));
//        tv_birthCertificateNumber.setText(shared.getString("birthcertificate",null));
//        tv_dateofBirth.setText(shared.getString("dob",null));
//        tv_gender.setText(shared.getString("gender",null));
//        tv_nationality.setText(shared.getString("nationality",null));
//        tv_class.setText(shared.getString("spinner_class",null));
//        tv_subject.setText(shared.getString("subject",null));
//        tv_position.setText(shared.getString("position",null));
//        tv_mobileNumber.setText(shared.getString("mobileNumber",null));
//        tv_contract.setText(shared.getString("contract",null));
//        tv_startdate.setText(shared.getString("startdate",null));
//        tv_enddate.setText(shared.getString("enddate",null));


        //experience info

        tv_firstName.setText(model.getFirst_name());
        tv_LastName.setText(model.getLast_name());
        tv_idNo.setText(String.valueOf(model.getId_no()));
        tv_upi.setText(String.valueOf(model.getUpi_no()));
        tv_birthCertificateNumber.setText(String.valueOf(model.getBirth_certificate_number()));
        tv_dateofBirth.setText(model.getDate_of_birth());
        tv_gender.setText(model.getGender());
        tv_nationality.setText(model.getNationality());
        tv_class.setText(model.getClassX());
        tv_subject.setText(model.getSubject());
        tv_position.setText(model.getPosition());
        tv_mobileNumber.setText(String.valueOf(model.getMobile_number()));
        tv_contract.setText(String.valueOf(model.getContract()));
        tv_startdate.setText(model.getStart_date());
        tv_enddate.setText(model.getEnd_date());


        LinearLayout addexplayout = (LinearLayout)findViewById(R.id.addexplayout);
        //final View hiddenInfo = getLayoutInflater().inflate(R.layout.textview,addexplayout,false);
        for (int i=0; i<size ;i++ ){
            final View add_subjectView = getLayoutInflater().inflate(R.layout.textview,addexplayout,false);
            addexplayout.addView(add_subjectView);

            int m[] = new int[size];
            m[i] = i+1;

            tv_addexpInfo = (TextView) (addexplayout.getChildAt(i)).findViewById(R.id.tv_addexpInfo);
            tv_addexpInfo.setText(String.valueOf(m[i]));
            ArrayList<String> list = new ArrayList<>();

            List<Model.AddExperienceBean> list1 = new ArrayList<>();

            Model.AddExperienceBean data = new Model.AddExperienceBean();
//            list.add(addExperienceBeans.get(i).getInstitution_name());
//            list.add(addExperienceBeans.get(i).getStart_date());
//            list.add(addExperienceBeans.get(i).getEnd_date());
//            list.add(addExperienceBeans.get(i).getTeaching_level());
             tv_institutionName = (TextView) (addexplayout.getChildAt(i)).findViewById(R.id.tv_institutionName);
                tv_startDate = (TextView) (addexplayout.getChildAt(i)).findViewById(R.id.tv_startDate);
                tv_endDate = (TextView) (addexplayout.getChildAt(i)).findViewById(R.id.tv_endDate);
                tv_teachingLevel = (TextView) (addexplayout.getChildAt(i)).findViewById(R.id.tv_TeachingLevel);

                tv_institutionName.setText(addExperienceBeans.get(i).getInstitution_name());
            tv_startDate.setText(addExperienceBeans.get(i).getStart_date());
            tv_endDate.setText(addExperienceBeans.get(i).getEnd_date());
            tv_teachingLevel.setText(addExperienceBeans.get(i).getTeaching_level());

            int count[] = new int[size];
             count[i] = shared.getInt("count" + i,0);
            if (count[i] >0) {
                for (int k = 0; k < count[i]; k++) {
                    LinearLayout add_subjectlayout = (LinearLayout) add_subjectView.findViewById(R.id.layoutsub);
                    final View add_subject = getLayoutInflater().inflate(R.layout.textview2, add_subjectlayout, false);
                    add_subjectlayout.addView(add_subject);
                    tv_sub = (TextView) (add_subjectlayout.getChildAt(k)).findViewById(R.id.tv_sub);
                    tv_sub.setText(addSubTaughtBeans.get(k).getSubject());
                    //   tv_sub.setText(arraysub[i][k]);
                    // Log.e("arraysub"+i+k,arraysub[i][k]);
                }
            }
            if (i == size-1){
                SharedPreferences.Editor editor = shared.edit();
                editor.remove("array_size");
                editor.remove("array_size1");
                editor.apply();
            }
        }


        //roles and subject
         size_addroles = shared.getInt("array_size_addroles", 0);
        Log.e("size_addroles",String.valueOf(size_addroles));
         size_rolessub = shared.getInt("array_roles_sub_size1", 0);
        Log.e("size_rolessub",String.valueOf(size_rolessub));

         sizesub = new int[size_addroles];
        for (int i=0; i< size_addroles; i++){
            sizesub[i] = shared.getInt("subsize" + i,0);
        }

        String[] arrayspinnerroles = new String[size_addroles];
        String[][] array_rolessub = new String[size_addroles][size_rolessub];

        for(int i=0; i<size_addroles; i++){
            arrayspinnerroles[i] =   shared.getString("spinnerroles_" + i, null);
            for (int j =0;j<size_rolessub;j++){
                array_rolessub[i][j] = shared.getString("arrayrolessub_" + i + j,null);
                Log.e("array_rolessub"+i+j,array_rolessub[i][j]);
            }
        }
        LinearLayout addroleslayout = (LinearLayout)findViewById(R.id.addroleslayout);
        for (int i=0; i<size_addroles ;i++ ){
            final View add_subjectView = getLayoutInflater().inflate(R.layout.teching_roles_textview,addroleslayout,false);
            addroleslayout.addView(add_subjectView);
            int m[] = new int[size_addroles];
            m[i] = i+1;

            tv_addrolesInfo = (TextView) (addroleslayout.getChildAt(i)).findViewById(R.id.tv_addrolesInfo);
            tv_addrolesInfo.setText(String.valueOf(m[i]));


                tv_teachingRoles = (TextView) (addroleslayout.getChildAt(i)).findViewById(R.id.tv_teachingRoles);
//                Log.e("arrayspinnerroles"+j,arrayspinnerroles[j]);
                tv_teachingRoles.setText(arrayspinnerroles[i]);

                if (sizesub[i]>0) {
                    for (int k = 0; k < size_rolessub; k++) {
                         layoutsub_roles = (LinearLayout) add_subjectView.findViewById(R.id.layoutsub_roles);
                        final View add_subject = getLayoutInflater().inflate(R.layout.textview2, layoutsub_roles, false);
                        layoutsub_roles.addView(add_subject);
                        tv_sub = (TextView) (layoutsub_roles.getChildAt(k)).findViewById(R.id.tv_sub);
                        tv_sub.setText(array_rolessub[i][k]);
                        //  Log.e("array_rolessub"+i+k,array_rolessub[i][k]);
                    }
                }

            if (i == size_addroles-1){
                SharedPreferences.Editor editor = shared.edit();
                editor.remove("array_size_addroles");
                editor.remove("array_roles_sub_size1");
                editor.apply();
            }
        }



        //additional information
        size_addinfo = shared.getInt("array_addinfo_size", 0);

        String[] array_otherinfo = new String[size_addinfo];
        for(int i=0; i<size_addinfo; i++){
            array_otherinfo[i] =   shared.getString("arrayAdditionalInfo_" + i, null);
        }
        LinearLayout addinfolayout = (LinearLayout)findViewById(R.id.addinfolayout);
        //final View hiddenInfo = getLayoutInflater().inflate(R.layout.textview,addexplayout,false);
        for (int i=0; i<size_addinfo ;i++ ){
            final View add_subjectView = getLayoutInflater().inflate(R.layout.textview_addinfo,addinfolayout,false);
            addinfolayout.addView(add_subjectView);


            for (int j=0; j<addinfolayout.getChildCount();j++){

                tv_otherinfo = (TextView) (addinfolayout.getChildAt(j)).findViewById(R.id.tv_otherinfo);
                tv_otherinfo.setText(array_otherinfo[j]);
            }
            if (i == size_addinfo-1){
                SharedPreferences.Editor editor = shared.edit();
                editor.remove("array_addinfo_size");
                editor.apply();
            }
        }

        SharedPreferences.Editor editor = shared.edit();
        editor.clear();
        editor.apply();



    }
}
