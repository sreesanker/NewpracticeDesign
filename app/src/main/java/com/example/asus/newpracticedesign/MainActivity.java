package com.example.asus.newpracticedesign;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    android.support.v7.widget.Toolbar toolbar;
    AppBarLayout appBar;

   String name;

    EditText edt_firstName, edt_lastName, edt_idNo, edt_upi, edt_birthCertificateNumber, edt_dateOfBirth,
            edt_nationality, edt_subject, edt_position, edt_mobileNumber, edt_contract, edt_startDate, edt_endDate,
            edt_expInstitutionName, edt_expStartDate, edt_expEndDate, edt_expTeachingLevel,
            edt_subject_addexp
            ,edt_addInfo;

    EditText edt_subject_addroles;

    EditText edt_addsubtaught;

    RadioGroup rg_gender;
    RadioButton rb_gender;
    Spinner spinnerClass, spinner_Roles_Subject;
    int pos = 0, c =0 ;

    ImageButton button_addExperience, button_addTeachingRoles, button_addOtherinfo;

    Button submitButton;

    SharedPreferences shared, sharedPreferences ;

    String spinner_class, expInstitutionName, expStartDate, expEndDate;

    Model model = new Model();

    List<Model.AddExperienceBean> addExperienceBeans;
    List<Model.AddExperienceBean.AddSubTaughtBean> addSubTaughtBeans;

    String[] spinner_roles ;
     LinearLayout layout_expInfo, layout_teachingRoles, layout_addSubTaught, layout_otherInfo, layout_addroleSub;

     ArrayList<Spinner> spinnerList=new ArrayList<Spinner>();
    ArrayList<Model> models = new ArrayList<Model>();
    ArrayList<EditText> addexpedit_instname = new ArrayList<>();
    ArrayList<EditText> addexpedit_startdate = new ArrayList<>();
    ArrayList<EditText> addexpedit_enddate = new ArrayList<>();
    ArrayList<EditText> addexpedit_teachinglevel = new ArrayList<>();
    ArrayList<ArrayList<EditText>> mailexpList = new ArrayList<>();
    ArrayList<String> edtvalue = new ArrayList<>();

     static int count_addexp, count_addexp_sub, count_addroles, count_addroles_sub, count_addinfo;
    private SharedPreferences.Editor editor;

    DatePickerDialog datePickerDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shared = getApplicationContext().getSharedPreferences("MainActivity",MODE_PRIVATE);
         editor = shared.edit();
        //sharedPreferences = getApplicationContext().getSharedPreferences("MainActivity",MODE_PRIVATE);
        spinnerList.clear();
        addexpedit_teachinglevel.clear();
//        addroleSubList.clear();
//        mainsubList.clear();
        appBar = (AppBarLayout)findViewById(R.id.appBar);
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolBar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //Edit text declaration
        edt_firstName = (EditText)findViewById(R.id.edt_firstName);
        edt_lastName = (EditText)findViewById(R.id.edt_lastName);
        edt_idNo = (EditText)findViewById(R.id.edt_idNo);
        edt_upi = (EditText)findViewById(R.id.edt_upi);
        edt_birthCertificateNumber = (EditText)findViewById(R.id.edt_birthCiertificateNumber);
        edt_dateOfBirth = (EditText)findViewById(R.id.edt_dateOfBirth);
        edt_nationality = (EditText)findViewById(R.id.edt_nationality);
        edt_subject = (EditText)findViewById(R.id.edt_subject);
        edt_position = (EditText)findViewById(R.id.edt_position);
        edt_mobileNumber = (EditText)findViewById(R.id.edt_mobileNumber);
        edt_contract = (EditText)findViewById(R.id.edt_contract);
        edt_startDate = (EditText)findViewById(R.id.edt_startDate);
        edt_endDate = (EditText)findViewById(R.id.edt_endDate);

        rg_gender = (RadioGroup)findViewById(R.id.rg_gender);

        edt_dateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        edt_dateOfBirth.setText(dayOfMonth+"-"+(month+1)+"-"+year);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

        edt_startDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        edt_startDate.setText(dayOfMonth+"-"+(month+1)+"-"+year);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

        edt_endDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        edt_endDate.setText(dayOfMonth+"-"+(month+1)+"-"+year);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

        spinnerClass = (Spinner)findViewById(R.id.spinner_class);

        //String array
        String[] class_array = new String[]{"Class.*",
                "Class 1","Class 2","Class 3","Class 4","Class 5","Class 6",
                "Class 7","Class 8","Class 9","Class 10","Class 11","Class 12" };

        List<String> classList = new ArrayList<>(Arrays.asList(class_array));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.spinner_item,
                classList){
            @Override
            public boolean isEnabled(int position){
                if(position == 0)
                {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                }
                else
                {
                    return true;
                }
            }
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){
                    // Set the hint text color gray
                    tv.setTextColor(Color.BLACK);
                }
                else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };

        adapter.setDropDownViewResource(R.layout.spinner_item);
        spinnerClass.setAdapter(adapter);

        spinnerClass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position > 0) {
                    // Notify the selected item text
                    spinner_class = spinnerClass.getSelectedItem().toString();
                    model.setClassX(spinner_class);
                    Toast.makeText
                            (getApplicationContext(), "Select", Toast.LENGTH_SHORT)
                            .show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        button_addExperience = (ImageButton) findViewById(R.id.button_addExperience);
        button_addExperience.setOnClickListener(this);

        button_addTeachingRoles = (ImageButton) findViewById(R.id.button_addTeachingRoles);
        button_addTeachingRoles.setOnClickListener(this);

        button_addOtherinfo = (ImageButton) findViewById(R.id.button_addOtherinfo);
        button_addOtherinfo.setOnClickListener(this);

        submitButton = (Button)findViewById(R.id.submitButton);
        submitButton.setOnClickListener(this);

        }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_addExperience) {
//             layout_expInfo = (LinearLayout) findViewById(R.id.layout_expInfo);
//
//                 final View hiddenInfo = getLayoutInflater().inflate(R.layout.add_experience_row_details, layout_expInfo, false);
//                 layout_expInfo.addView(hiddenInfo);
//            count_addexp = layout_expInfo.getChildCount();
//
//            //edt_expInstitutionName = (EditText)layout_expInfo.findViewById(R.id.edt_expInstitutionName);
//           // edt_expStartDate = (EditText)layout_expInfo.findViewById(R.id.edt_expStartDate);
//           // edt_expEndDate = (EditText)layout_expInfo.findViewById(R.id.edt_expEndDate);
//           // SharedPreferences.Editor editor = sharedPreferences.edit();
//
//
//
//                // expInstitutionName = edt_expInstitutionName.getText().toString().trim();
////            expStartDate = edt_expStartDate.getText().toString().trim();
//  //          expEndDate = edt_expEndDate.getText().toString().trim();
//
//
//                 ImageButton removeExpInfo = hiddenInfo.findViewById(R.id.ib_removeExpInfo);
//                 removeExpInfo.setOnClickListener(new View.OnClickListener() {
//                     @Override
//                     public void onClick(View v) {
//                         layout_expInfo.removeView(hiddenInfo);
//                         count_addexp--;
//                     }
//                 });
//
//                 ImageButton ib_addSubjectTaught = hiddenInfo.findViewById(R.id.ib_addSubjectTaught);
//                 ib_addSubjectTaught.setOnClickListener(new View.OnClickListener() {
//                     @Override
//                     public void onClick(View v) {
//                         layout_addSubTaught = (LinearLayout) hiddenInfo.findViewById(R.id.layout_addSubTaught);
//                         final View add_subjectView = getLayoutInflater().inflate(R.layout.add_subjects_row_details, layout_addSubTaught, false);
//                         layout_addSubTaught.addView(add_subjectView, layout_addSubTaught.getChildCount() - 1);
//                         count_addexp_sub = layout_addSubTaught.getChildCount();
//
//                         ImageButton ib_removeSubjectTaught = (ImageButton) add_subjectView.findViewById(R.id.ib_removeSubjectTaught);
//                         ib_removeSubjectTaught.setOnClickListener(new View.OnClickListener() {
//                             @Override
//                             public void onClick(View v) {
//                                 layout_addSubTaught.removeView(add_subjectView);
//                                 count_addexp_sub--;
//                             }
//                         });
//                     }
//                 });
            addExperience();

        } else if (v.getId() == R.id.button_addTeachingRoles) {
//            layout_teachingRoles = (LinearLayout) findViewById(R.id.layout_teachingRoles);
//            final View hiddenInfo = getLayoutInflater().inflate(R.layout.add_teaching_roles_details,layout_teachingRoles,false);
//            layout_teachingRoles.addView(hiddenInfo);
//            count_addroles = layout_teachingRoles.getChildCount();
//
//            spinner_Roles_Subject = (Spinner)hiddenInfo.findViewById(R.id.spinnerRoles) ;
//            spinnerList.add(spinner_Roles_Subject);
//
//            //String array
//            String[] class_array = new String[]{"Role",
//                    "Class 1","Class 2","Class 3","Class 4","Class 5","Class 6",
//                    "Class 7","Class 8","Class 9","Class 10","Class 11","Class 12" };
//
//            List<String> rolesList = new ArrayList<>(Arrays.asList(class_array));
//
//            ArrayAdapter<String> adapterroles = new ArrayAdapter<String>(this,R.layout.spinner_item,
//                    rolesList){
//                @Override
//                public boolean isEnabled(int position){
//                    if(position == 0)
//                    {
//                        // Disable the first item from Spinner
//                        // First item will be use for hint
//                        return false;
//                    }
//                    else
//                    {
//                        return true;
//                    }
//                }
//                @Override
//                public View getDropDownView(int position, View convertView,
//                                            ViewGroup parent) {
//                    View view = super.getDropDownView(position, convertView, parent);
//                    TextView tv = (TextView) view;
//                    if(position == 0){
//                        // Set the hint text color gray
//                        tv.setTextColor(Color.BLACK);
//                    }
//                    else {
//                        tv.setTextColor(Color.BLACK);
//                    }
//                    return view;
//                }
//            };
//
//            adapterroles.setDropDownViewResource(R.layout.spinner_item);
//            spinner_Roles_Subject.setAdapter(adapterroles);
//
//
//
//            ImageButton removeRoles_Subject = hiddenInfo.findViewById(R.id.ib_removeRoles_Subject);
//            removeRoles_Subject.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    layout_teachingRoles.removeView(hiddenInfo);
//                    count_addroles--;
//                }
//            });
//
//            int[] mainsize = new int[count_addroles];
//            final int[][] subsize = new int[count_addroles][count_addroles_sub];
//
//            ImageButton ib_addSubjectTaught = hiddenInfo.findViewById(R.id.ib_addSubjectTaught);
//            ib_addSubjectTaught.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    layout_addroleSub = (LinearLayout) hiddenInfo.findViewById(R.id.layout_addroleSub);
//                    final View add_subjectView = getLayoutInflater().inflate(R.layout.add_subjects_row_details, layout_addroleSub, false);
//                    layout_addroleSub.addView(add_subjectView);
//                    count_addroles_sub = layout_addroleSub.getChildCount();
//                    edt_subject_addroles = (EditText) add_subjectView.findViewById(R.id.edt_subject_addexp);
//                    ImageButton ib_removeSubjectTaught = (ImageButton) add_subjectView.findViewById(R.id.ib_removeSubjectTaught);
//                    ib_removeSubjectTaught.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            layout_addroleSub.removeView(add_subjectView);
//                            count_addroles_sub--;
//                            pos--;
//                        }
//                    });
//                    // pos = layout_addroleSub.indexOfChild(layout_teachingRoles)+1;
//                    //addroleSubList.add(edt_subject_addroles);
//                    pos++;
//                }
//            });
//            //mainsubList.add(addroleSubList);
            addTechingRoles();
        } else if (v.getId() == R.id.button_addOtherinfo) {
            layout_otherInfo = (LinearLayout) findViewById(R.id.layout_otherInfo);
            final View hiddenInfo = getLayoutInflater().inflate(R.layout.add_otherinfo_details, layout_otherInfo, false);
            layout_otherInfo.addView(hiddenInfo);
            count_addinfo = layout_otherInfo.getChildCount();

            ImageButton removeOtherInfo = hiddenInfo.findViewById(R.id.ib_removeOtherInfo);
            removeOtherInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    layout_otherInfo.removeView(hiddenInfo);
                    count_addinfo--;
                }
            });
        } else if (v.getId() == R.id.submitButton) {

//            String firstName = edt_firstName.getText().toString().trim();
//            String lastName = edt_lastName.getText().toString().trim();
//            String idNo = edt_idNo.getText().toString().trim();
//            String upi = edt_upi.getText().toString().trim();
//            String birthcertificate = edt_birthCertificateNumber.getText().toString().trim();
//            String dob = edt_dateOfBirth.getText().toString().trim();
//            String nationality = edt_nationality.getText().toString().trim();
//            String subject = edt_subject.getText().toString().trim();
//            String position = edt_position.getText().toString().trim();
//            String mobileNumber = edt_mobileNumber.getText().toString().trim();
//            String contract = edt_contract.getText().toString().trim();
//            String startdate = edt_startDate.getText().toString().trim();
//            String enddate = edt_endDate.getText().toString().trim();
//
//
//
//            int selectedItem = rg_gender.getCheckedRadioButtonId();
//            if (selectedItem > 0) {
//                rb_gender = (RadioButton) findViewById(selectedItem);
//
//                String gender = rb_gender.getText().toString();
//                model.setGender(gender);
//            }try {
//                model.setFirst_name(firstName);
//                model.setLast_name(lastName);
//                model.setId_no(Integer.parseInt(idNo));
//                model.setUpi_no(Integer.parseInt(upi));
//                model.setBirth_certificate_number(Integer.parseInt(birthcertificate));
//                model.setDate_of_birth(dob);
//                model.setNationality(nationality);
//                model.setSubject(subject);
//                model.setPosition(position);
//                model.setMobile_number(Integer.parseInt(mobileNumber));
//                model.setContract(Integer.parseInt(contract));
//                model.setStart_date(startdate);
//                model.setEnd_date(enddate);
//            }catch (Exception e){
//                Log.e("Exception", e.toString());
//            }
//
//
//
//            //add experience
//            if (count_addexp > 0) {
////                final String[] arrayInstitutionName = new String[count_addexp];
////                final String[] arrayStartdate = new String[layout_expInfo.getChildCount()];
////                final String[] arrayEndDate = new String[layout_expInfo.getChildCount()];
////                final String[] arrayTeachingLevel = new String[layout_expInfo.getChildCount()];
//
//               List<Model.AddExperienceBean> addexp = new ArrayList<>();
//
//                Model.AddExperienceBean adddata = new Model.AddExperienceBean();
//                editor.putInt("array_size",count_addexp);
//                for (int i = 0; i < count_addexp; i++) {
//                    edt_expInstitutionName = (EditText) (layout_expInfo.getChildAt(i)).findViewById(R.id.edt_expInstitutionName);
//       //             arrayInstitutionName[i] = edt_expInstitutionName.getText().toString();
//               //     Log.e("aray", arrayInstitutionName[i]);
//                    edt_expStartDate = (EditText) (layout_expInfo.getChildAt(i)).findViewById(R.id.edt_expStartDate);
//         //           arrayStartdate[i] = edt_expStartDate.getText().toString();
//                    edt_expEndDate = (EditText) (layout_expInfo.getChildAt(i)).findViewById(R.id.edt_expEndDate);
//     //               arrayEndDate[i] = edt_expEndDate.getText().toString();
//                    edt_expTeachingLevel = (EditText) (layout_expInfo.getChildAt(i)).findViewById(R.id.edt_expTeachingLevel);
//        //            arrayTeachingLevel[i] = edt_expTeachingLevel.getText().toString();
//                    adddata.setInstitution_name(edt_expInstitutionName.getText().toString());
//                    adddata.setStart_date(edt_expStartDate.getText().toString());
//                    adddata.setEnd_date(edt_expEndDate.getText().toString());
//                    adddata.setTeaching_level(edt_expTeachingLevel.getText().toString());
//                    addexp.add(adddata);
//
//                    if (count_addexp_sub > 0) {
//                        String[][] arraysub = new String[layout_expInfo.getChildCount()][layout_addSubTaught.getChildCount()];
//                            for (int j = 0; j < count_addexp_sub; j++) {
//                                edt_subject_addexp = (EditText) (layout_addSubTaught.getChildAt(j).findViewById(R.id.edt_subject_addexp));
//                                arraysub[i][j] = edt_subject_addexp.getText().toString();
//
//                                Log.e("arraysub",arraysub[i][j]);
//
//                                editor.putInt("array_size1" , arraysub.length);
//                                editor.putString("arraysub_" + i + j, arraysub[i][j]);
//                            }
//                    }
//                }
//              //  editor.putInt("array_size", arrayInstitutionName.length);
//
////                for (int i = 0; i < count_addexp; i++) {
////                    editor.putString("arrayInstitutionName_" + i, arrayInstitutionName[i]);
////                    editor.putString("arrayStartdate_" + i, arrayStartdate[i]);
////                    editor.putString("arrayEndDate_" + i, arrayEndDate[i]);
////                    editor.putString("arrayTeachingLevel_" + i, arrayTeachingLevel[i]);
//
////                    for (int j = 0; j < count_sub; j++) {
////                        editor.putString("arraysub_" + i + j, arraysub[i][j]);
////                    }
//                }
//
//            }
//
//            //add teaching roles
//
//            if (count_addroles > 0) {
//                final String[] roles = new String[count_addroles];
//
//                spinner_roles=new String[spinnerList.size()];
//           for (int i =0; i<spinnerList.size(); i++) {
//                spinner_roles[i] = spinnerList.get(i).getSelectedItem().toString();
//               Log.e("spinner_roles",spinner_roles[i]);
//               editor.putString("spinnerroles_" + i, spinner_roles[i]);
//           }
//
//
////                spinner_roles = new String[count_addroles];
////
////                spinner_Roles_Subject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
////                    @Override
////                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
////
////                        if(position > 0) {
////                            if (count_addroles > 0){
////                                for (int i =0; i<count_addroles; i++){
////                                    spinner_roles[i] = spinner_Roles_Subject.getSelectedItem().toString();
////
////                                    Log.e("spinner_roles",spinner_roles.toString());
////
////                                    editor.putString("spinnerroles_" + i, spinner_roles[i]);
////                                }
////                            }
////                        }
////                    }
////
////                    @Override
////                    public void onNothingSelected(AdapterView<?> parent) {
////
////                    }
////                });
//
//                String[][] array_roles_sub = new String[count_addroles][count_addroles_sub];
////                ArrayList<String> array_roles_sub = new ArrayList<String>();
//                for (int i = 0; i < count_addroles; i++) {
//
//                    if (count_addroles_sub > 0) {
//                        for (int j = 0; j < count_addroles_sub; j++) {
//                            //edt_subject_addroles = (EditText) (layout_addroleSub.getChildAt(j).findViewById(R.id.edt_subject_addexp));
//                       //     array_roles_sub[i][j] = mainsubList.get(i).get(j).getText().toString();
//                            editor.putString("arrayrolessub_" + i + j, array_roles_sub[i][j]);
//                            Log.e("array_roles_sub"+i+j,array_roles_sub[i][j]);
//                        }
//                    }
//                }
//
//
//                int[] subsize = new int[count_addroles];
////                for (int i=0;i<mainsubList.size();i++){
////                    subsize[i] = mainsubList.get(i).size();
////                    editor.putInt("subsize" + i,subsize[i]);
////                    Log.e("subsize"+i,String.valueOf(subsize[i]));
////                }
//                editor.putInt("array_roles_sub_size1", count_addroles_sub);
//                editor.putInt("array_size_addroles",count_addroles);
//
////                for (int i = 0; i < count_addexp; i++) {
////                    editor.putString("spinnerroles_" + i, spinner_roles[i]);
////                    Log.e("spinnerroles_",spinner_roles[i]);
////                }
//            }
//
//            //add additional info
//            //add experience
//            if (count_addinfo > 0) {
//                final String[] array_addInfo = new String[count_addinfo];
//
//                for (int i = 0; i < count_addinfo; i++) {
//                    edt_addInfo = (EditText) (layout_otherInfo.getChildAt(i)).findViewById(R.id.edt_addInfo);
//                    array_addInfo[i] = edt_addInfo.getText().toString();
//                    Log.e("aray", array_addInfo[i]);
//                }
//                editor.putInt("array_addinfo_size", array_addInfo.length);
//
//                for (int i = 0; i < count_addinfo; i++) {
//                    editor.putString("arrayAdditionalInfo_" + i, array_addInfo[i]);
//
//                }
//
//            }
//
//
//            Intent i = new Intent(MainActivity.this, DataView.class);
//            i.putExtra("Data",model);
//            editor.apply();
//            startActivity(i);
            submitButtonclick();
        }

    }

    public void submitButtonclick() {
        String firstName = edt_firstName.getText().toString().trim();
        String lastName = edt_lastName.getText().toString().trim();
        String idNo = edt_idNo.getText().toString().trim();
        String upi = edt_upi.getText().toString().trim();
        String birthcertificate = edt_birthCertificateNumber.getText().toString().trim();
        String dob = edt_dateOfBirth.getText().toString().trim();
        String nationality = edt_nationality.getText().toString().trim();
        String subject = edt_subject.getText().toString().trim();
        String position = edt_position.getText().toString().trim();
        String mobileNumber = edt_mobileNumber.getText().toString().trim();
        String contract = edt_contract.getText().toString().trim();
        String startdate = edt_startDate.getText().toString().trim();
        String enddate = edt_endDate.getText().toString().trim();


        int selectedItem = rg_gender.getCheckedRadioButtonId();
        if (selectedItem > 0) {
            rb_gender = (RadioButton) findViewById(selectedItem);

            String gender = rb_gender.getText().toString();
            model.setGender(gender);
        }
        try {
            model.setFirst_name(firstName);
            model.setLast_name(lastName);
            model.setId_no(Integer.parseInt(idNo));
            model.setUpi_no(Integer.parseInt(upi));
            model.setBirth_certificate_number(Integer.parseInt(birthcertificate));
            model.setDate_of_birth(dob);
            model.setNationality(nationality);
            model.setSubject(subject);
            model.setPosition(position);
            model.setMobile_number(Integer.parseInt(mobileNumber));
            model.setContract(Integer.parseInt(contract));
            model.setStart_date(startdate);
            model.setEnd_date(enddate);
        } catch (Exception e) {
            Log.e("Exception", e.toString());
        }


        //add experience
        if (count_addexp > 0) {

             addExperienceBeans = new ArrayList<>();
             addSubTaughtBeans = new ArrayList<>();
//                final String[] arrayInstitutionName = new String[count_addexp];
//                final String[] arrayStartdate = new String[layout_expInfo.getChildCount()];
//                final String[] arrayEndDate = new String[layout_expInfo.getChildCount()];
//                final String[] arrayTeachingLevel = new String[layout_expInfo.getChildCount()];

//            List<Model.AddExperienceBean> addexp = new ArrayList<>();
//
//            Model.AddExperienceBean adddata = new Model.AddExperienceBean();
//            editor.putInt("array_size",count_addexp);
//            for (int i = 0; i < count_addexp; i++) {
//                edt_expInstitutionName = (EditText) (layout_expInfo.getChildAt(i)).findViewById(R.id.edt_expInstitutionName);
//                //             arrayInstitutionName[i] = edt_expInstitutionName.getText().toString();
//                //     Log.e("aray", arrayInstitutionName[i]);
//                edt_expStartDate = (EditText) (layout_expInfo.getChildAt(i)).findViewById(R.id.edt_expStartDate);
//                //           arrayStartdate[i] = edt_expStartDate.getText().toString();
//                edt_expEndDate = (EditText) (layout_expInfo.getChildAt(i)).findViewById(R.id.edt_expEndDate);
//                //               arrayEndDate[i] = edt_expEndDate.getText().toString();
//                edt_expTeachingLevel = (EditText) (layout_expInfo.getChildAt(i)).findViewById(R.id.edt_expTeachingLevel);
//                //            arrayTeachingLevel[i] = edt_expTeachingLevel.getText().toString();
//                adddata.setInstitution_name(edt_expInstitutionName.getText().toString());
//                adddata.setStart_date(edt_expStartDate.getText().toString());
//                adddata.setEnd_date(edt_expEndDate.getText().toString());
//                adddata.setTeaching_level(edt_expTeachingLevel.getText().toString());
//                addexp.add(adddata);
//
//                if (count_addexp_sub > 0) {
//                    String[][] arraysub = new String[layout_expInfo.getChildCount()][layout_addSubTaught.getChildCount()];
//                    for (int j = 0; j < count_addexp_sub; j++) {
//                        edt_subject_addexp = (EditText) (layout_addSubTaught.getChildAt(j).findViewById(R.id.edt_subject_addexp));
//                        arraysub[i][j] = edt_subject_addexp.getText().toString();
//
//                        Log.e("arraysub",arraysub[i][j]);
//
//                        editor.putInt("array_size1" , arraysub.length);
//                        editor.putString("arraysub_" + i + j, arraysub[i][j]);
//                    }
            //              }
            //          }
            //  editor.putInt("array_size", arrayInstitutionName.length);

//                for (int i = 0; i < count_addexp; i++) {
//                    editor.putString("arrayInstitutionName_" + i, arrayInstitutionName[i]);
//                    editor.putString("arrayStartdate_" + i, arrayStartdate[i]);
//                    editor.putString("arrayEndDate_" + i, arrayEndDate[i]);
//                    editor.putString("arrayTeachingLevel_" + i, arrayTeachingLevel[i]);

//                    for (int j = 0; j < count_sub; j++) {
//                        editor.putString("arraysub_" + i + j, arraysub[i][j]);
//                    }
            //     }


            //add teaching roles
//
//            if (count_addroles > 0) {
//        final String[] roles = new String[count_addroles];
//
//        spinner_roles=new String[spinnerList.size()];
//        for (int i =0; i<spinnerList.size(); i++) {
//            spinner_roles[i] = spinnerList.get(i).getSelectedItem().toString();
//            Log.e("spinner_roles",spinner_roles[i]);
//            editor.putString("spinnerroles_" + i, spinner_roles[i]);
//        }


//                spinner_roles = new String[count_addroles];
//
//                spinner_Roles_Subject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//                    @Override
//                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//                        if(position > 0) {
//                            if (count_addroles > 0){
//                                for (int i =0; i<count_addroles; i++){
//                                    spinner_roles[i] = spinner_Roles_Subject.getSelectedItem().toString();
//
//                                    Log.e("spinner_roles",spinner_roles.toString());
//
//                                    editor.putString("spinnerroles_" + i, spinner_roles[i]);
//                                }
//                            }
//                        }
//                    }
//
//                    @Override
//                    public void onNothingSelected(AdapterView<?> parent) {
//
//                    }
//                });
//
//        String[][] array_roles_sub = new String[count_addroles][count_addroles_sub];
////                ArrayList<String> array_roles_sub = new ArrayList<String>();
//        for (int i = 0; i < count_addroles; i++) {
//
//            if (count_addroles_sub > 0) {
//                for (int j = 0; j < count_addroles_sub; j++) {
//                    //edt_subject_addroles = (EditText) (layout_addroleSub.getChildAt(j).findViewById(R.id.edt_subject_addexp));
//                    //     array_roles_sub[i][j] = mainsubList.get(i).get(j).getText().toString();
//                    editor.putString("arrayrolessub_" + i + j, array_roles_sub[i][j]);
//                    Log.e("array_roles_sub"+i+j,array_roles_sub[i][j]);
//                }
//            }
//        }
//
//
//        int[] subsize = new int[count_addroles];
////                for (int i=0;i<mainsubList.size();i++){
////                    subsize[i] = mainsubList.get(i).size();
////                    editor.putInt("subsize" + i,subsize[i]);
////                    Log.e("subsize"+i,String.valueOf(subsize[i]));
////                }
//        editor.putInt("array_roles_sub_size1", count_addroles_sub);
//        editor.putInt("array_size_addroles",count_addroles);
//
////                for (int i = 0; i < count_addexp; i++) {
////                    editor.putString("spinnerroles_" + i, spinner_roles[i]);
////                    Log.e("spinnerroles_",spinner_roles[i]);
////                }
//    }
//
//    //add additional info
//    //add experience
//            if (count_addinfo > 0) {
//        final String[] array_addInfo = new String[count_addinfo];
//
//        for (int i = 0; i < count_addinfo; i++) {
//            edt_addInfo = (EditText) (layout_otherInfo.getChildAt(i)).findViewById(R.id.edt_addInfo);
//            array_addInfo[i] = edt_addInfo.getText().toString();
//            Log.e("aray", array_addInfo[i]);
//        }
//        editor.putInt("array_addinfo_size", array_addInfo.length);
//
//        for (int i = 0; i < count_addinfo; i++) {
//            editor.putString("arrayAdditionalInfo_" + i, array_addInfo[i]);
//
//        }
//
//    }

//            EditText edt_expInstitutionName = layout_expInfo.findViewById(R.id.edt_expInstitutionName);
//            EditText edt_expStartDate = layout_expInfo.findViewById(R.id.edt_expStartDate);
//            EditText edt_expEndDate = layout_expInfo.findViewById(R.id.edt_expEndDate);
//            EditText edt_expTeachingLevel = layout_expInfo.findViewById(R.id.edt_expTeachingLevel);
//
//            addex.setInstitution_name(edt_expInstitutionName.getText().toString());
//            addex.setStart_date(edt_expStartDate.getText().toString());
//            addex.setEnd_date(edt_expEndDate.getText().toString());
//            addex.setTeaching_level(edt_expTeachingLevel.getText().toString());

            editor.putInt("array_size",count_addexp);

            //addExperienceBeans.add(addex);

            for (int i=0;i<layout_expInfo.getChildCount();i++){
                EditText edt_expInstitutionName = layout_expInfo.getChildAt(i).findViewById(R.id.edt_expInstitutionName);
                EditText edt_expTeachingLevel = layout_expInfo.getChildAt(i).findViewById(R.id.edt_expTeachingLevel);
                EditText edt_expStartDate = layout_expInfo.getChildAt(i).findViewById(R.id.edt_expStartDate);
                EditText edt_expEndDate = layout_expInfo.getChildAt(i).findViewById(R.id.edt_expEndDate);

//                addexpedit_instname.add(edt_expInstitutionName);
//                addexpedit_startdate.add(edt_expStartDate);
//                addexpedit_enddate.add(edt_expEndDate);
//                addexpedit_teachinglevel.add(edt_expTeachingLevel);

//                String startdatestr = addexpedit_startdate.get(i).getText().toString();
  //
                //              String enddatestr = addexpedit_enddate.get(i).getText().toString();

                Model.AddExperienceBean addex = new Model.AddExperienceBean();

                addex.setInstitution_name(edt_expInstitutionName.getText().toString());
                addex.setStart_date(edt_expStartDate.getText().toString());
                addex.setEnd_date(edt_expEndDate.getText().toString());
                addex.setTeaching_level(edt_expTeachingLevel.getText().toString());

                addExperienceBeans.add(addex);

                if (count_addexp_sub > 0) {
                    int count[] = new int[layout_expInfo.getChildCount()];
                    count[i] = layout_addSubTaught.getChildCount();

                    if (count[i] > 0) {
                        for (int j = 0; j < layout_addSubTaught.getChildCount(); j++) {
                            EditText edt_addsubtaught = layout_addSubTaught.getChildAt(j).findViewById(R.id.edt_subject_addexp);

                            Model.AddExperienceBean.AddSubTaughtBean addsub = new Model.AddExperienceBean.AddSubTaughtBean();

                            addsub.setSubject(edt_addsubtaught.getText().toString());
                            addSubTaughtBeans.add(addsub);
                        }
                    }
                }
            }

//            for (int i=0;i<layout_expInfo.getChildCount();i++){
//
//                Model.AddExperienceBean addex = new Model.AddExperienceBean();
//
//                addex.setInstitution_name(addexpedit_instname.get(i).getText().toString());
//                addex.setStart_date(addexpedit_startdate.get(i).getText().toString());
//                addex.setEnd_date(addexpedit_enddate.get(i).getText().toString());
//                addex.setTeaching_level(addexpedit_teachinglevel.get(i).getText().toString());
//
//                addExperienceBeans.add(addex);
//            }
        }
            Intent i = new Intent(MainActivity.this, DataView.class);
            i.putExtra("Data", model);
            i.putExtra("data", (Serializable) addExperienceBeans);
            i.putExtra("expsub", (Serializable) addSubTaughtBeans);
            editor.apply();
            startActivity(i);
        }


        public void addExperience(){
            layout_expInfo = (LinearLayout) findViewById(R.id.layout_expInfo);

            final View hiddenInfo = getLayoutInflater().inflate(R.layout.add_experience_row_details, layout_expInfo, false);
            layout_expInfo.addView(hiddenInfo);

            count_addexp = layout_expInfo.getChildCount();
  //          Model.AddExperienceBean addexp = new Model.AddExperienceBean();

//            EditText edt_expInstitutionName = layout_expInfo.findViewById(R.id.edt_expInstitutionName);
//            EditText edt_expStartDate = layout_expInfo.findViewById(R.id.edt_expStartDate);
//            EditText edt_expEndDate = layout_expInfo.findViewById(R.id.edt_expEndDate);
//            EditText edt_expTeachingLevel = layout_expInfo.findViewById(R.id.edt_expTeachingLevel);
//
//                addexpedit_instname.add(edt_expInstitutionName);
//                addexpedit_startdate.add(edt_expStartDate);
//                addexpedit_enddate.add(edt_expEndDate);
//                addexpedit_teachinglevel.add(edt_expTeachingLevel);

//            addexpedit.add(edt_expInstitutionName);
//            addexpedit.add(edt_expStartDate);
//            addexpedit.add(edt_expEndDate);
//            addexpedit.add(edt_expTeachingLevel);
//
//            mailexpList.add(addexpedit_instname);
//            mailexpList.add(addexpedit_startdate);
//            mailexpList.add(addexpedit_enddate);
//            mailexpList.add(addexpedit_teachinglevel);

            //pos++;
            final EditText edt_expStartDate = layout_expInfo.findViewById(R.id.edt_expStartDate);
            final EditText edt_expEndDate = layout_expInfo.findViewById(R.id.edt_expEndDate);

            edt_expStartDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Calendar calendar = Calendar.getInstance();
                    int year = calendar.get(Calendar.YEAR);
                    int month = calendar.get(Calendar.MONTH);
                    int day = calendar.get(Calendar.DAY_OF_MONTH);
                    datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            edt_expStartDate.setText(dayOfMonth+"-"+(month+1)+"-"+year);
                        }
                    },year,month,day);
                    datePickerDialog.show();
                }
            });

            edt_expEndDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Calendar calendar = Calendar.getInstance();
                    int year = calendar.get(Calendar.YEAR);
                    int month = calendar.get(Calendar.MONTH);
                    int day = calendar.get(Calendar.DAY_OF_MONTH);
                    datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            edt_expEndDate.setText(dayOfMonth+"-"+(month+1)+"-"+year);
                        }
                    },year,month,day);
                    datePickerDialog.show();
                }
            });

            ImageButton removeExpInfo = hiddenInfo.findViewById(R.id.ib_removeExpInfo);
            removeExpInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    layout_expInfo.removeView(hiddenInfo);
                    count_addexp--;
                }
            });

            ImageButton ib_addSubjectTaught = hiddenInfo.findViewById(R.id.ib_addSubjectTaught);
            ib_addSubjectTaught.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    layout_addSubTaught = (LinearLayout) hiddenInfo.findViewById(R.id.layout_addSubTaught);
                    final View add_subjectView = getLayoutInflater().inflate(R.layout.add_subjects_row_details, layout_addSubTaught, false);
                    layout_addSubTaught.addView(add_subjectView);
                    count_addexp_sub = layout_addSubTaught.getChildCount();

                    edt_addsubtaught = layout_addSubTaught.findViewById(R.id.edt_subject_addexp);
                    String tag=""+c+","+pos;
                    edt_addsubtaught.setTag(tag);

                 //   addexpedit_teachinglevel.add(edt_addsubtaught);
                    pos++;
                    edt_addsubtaught.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                        }

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {
                            Log.d("HAHAHHAAHA",edt_addsubtaught.getTag().toString()) ;
                            Log.d("HAHAHHAAHA",s.toString()) ;
                        }

                        @Override
                        public void afterTextChanged(Editable s) {
                           Log.d("HAHAHHAAHA",edt_addsubtaught.getTag().toString()) ;
                           Log.d("HAHAHHAAHA",s.toString()) ;

                        }
                    });

                    ImageButton ib_removeSubjectTaught = (ImageButton) add_subjectView.findViewById(R.id.ib_removeSubjectTaught);
                    ib_removeSubjectTaught.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            layout_addSubTaught.removeView(add_subjectView);
                            count_addexp_sub--;
                        }
                    });
                }
            });
            c++;
            pos = 0;
        }

        public void addTechingRoles(){
            layout_teachingRoles = (LinearLayout) findViewById(R.id.layout_teachingRoles);
            final View hiddenInfo = getLayoutInflater().inflate(R.layout.add_teaching_roles_details,layout_teachingRoles,false);
            layout_teachingRoles.addView(hiddenInfo);
            count_addroles = layout_teachingRoles.getChildCount();

            spinner_Roles_Subject = (Spinner)hiddenInfo.findViewById(R.id.spinnerRoles) ;
            spinnerList.add(spinner_Roles_Subject);

            //String array
            String[] class_array = new String[]{"Role",
                    "Class 1","Class 2","Class 3","Class 4","Class 5","Class 6",
                    "Class 7","Class 8","Class 9","Class 10","Class 11","Class 12" };

            List<String> rolesList = new ArrayList<>(Arrays.asList(class_array));

            ArrayAdapter<String> adapterroles = new ArrayAdapter<String>(this,R.layout.spinner_item,
                    rolesList){
                @Override
                public boolean isEnabled(int position){
                    if(position == 0)
                    {
                        // Disable the first item from Spinner
                        // First item will be use for hint
                        return false;
                    }
                    else
                    {
                        return true;
                    }
                }
                @Override
                public View getDropDownView(int position, View convertView,
                                            ViewGroup parent) {
                    View view = super.getDropDownView(position, convertView, parent);
                    TextView tv = (TextView) view;
                    if(position == 0){
                        // Set the hint text color gray
                        tv.setTextColor(Color.BLACK);
                    }
                    else {
                        tv.setTextColor(Color.BLACK);
                    }
                    return view;
                }
            };

            adapterroles.setDropDownViewResource(R.layout.spinner_item);
            spinner_Roles_Subject.setAdapter(adapterroles);



            ImageButton removeRoles_Subject = hiddenInfo.findViewById(R.id.ib_removeRoles_Subject);
            removeRoles_Subject.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    layout_teachingRoles.removeView(hiddenInfo);
                    count_addroles--;
                }
            });

            int[] mainsize = new int[count_addroles];
            final int[][] subsize = new int[count_addroles][count_addroles_sub];

            ImageButton ib_addSubjectTaught = hiddenInfo.findViewById(R.id.ib_addSubjectTaught);
            ib_addSubjectTaught.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    layout_addroleSub = (LinearLayout) hiddenInfo.findViewById(R.id.layout_addroleSub);
                    final View add_subjectView = getLayoutInflater().inflate(R.layout.add_subjects_row_details, layout_addroleSub, false);
                    layout_addroleSub.addView(add_subjectView);
                    count_addroles_sub = layout_addroleSub.getChildCount();
                    edt_subject_addroles = (EditText) add_subjectView.findViewById(R.id.edt_subject_addexp);
                    ImageButton ib_removeSubjectTaught = (ImageButton) add_subjectView.findViewById(R.id.ib_removeSubjectTaught);
                    ib_removeSubjectTaught.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            layout_addroleSub.removeView(add_subjectView);
                            count_addroles_sub--;
                          //  pos--;
                        }
                    });
                    // pos = layout_addroleSub.indexOfChild(layout_teachingRoles)+1;
                    //addroleSubList.add(edt_subject_addroles);
                    //pos++;
                }
            });
            //mainsubList.add(addroleSubList);
        }
    }
